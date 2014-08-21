package shoo.competentum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;
import com.smartgwt.client.widgets.events.ValueChangedEvent;
import com.smartgwt.client.widgets.events.ValueChangedHandler;

public class ControlsView extends Composite {
	interface ControlsView2UiBinder extends UiBinder<Panel, ControlsView> {
	}

	@UiField
	com.google.gwt.user.client.ui.Button launchButton;
	@UiField
	CustomSlider numCounters;
	@UiField
	CustomSlider numSteps;
	@UiField
	CustomSlider malePrc;
	@UiField
	CustomSlider femalePrc;
	@UiField
	CustomSlider childrenPrc;


	private static ControlsView2UiBinder ourUiBinder = GWT.create(ControlsView2UiBinder.class);

	public ControlsView() {
		Panel panel = ourUiBinder.createAndBindUi(this);
		initWidget(panel);
		malePrc.addValueChangedHandler(new ValueChangedHandler() {
			public void onValueChanged(ValueChangedEvent event) {
				double sum = event.getValue() + femalePrc.getValue();
				if (sum > 100) {
					malePrc.setValue(100 - femalePrc.getValue());
					childrenPrc.setValue(0);
				} else {
					childrenPrc.setValue(100 - femalePrc.getValue() - event.getValue());
				}
			}
		});
		femalePrc.addValueChangedHandler(new ValueChangedHandler() {
					public void onValueChanged(ValueChangedEvent event) {
				double sum = event.getValue() + malePrc.getValue();
				if (sum > 100) {
					femalePrc.setValue(100 - malePrc.getValue());
					childrenPrc.setValue(0);
				} else {
					childrenPrc.setValue(100 - malePrc.getValue() - event.getValue());
				}
			}
		});
	}


	public HasClickHandlers getLaunchButton() {
		return launchButton;
	}

	public float getMalePrc() {
		return malePrc.getValue();
	}

	public float getFemalePrc() {
		return femalePrc.getValue();
	}

	public int getNumSteps() {
		return (int) numSteps.getValue();
	}

	public int getNumCounters() {

		return (int) numCounters.getValue();
	}

}