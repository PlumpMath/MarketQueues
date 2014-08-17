package shoo.competentum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.Button;

public class ControlsView extends Composite {
	interface ControlsView2UiBinder extends UiBinder<Widget, ControlsView> {
	}

	@UiField
	Button launchButton;

	private static ControlsView2UiBinder ourUiBinder = GWT.create(ControlsView2UiBinder.class);

	public ControlsView() {
		initWidget(ourUiBinder.createAndBindUi(this));

	}

	public HasClickHandlers getLaunchButton() {

		return launchButton;
	}

	public int getNumSteps() {
		return 50;
	}

	;

}