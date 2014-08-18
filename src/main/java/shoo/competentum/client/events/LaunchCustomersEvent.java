package shoo.competentum.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class LaunchCustomersEvent extends GwtEvent<LaunchCustomerEventHandler> {
	public static Type<LaunchCustomerEventHandler> TYPE = new Type<LaunchCustomerEventHandler>();
	private final int steps;
	private int numCounters;
	private double malesPercent;
	private double femalesPercent;


	public LaunchCustomersEvent(int steps, int numCounters, double malesPercent, double femalesPercent) {
		this.steps = steps;
		this.numCounters = numCounters;
		this.malesPercent = malesPercent;
		this.femalesPercent = femalesPercent;
	}

	public int getSteps() {
		return steps;
	}

	public int getNumCounters() {
		return numCounters;
	}

	public double getMalesPercent() {
		return malesPercent;
	}

	public double getFemalesPercent() {
		return femalesPercent;
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
