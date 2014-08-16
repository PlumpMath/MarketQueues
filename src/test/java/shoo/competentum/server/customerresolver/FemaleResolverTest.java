package shoo.competentum.server.customerresolver;

import org.junit.Before;
import org.junit.Test;
import shoo.competentum.shared.CheckoutCounter;
import shoo.competentum.shared.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;
public class FemaleResolverTest {

	CustomerResolver resolver;

	@Before
	public void setUp() throws Exception {
		resolver = new FemaleResolver();
	}

	@Test
	public void testChooseCounter() throws Exception {
		ArrayList<CheckoutCounter> countersList = new ArrayList<CheckoutCounter>();
		CheckoutCounter checkoutCounter1 = new CheckoutCounter();
		checkoutCounter1.getCurrentState().getQueue().addAll(Arrays.asList(new Customer(), new Customer(), new Customer()));
		countersList.add(checkoutCounter1);
		CheckoutCounter checkoutCounter2 = new CheckoutCounter();
		countersList.add(checkoutCounter2);
		CheckoutCounter checkoutCounter3 = new CheckoutCounter();
		checkoutCounter3.getCurrentState().getQueue().addAll(Arrays.asList(new Customer(), new Customer(), new Customer(), new Customer()));
		countersList.add(checkoutCounter3);

		assertEquals(checkoutCounter2, resolver.chooseCounter(countersList));

		checkoutCounter2.getCurrentState().getQueue().addAll(Arrays.asList(new Customer(),  new Customer(), new Customer(), new Customer()));

		assertEquals(checkoutCounter1, resolver.chooseCounter(countersList));

	}
}