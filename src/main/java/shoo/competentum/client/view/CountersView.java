package shoo.competentum.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.vaadin.gwtgraphics.client.DrawingArea;
import org.vaadin.gwtgraphics.client.shape.Rectangle;
import shoo.competentum.shared.CheckoutCounter;
import shoo.competentum.shared.Customer;
import shoo.competentum.shared.CustomerKind;
import shoo.competentum.shared.State;

import java.util.HashMap;
import java.util.List;

public class CountersView extends Composite {

	static final int UNIT_WIDTH = 6;
	static final int SPACING_WIDTH = 2;
	static final int ITEM_HEIGHT = 3;
	static final int SPACING_HEIGHT = 2;
	static final HashMap<CustomerKind, String> colors = new HashMap<CustomerKind, String>() {{
		put(CustomerKind.CHILD, "#8dc63f");
		put(CustomerKind.FEMALE, "#ed145b");
		put(CustomerKind.MALE, "#0072bc");
	}};
	;


	public CountersView() {

	}


	public void setData(List<CheckoutCounter> counters) {
		VerticalPanel container = new VerticalPanel();
		initWidget(container);
		for (CheckoutCounter counter : counters) {
			int statesCount = 0;
			DrawingArea counterCanvas = new DrawingArea((counter.getHistory().size() + 1) * (UNIT_WIDTH + SPACING_WIDTH), 100);
			for (State state : counter.getHistory()) {
				statesCount++;
				int customersCount = 0;
				int lastY = 0;
				for (Customer customer : state.getQueue()) {
					int customerHeight = customer.getItemsInCart() * ITEM_HEIGHT;
					Rectangle rectangle = new Rectangle(statesCount * (UNIT_WIDTH + SPACING_WIDTH), lastY + SPACING_HEIGHT, UNIT_WIDTH, customerHeight);
					rectangle.setFillColor(colors.get(customer.getKind()));
					rectangle.setStrokeWidth(0);
					lastY += customerHeight + SPACING_HEIGHT;
					counterCanvas.add(rectangle);
					customersCount++;
				}
			}
			container.add(new HTML("<h2>Касса с производительностью " + counter.getPerformance() + "</h2>"));
			container.add(counterCanvas);
		}
	}

}
