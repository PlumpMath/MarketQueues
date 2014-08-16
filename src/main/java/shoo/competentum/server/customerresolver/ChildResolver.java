package shoo.competentum.server.customerresolver;

import shoo.competentum.shared.CheckoutCounter;

import java.util.ArrayList;
import java.util.Random;


public class ChildResolver implements CustomerResolver {
	private static final Random RND = new Random();

	public CheckoutCounter chooseCounter(ArrayList<CheckoutCounter> checkoutCounters) {
		return checkoutCounters.get(RND.nextInt(checkoutCounters.size()));
	}
}
