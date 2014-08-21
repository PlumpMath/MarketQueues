package shoo.competentum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class AppView extends Composite{
	interface AppViewUiBinder extends UiBinder<Widget, AppView> {
	}


	@UiField
	SimplePanel controlsContainer;
	@UiField
	VerticalPanel contentContainer;


	private static AppViewUiBinder ourUiBinder = GWT.create(AppViewUiBinder.class);

	public AppView() {
		initWidget(ourUiBinder.createAndBindUi(this));
	}

	public SimplePanel getControlsContainer() {
		return controlsContainer;
	}

	public VerticalPanel getContentContainer() {
		return contentContainer;
	}

}