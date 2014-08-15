package shoo.competentum.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface LaunchCustomerEventHandler extends EventHandler {
  void onLaunch(LaunchCustomersEvent event);
}
