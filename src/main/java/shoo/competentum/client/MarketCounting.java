package shoo.competentum.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;
import shoo.competentum.client.view.AppView;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MarketCounting implements EntryPoint {

	public void onModuleLoad() {
		CountingServiceAsync greetingService = GWT.create(CountingService.class);
		HandlerManager eventBus = new HandlerManager(null);
		AppPresenter presenter = new AppPresenter(greetingService, eventBus, new AppView());
		presenter.go(RootPanel.get());



	}


}
