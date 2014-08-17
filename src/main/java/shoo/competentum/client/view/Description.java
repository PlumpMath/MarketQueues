package shoo.competentum.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.html.Div;

public class Description extends Composite {
	interface DescriptionUiBinder extends UiBinder<Widget, Description> {
	}

	private static DescriptionUiBinder ourUiBinder = GWT.create(DescriptionUiBinder.class);
	@UiField
	Div femalePic;
	@UiField
	Div malePic;
	@UiField
	Div childPic;
	@UiField
	Div newPic;
	@UiField
	Div multiItemPic;

	public Div getFemalePic() {
		return femalePic;
	}

	public Div getMalePic() {
		return malePic;
	}

	public Div getChildPic() {
		return childPic;
	}

	public Div getNewPic() {
		return newPic;
	}

	public Div getMultiItemPic() {
		return multiItemPic;
	}

	public Description() {
		Widget rootElement = ourUiBinder.createAndBindUi(this);
		initWidget(rootElement);
	}
}