package shoo.competentum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

public class Description extends Composite {
	interface DescriptionUiBinder extends UiBinder<Widget, Description> {
	}

	private static DescriptionUiBinder ourUiBinder = GWT.create(DescriptionUiBinder.class);
	@UiField
	HorizontalPanel femalePic;
	@UiField
	HorizontalPanel malePic;
	@UiField
	HorizontalPanel childPic;
	@UiField
	HorizontalPanel newPic;
	@UiField
	HorizontalPanel multiItemPic;

	public Panel getFemalePic() {
		return femalePic;
	}

	public Panel getMalePic() {
		return malePic;
	}

	public Panel getChildPic() {
		return childPic;
	}

	public Panel getNewPic() {
		return newPic;
	}

	public Panel getMultiItemPic() {
		return multiItemPic;
	}

	public Description() {
		Widget rootElement = ourUiBinder.createAndBindUi(this);
		initWidget(rootElement);
	}
}