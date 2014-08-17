package shoo.competentum.server.customerresolver;

import org.junit.Before;
import org.junit.Test;
import shoo.competentum.shared.CheckoutCounter;
import shoo.competentum.shared.Customer;
import shoo.competentum.shared.CustomerKind;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class MaleResolverTest {
	CustomerResolver resolver;

	@Before
	public void setUp() throws Exception {
		resolver = new MaleResolver(new Customer(5, CustomerKind.MALE));
	}


	@Test
	public void should_take_into_account_number_of_customers() throws Exception {
		ArrayList<CheckoutCounter> countersList = new ArrayList<CheckoutCounter>();
		CheckoutCounter checkoutCounter1 = new CheckoutCounter(1);
		checkoutCounter1.getCurrentState().getQueue().addAll(Arrays.asList(new Customer(1, CustomerKind.CHILD), new Customer(1, CustomerKind.CHILD), new Customer(1, CustomerKind.CHILD)));
		countersList.add(checkoutCounter1);
		CheckoutCounter checkoutCounter2 = new CheckoutCounter(1);
		countersList.add(checkoutCounter2);
		CheckoutCounter checkoutCounter3 = new CheckoutCounter(1);
		checkoutCounter3.getCurrentState().getQueue().addAll(Arrays.asList(new Customer(1, CustomerKind.CHILD), new Customer(1, CustomerKind.CHILD), new Customer(1, CustomerKind.CHILD), new Customer()));
		countersList.add(checkoutCounter3);

		assertEquals(checkoutCounter2, resolver.chooseCounter(countersList));

		checkoutCounter2.getCurrentState().getQueue().addAll(Arrays.asList(new Customer(1, CustomerKind.CHILD), new Customer(1, CustomerKind.CHILD), new Customer(1, CustomerKind.CHILD), new Customer()));

		assertEquals(checkoutCounter1, resolver.chooseCounter(countersList));

	}

	@Test
	public void should_take_into_account_number_of_items() throws Exception {
		ArrayList<CheckoutCounter> countersList = new ArrayList<CheckoutCounter>();
		CheckoutCounter checkoutCounter1 = new CheckoutCounter(1);
		checkoutCounter1.getCurrentState().getQueue().addAll(Arrays.asList(new Customer(1, CustomerKind.CHILD), new Customer(2, CustomerKind.CHILD)));
		countersList.add(checkoutCounter1);
		CheckoutCounter checkoutCounter2 = new CheckoutCounter(1);
		checkoutCounter2.getCurrentState().getQueue().addAll(Arrays.asList(new Customer(1, CustomerKind.CHILD), new Customer(1, CustomerKind.CHILD)));
		countersList.add(checkoutCounter2);
		CheckoutCounter checkoutCounter3 = new CheckoutCounter(1);
		checkoutCounter3.getCurrentState().getQueue().addAll(Arrays.asList(new Customer(1, CustomerKind.CHILD), new Customer(3, CustomerKind.CHILD)));
		countersList.add(checkoutCounter3);

		assertEquals(checkoutCounter2, resolver.chooseCounter(countersList));
	}

	@Test
	public void should_take_into_account_counter_performance() throws Exception {
		ArrayList<CheckoutCounter> countersList = new ArrayList<CheckoutCounter>();
		CheckoutCounter checkoutCounter1 = new CheckoutCounter(1);
		checkoutCounter1.getCurrentState().getQueue().addAll(Arrays.asList(new Customer(3, CustomerKind.CHILD), new Customer(3, CustomerKind.CHILD)));
		countersList.add(checkoutCounter1);
		CheckoutCounter checkoutCounter2 = new CheckoutCounter(2);
		checkoutCounter2.getCurrentState().getQueue().addAll(Arrays.asList(new Customer(3, CustomerKind.CHILD), new Customer(3, CustomerKind.CHILD)));
		countersList.add(checkoutCounter2);
		CheckoutCounter checkoutCounter3 = new CheckoutCounter(3);
		checkoutCounter3.getCurrentState().getQueue().addAll(Arrays.asList(new Customer(3, CustomerKind.CHILD), new Customer(3, CustomerKind.CHILD)));
		countersList.add(checkoutCounter3);

		assertEquals(checkoutCounter3, resolver.chooseCounter(countersList));
	}

	@Test
	public void should_calculate_number_of_steps() throws Exception {
		ArrayList<CheckoutCounter> countersList = new ArrayList<CheckoutCounter>();
		CheckoutCounter checkoutCounter1 = new CheckoutCounter(1);
		checkoutCounter1.getCurrentState().getQueue().addAll(Arrays.asList(new Customer(1, CustomerKind.CHILD), new Customer(1, CustomerKind.CHILD), new Customer(1, CustomerKind.CHILD)));
		countersList.add(checkoutCounter1);
		CheckoutCounter checkoutCounter2 = new CheckoutCounter(2);
		checkoutCounter2.getCurrentState().getQueue().addAll(Arrays.asList(new Customer(2, CustomerKind.CHILD), new Customer(2, CustomerKind.CHILD)));
		countersList.add(checkoutCounter2);
		CheckoutCounter checkoutCounter3 = new CheckoutCounter(3);
		checkoutCounter3.getCurrentState().getQueue().addAll(Arrays.asList(new Customer(4, CustomerKind.CHILD), new Customer(2, CustomerKind.CHILD)));
		countersList.add(checkoutCounter3);

		assertEquals(checkoutCounter2, resolver.chooseCounter(countersList));

		checkoutCounter2.getCurrentState().getQueue().add(new Customer(2, CustomerKind.CHILD));
		checkoutCounter3.setPerformance(5);

		assertEquals(checkoutCounter3, resolver.chooseCounter(countersList));
	}

	@Test
	public void should_take_into_account_owned_items() throws Exception {
		ArrayList<CheckoutCounter> countersList = new ArrayList<CheckoutCounter>();
		CheckoutCounter checkoutCounter1 = new CheckoutCounter(1);
		countersList.add(checkoutCounter1);
		CheckoutCounter checkoutCounter2 = new CheckoutCounter(2);
		checkoutCounter2.getCurrentState().getQueue().addAll(Arrays.asList(new Customer(2, CustomerKind.CHILD)));
		countersList.add(checkoutCounter2);


		assertEquals(checkoutCounter2, resolver.chooseCounter(countersList));

	}


}