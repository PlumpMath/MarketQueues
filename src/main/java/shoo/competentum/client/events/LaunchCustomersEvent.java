package shoo.competentum.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class LaunchCustomersEvent extends GwtEvent<LaunchCustomerEventHandler>{
  public static Type<LaunchCustomerEventHandler> TYPE = new Type<LaunchCustomerEventHandler>();
  private final int steps;
  
  public LaunchCustomersEvent(int steps) {
    this.steps = steps;
  }
  
  public int getSteps() { return steps; }
  
  @Override
  public Type<LaunchCustomerEventHandler> getAssociatedType() {
    return TYPE;
  }



	@Override
  protected void dispatch(LaunchCustomerEventHandler handler) {
    handler.onLaunch(this);
  }
}
