package shoo.competentum.server.populators;

import org.junit.Test;
import shoo.competentum.shared.Customer;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class SetPopulatorTest {

	@Test
	public void testGenerateCustomersSet() throws Exception {
		int males = 0;
		int females = 0;
		int children = 0;
		ArrayList<Customer> customers = SetPopulator.generateCustomersSet(20, 30, 10);
		for (Customer customer : customers) {
			switch (customer.getKind()) {
				case MALE:
					males++;
					break;
				case FEMALE:
					females++;
					break;
				case CHILD:
					children++;
			}
		}
		assertEquals(males, 2);
		assertEquals(females, 3);
		assertEquals(children, 5);
	}
}