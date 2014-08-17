package shoo.competentum.client;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.VerticalPanel;
import shoo.competentum.client.events.LaunchCustomerEventHandler;
import shoo.competentum.client.events.LaunchCustomersEvent;
import shoo.competentum.client.presenter.ControlsPresenter;
import shoo.competentum.client.presenter.CountersPresenter;
import shoo.competentum.client.presenter.Presenter;
import shoo.competentum.client.view.AppView;
import shoo.competentum.client.view.ControlsView;
import shoo.competentum.client.view.CountersView;
import shoo.competentum.shared.CheckoutCounter;

import java.util.List;


public class AppPresenter implements Presenter {
	private final HandlerManager eventBus;
	private final CountingServiceAsync rpcService;
	private AppView display;
	private VerticalPanel resultContainer;
	private CountersView countersView;

	public AppPresenter(CountingServiceAsync rpcService,
	                    HandlerManager eventBus, AppView display) {
		this.eventBus = eventBus;
		this.rpcService = rpcService;
		this.display = display;

		ControlsView controlsView = new ControlsView();
		new ControlsPresenter(eventBus, controlsView);
		display.getControlsContainer().add(controlsView);
		resultContainer = display.getContentContainer();
		bind();
	}

	private void bind() {
		eventBus.addHandler(LaunchCustomersEvent.TYPE,
				new LaunchCustomerEventHandler() {
					public void onLaunch(LaunchCustomersEvent event) {
						rpcService.processCustomers(event.getSteps(), event.getNumCounters(), new AsyncCallback<List<CheckoutCounter>>() {
							public void onFailure(Throwable caught) {
								// todo alert for user
							}

							public void onSuccess(List<CheckoutCounter> result) {
								// todo reuse
								countersView = new CountersView();
								new CountersPresenter(result, countersView)
										.go(resultContainer);
							}
						});
					}
				}
		);
	}


	public void go(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}
}
