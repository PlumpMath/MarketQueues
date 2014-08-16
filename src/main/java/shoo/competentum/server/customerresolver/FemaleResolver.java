package shoo.competentum.server.customerresolver;

import shoo.competentum.shared.CheckoutCounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FemaleResolver implements CustomerResolver {
	public CheckoutCounter chooseCounter(ArrayList<CheckoutCounter> checkoutCounters) {
		CheckoutCounter[] clone = checkoutCounters.toArray(new CheckoutCounter[checkoutCounters.size()]);
		Arrays.sort(
				clone,
				new Comparator<CheckoutCounter>() {
					public int compare(CheckoutCounter o, CheckoutCounter o2) {
						return o.getCurrentState().getQueue().size() - o2.getCurrentState().getQueue().size();
					}
				}
		);
		return clone[0];
	}
}
