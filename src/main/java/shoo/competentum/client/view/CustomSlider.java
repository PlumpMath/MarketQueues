package shoo.competentum.client.view;

import com.smartgwt.client.widgets.Slider;

public class CustomSlider extends Slider {
	public void setMinValue(String s) {
		super.setMinValue(Float.parseFloat(s));
	}

	public void setMaxValue(String s) {
		super.setMaxValue(Float.parseFloat(s));
	}

	public void setValue(String s) {
		super.setValue(Float.parseFloat(s));
	}

}
