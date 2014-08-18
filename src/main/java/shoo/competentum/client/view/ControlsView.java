package shoo.competentum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
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
	@UiField
	Slider malePrc;
	@UiField
	Slider femalePrc;
	@UiField
	Slider childrenPrc;


	private static ControlsView2UiBinder ourUiBinder = GWT.create(ControlsView2UiBinder.class);

	public ControlsView() {
		initWidget(ourUiBinder.createAndBindUi(this));

		malePrc.addValueChangeHandler(new ValueChangeHandler<Double>() {
			public void onValueChange(ValueChangeEvent<Double> event) {
				double sum = event.getValue() + femalePrc.getValue();
				if (sum > 100) {
					malePrc.setValue(100 - femalePrc.getValue());
					childrenPrc.setValue(0.0);
				} else {
					childrenPrc.setValue(100 - femalePrc.getValue() - event.getValue());
				}
			}
		});
		femalePrc.addValueChangeHandler(new ValueChangeHandler<Double>() {
			public void onValueChange(ValueChangeEvent<Double> event) {
				double sum = event.getValue() + malePrc.getValue();
				if (sum > 100) {
					femalePrc.setValue(100 - malePrc.getValue());
					childrenPrc.setValue(0.0);
				} else {
					childrenPrc.setValue(100 - malePrc.getValue() - event.getValue());
				}
			}
		});
	}


	public HasClickHandlers getLaunchButton() {

		return launchButton;
	}

	public Double getMalePrc() {
		return malePrc.getValue();
	}

	public Double getFemalePrc() {
		return femalePrc.getValue();
	}

	public int getNumSteps() {
		return (int) Math.floor(numSteps.getValue());
	}


	public int getNumCounters() {
		return (int) Math.floor(numCounters.getValue());
	}

}