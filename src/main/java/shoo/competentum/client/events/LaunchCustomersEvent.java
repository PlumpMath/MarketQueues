package shoo.competentum.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class LaunchCustomersEvent extends GwtEvent<LaunchCustomerEventHandler> {
	public static Type<LaunchCustomerEventHandler> TYPE = new Type<LaunchCustomerEventHandler>();
	private final int steps;
	private int numCounters;


	public LaunchCustomersEvent(int steps, int numCounters) {
		this.steps = steps;
		this.numCounters = numCounters;
	}

	public int getSteps() {
		return steps;
	}

	public int getNumCounters() {
		return numCounters;
	}

	@Override
	public Type<LaunchCustomerEventHandler> getAssociatedType() {
		return TYPE;
	}


	@Override
	protected void dispatch(LaunchCustomerEventHandler handler) {
		handler.onLaunch(this);
	}
}
