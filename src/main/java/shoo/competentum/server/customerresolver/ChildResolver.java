package shoo.competentum.server.customerresolver;

import shoo.competentum.shared.CheckoutCounter;

import java.util.ArrayList;


public class ChildResolver implements CustomerResolver {

	public CheckoutCounter chooseCounter(ArrayList<CheckoutCounter> checkoutCounters) {
		return checkoutCounters.get(0);
	}
}
