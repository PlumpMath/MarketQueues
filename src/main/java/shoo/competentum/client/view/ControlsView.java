package shoo.competentum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.extras.slider.client.ui.Slider;

public class ControlsView extends Composite {
	interface ControlsView2UiBinder extends UiBinder<Widget, ControlsView> {
	}

	@UiField
	Button launchButton;
	@UiField
	Slider numCounters;
	@UiField
	Slider numSteps;


	private static ControlsView2UiBinder ourUiBinder = GWT.create(ControlsView2UiBinder.class);

	public ControlsView() {
		initWidget(ourUiBinder.createAndBindUi(this));

	}

	public HasClickHandlers getLaunchButton() {

		return launchButton;
	}

	public int getNumSteps() {
		return (int) Math.floor(numSteps.getValue());
	}

	;

	public int getNumCounters() {
		return (int) Math.floor(numCounters.getValue());
	}

}