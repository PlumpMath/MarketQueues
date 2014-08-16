package shoo.competentum.server.customerresolver;

import org.junit.Before;
import org.junit.Test;
import shoo.competentum.shared.CheckoutCounter;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;


public class ChildResolverTest {
	CustomerResolver resolver;

	@Before
	public void setUp() throws Exception {
		resolver = new ChildResolver();
	}

	@Test
	public void testChooseCounter() throws Exception {
		HashMap<CheckoutCounter, Integer> choiceCounts = new HashMap<CheckoutCounter, Integer>();
		ArrayList<CheckoutCounter> countersList = new ArrayList<CheckoutCounter>();
		int numCounters = 5;
		int numSteps = 100;
		for (int i = 0; i < numCounters; i++) {
			CheckoutCounter counter = new CheckoutCounter();
			choiceCounts.put(counter, 0);
			countersList.add(counter);
		}

		for (int i = 0; i < numSteps; i++) {
			CheckoutCounter checkoutCounter = resolver.chooseCounter(countersList);
			int choices = choiceCounts.get(checkoutCounter);
			choiceCounts.put(checkoutCounter, ++choices);
		}
		for (int choices : choiceCounts.values()) {
			assertThat(choices, greaterThan(5));
		}
		// на большом количестве запусков рандом должен попасть в каждую кассу хотя бы небольшое количество раз
		// теоретически такой тест может завалиться (на самом деле, не уверен - это зависит от реализации рандома, может ситуация и невозможна),
		// если и завалится - лучше пусть один раз завалится, чем не проверять логику. всегда можно запустить тесты заново - и все будет ок.
	}
}