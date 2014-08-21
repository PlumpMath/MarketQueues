package shoo.competentum.server.customerresolver;

import shoo.competentum.shared.CheckoutCounter;

import java.util.ArrayList;


/**
 * Классы, реализующие этот интерфейс могут выбирать очередь из предоставленного списка.
 */
public interface CustomerResolver {
	public CheckoutCounter chooseCounter(ArrayList<CheckoutCounter> checkoutCounters);
}
