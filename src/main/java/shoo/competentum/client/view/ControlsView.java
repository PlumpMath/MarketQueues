package shoo.competentum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ControlsView extends Composite {
	interface ControlsView2UiBinder extends UiBinder<Widget, ControlsView> {
	}

	@UiField
	com.google.gwt.user.client.ui.Button launchButton;
	@UiField
	TextBox numCounters;
	@UiField
	TextBox numSteps;
	@UiField
	TextBox malePrc;
	@UiField
	TextBox femalePrc;
	@UiField
	TextBox childrenPrc;


	private static ControlsView2UiBinder ourUiBinder = GWT.create(ControlsView2UiBinder.class);

	public ControlsView() {
		initWidget(ourUiBinder.createAndBindUi(this));

//		malePrc.addValueChangeHandler(new ValueChangeHandler<Double>() {
//			public void onValueChange(ValueChangeEvent<Double> event) {
//				double sum = event.getValue() + femalePrc.getValue();
//				if (sum > 100) {
//					malePrc.setValue(100 - femalePrc.getValue());
//					childrenPrc.setValue(0.0);
//				} else {
//					childrenPrc.setValue(100 - femalePrc.getValue() - event.getValue());
//				}
//			}
//		});
//		femalePrc.addValueChangeHandler(new ValueChangeHandler<Double>() {
//			public void onValueChange(ValueChangeEvent<Double> event) {
//				double sum = event.getValue() + malePrc.getValue();
//				if (sum > 100) {
//					femalePrc.setValue(100 - malePrc.getValue());
//					childrenPrc.setValue(0.0);
//				} else {
//					childrenPrc.setValue(100 - malePrc.getValue() - event.getValue());
//				}
//			}
//		});
	}


	public HasClickHandlers getLaunchButton() {

		return launchButton;
	}

	public Double getMalePrc() {
		return Double.parseDouble(malePrc.getText());
	}

	public Double getFemalePrc() {
		return Double.parseDouble(femalePrc.getText());
	}

	public int getNumSteps() {
		return Integer.parseInt(numSteps.getText());
	}


	public int getNumCounters() {
		return Integer.parseInt(numCounters.getText());
	}

}