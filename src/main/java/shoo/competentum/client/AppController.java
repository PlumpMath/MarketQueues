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
import shoo.competentum.client.view.ControlsView;
import shoo.competentum.client.view.CountersView;
import shoo.competentum.shared.CheckoutCounter;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AppController implements Presenter {
	private final HandlerManager eventBus;
	private final CountingServiceAsync rpcService;
	private HasWidgets container;
	private VerticalPanel resultContainer;
	private ControlsView controlsView;
	private CountersView countersView;

	public AppController(CountingServiceAsync rpcService,
	                     HandlerManager eventBus) {
		this.eventBus = eventBus;
		this.rpcService = rpcService;

		controlsView = new ControlsView();
		resultContainer = new VerticalPanel();

		bind();
	}

	private void bind() {
		eventBus.addHandler(LaunchCustomersEvent.TYPE,
				new LaunchCustomerEventHandler() {
					public void onLaunch(LaunchCustomersEvent event) {
						rpcService.processCustomers(event.getSteps(), new AsyncCallback<List<CheckoutCounter>>() {
							public void onFailure(Throwable caught) {
								Logger logger = Logger.getLogger("Fail:");
								logger.log(Level.SEVERE, caught.getMessage() + caught.getStackTrace());
							}

							public void onSuccess(List<CheckoutCounter> result) {
								// todo reuse
								Logger logger = Logger.getLogger("NameOfYourLogger");
								logger.log(Level.SEVERE, "result" + result);
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
		this.container = container;
		container.add(controlsView);
		new ControlsPresenter(eventBus, controlsView).go(container);
		container.add(resultContainer);
	}
}
