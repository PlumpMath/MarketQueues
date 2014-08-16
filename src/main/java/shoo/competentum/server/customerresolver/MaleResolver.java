package shoo.competentum.server.customerresolver;

import shoo.competentum.shared.CheckoutCounter;
import shoo.competentum.shared.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class MaleResolver implements CustomerResolver {

	public CheckoutCounter chooseCounter(ArrayList<CheckoutCounter> checkoutCounters) {
		CheckoutCounter[] clone = checkoutCounters.toArray(new CheckoutCounter[checkoutCounters.size()]);
				Arrays.sort(
						clone,
						new Comparator<CheckoutCounter>() {
							public int compare(CheckoutCounter o, CheckoutCounter o2) {
								return calculateNumberOfSteps(o) - calculateNumberOfSteps(o2);
							}
						}
				);
				return clone[0];
	}

	private int calculateNumberOfSteps(CheckoutCounter counter ) {
		int steps = 0;
		for (Customer customer : counter.getCurrentState().getQueue()) {
			int items = customer.getItemsInCart();
			int performance = counter.getPerformance();
			steps += Math.floor( items / performance ) + ( items % performance == 0 ? 0 : 1 );
		}
		return steps;
	}

}
