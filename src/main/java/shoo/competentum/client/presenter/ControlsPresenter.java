package shoo.competentum.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import shoo.competentum.client.events.LaunchCustomersEvent;
import shoo.competentum.client.view.ControlsView;

public class ControlsPresenter implements Presenter {

	private HandlerManager eventBus;
	private final ControlsView display;


	public ControlsPresenter(HandlerManager eventBus, ControlsView display) {
		this.eventBus = eventBus;
		this.display = display;
		bind();
	}

	public void bind() {
		this.display.getLaunchButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new LaunchCustomersEvent(display.getNumSteps()));
			}
		});
	}

	public void go(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}
}
