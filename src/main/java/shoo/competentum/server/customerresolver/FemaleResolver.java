package shoo.competentum.server.customerresolver;

import shoo.competentum.shared.CheckoutCounter;

import java.util.ArrayList;

public class FemaleResolver implements CustomerResolver {
	public CheckoutCounter chooseCounter(ArrayList<CheckoutCounter> checkoutCounters) {
		return checkoutCounters.get(checkoutCounters.size() - 1);
	}
}
