package shoo.competentum.client.presenter;

import com.google.gwt.user.client.ui.HasWidgets;
import shoo.competentum.client.view.CountersView;
import shoo.competentum.shared.CheckoutCounter;

import java.util.List;

public class CountersPresenter implements Presenter {

	private final CountersView display;


	public CountersPresenter(List<CheckoutCounter> data, CountersView display) {
		this.display = display;
		display.setData(data);
	}

	public void go(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}
}
