package shoo.competentum.server.customerresolver;

import shoo.competentum.shared.CheckoutCounter;

import java.util.ArrayList;
import java.util.Random;


public class MaleResolver implements CustomerResolver {

	public CheckoutCounter chooseCounter(ArrayList<CheckoutCounter> checkoutCounters) {
			return checkoutCounters.get(new Random().nextInt(checkoutCounters.size()));
		}

}
