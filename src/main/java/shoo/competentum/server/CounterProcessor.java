package shoo.competentum.server;

import shoo.competentum.server.customerresolver.ChildResolver;
import shoo.competentum.server.customerresolver.CustomerResolver;
import shoo.competentum.server.customerresolver.FemaleResolver;
import shoo.competentum.server.customerresolver.MaleResolver;
import shoo.competentum.server.populators.Populator;
import shoo.competentum.server.populators.RandomPopulator;
import shoo.competentum.shared.CheckoutCounter;
import shoo.competentum.shared.Customer;
import shoo.competentum.shared.CustomerKind;
import shoo.competentum.shared.State;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class CounterProcessor {
	private final int MIN_PERFORMANCE = 1;
	private final int MAX_PERFORMANCE = 5;
	private final Random RND = new Random();
	private ArrayList<CheckoutCounter> counters = new ArrayList<CheckoutCounter>();
	private Populator populator;


	public CounterProcessor() {
		this(3);
		populator = new RandomPopulator();
	}


	public CounterProcessor(int numCounters) {
		for (int i = 0; i < numCounters; i++) {
			counters.add(
					new CheckoutCounter(RND.nextInt(MAX_PERFORMANCE - MIN_PERFORMANCE) + MIN_PERFORMANCE)
			);
		}
	}

	public List<CheckoutCounter> launch(int numSteps) {
		for (int i=0; i < numSteps; i++) {
			step();
		}
		return counters;
	}

	private void step() {
		try {
			populate();
		} catch (Exception e) {
			System.out.print("Populate fails");
			e.printStackTrace();
		}
		for (CheckoutCounter counter : counters) {
			try {
				processCounter(counter);
			} catch (Exception e) {
				System.out.print("Process fails");
				e.printStackTrace();
			}
		}
	}

	private void populate() {
		Customer customer = populator.populate();
		CustomerResolver resolver = getResolver(customer);
		CheckoutCounter targetCounter = resolver.chooseCounter(counters);
		State currentState = targetCounter.getCurrentState();
		currentState.getQueue().add(customer);
		currentState.setCustomerAdded(true);
	}

	private void processCounter(CheckoutCounter counter) {
		State currentState = counter.createState();
		Customer currentCustomer = currentState.getQueue().peek();
		if (currentCustomer!=null) {
			int numItems = currentCustomer.getItemsInCart();
			if (numItems > counter.getPerformance()) {
				currentCustomer.setItemsInCart(numItems - counter.getPerformance());
			} else {
				currentCustomer.setItemsInCart(0);
				currentState.getQueue().removeFirst();
			}
		}
	}


	private CustomerResolver getResolver(Customer customer) {
		switch (customer.getKind()) {
			case MALE:
				return new MaleResolver(customer);
			case FEMALE:
				return new FemaleResolver();
			case CHILD:
				return new ChildResolver();
		}
		return null;
	}
}
