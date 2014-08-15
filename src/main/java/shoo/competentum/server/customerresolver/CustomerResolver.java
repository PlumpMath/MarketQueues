package shoo.competentum.server.customerresolver;

import shoo.competentum.shared.CheckoutCounter;

import java.util.ArrayList;


public interface CustomerResolver {
	public CheckoutCounter chooseCounter(ArrayList<CheckoutCounter> checkoutCounters);
}
