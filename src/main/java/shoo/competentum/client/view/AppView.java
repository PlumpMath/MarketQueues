package shoo.competentum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class AppView extends Composite{
	interface AppViewUiBinder extends UiBinder<Widget, AppView> {
	}


	@UiField
	HTMLPanel controlsContainer;
	@UiField
	HTMLPanel contentContainer;


	private static AppViewUiBinder ourUiBinder = GWT.create(AppViewUiBinder.class);

	public AppView() {
		initWidget(ourUiBinder.createAndBindUi(this));
	}

	public HTMLPanel getControlsContainer() {
		return controlsContainer;
	}

	public HTMLPanel getContentContainer() {
		return contentContainer;
	}

}