package shoo.competentum.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import org.vaadin.gwtgraphics.client.DrawingArea;
import org.vaadin.gwtgraphics.client.Line;
import org.vaadin.gwtgraphics.client.shape.Circle;
import org.vaadin.gwtgraphics.client.shape.Rectangle;
import shoo.competentum.shared.CheckoutCounter;
import shoo.competentum.shared.Customer;
import shoo.competentum.shared.CustomerKind;
import shoo.competentum.shared.State;

import java.util.HashMap;
import java.util.List;

public class CountersView extends Composite {

	static final int UNIT_WIDTH = 8;
	static final int SPACING_WIDTH = 2;
	static final int ITEM_HEIGHT = 4;
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
			int performance = counter.getPerformance();
			int rowHeight = performance * (ITEM_HEIGHT + SPACING_HEIGHT);
			DrawingArea counterCanvas = new DrawingArea((counter.getHistory().size() + 1) * (UNIT_WIDTH + SPACING_WIDTH), 100);


			drawGrid(counterCanvas, 5 * (UNIT_WIDTH + SPACING_WIDTH), rowHeight, "#eeeeee", 1.0, 1, 0);
			drawRect(counterCanvas, 0, 0, counterCanvas.getWidth(), rowHeight, "#e0e0e0");


			for (State state : counter.getHistory()) {
				statesCount++;
				int x0 = statesCount * (UNIT_WIDTH + SPACING_WIDTH);
				renderState(counterCanvas, state, performance, x0, rowHeight);
			}

			drawGrid(counterCanvas, counterCanvas.getWidth(), (ITEM_HEIGHT + SPACING_HEIGHT), "#ffffff", 0.5, SPACING_HEIGHT, -rowHeight + SPACING_HEIGHT / 2);
			container.add(new HTML("<h2>Касса с производительностью " + performance + "</h2>"));
			container.add(counterCanvas);
		}
	}

	private void renderState(DrawingArea counterCanvas, State state, int performance, int x0, int y0) {
		int customersCount = 0;
		int lastY = y0;

		for (Customer customer : state.getQueue()) {
			int unusedSlotsForNextStep = customer.getItemsInCart() % performance == 0 ? 0 : performance - customer.getItemsInCart() % performance;
			int customerHeight = customer.getItemsInCart() * (ITEM_HEIGHT + SPACING_HEIGHT);
			if (unusedSlotsForNextStep == 0) {
				customerHeight -= SPACING_HEIGHT;
			}
			drawRect(counterCanvas, lastY, x0, UNIT_WIDTH, customerHeight, colors.get(customer.getKind()));
			customersCount++;
			if (customersCount < state.getQueue().size()) { // сохранить значение lastY для последнего покупателя,
				//                                             чтобы можно было воспользоваться им для отрисовки маркера "новый"
				lastY += customerHeight + (unusedSlotsForNextStep) * (ITEM_HEIGHT + SPACING_HEIGHT);
				if (unusedSlotsForNextStep == 0) {
					lastY += SPACING_HEIGHT;
				}
			}
		}
		if (state.getCustomerAdded()) {
			Circle circle = new Circle(x0 + UNIT_WIDTH / 2, lastY + UNIT_WIDTH / 3, UNIT_WIDTH / 3);
			circle.setFillColor("#ffae00");
			circle.setStrokeWidth(0);
			counterCanvas.add(circle);
		}
	}

	private void drawRect(DrawingArea counterCanvas, int y, int x, int width, int height, String color) {
		Rectangle rectangle;
		rectangle = new Rectangle(x, y, width, height);
		rectangle.setFillColor(color);
		rectangle.setStrokeWidth(0);
		counterCanvas.add(rectangle);
	}


	private void drawGrid(DrawingArea canvas, int gWidth, int gHeight, String color, Double opacity, int thickness, int yoffset) {
		for (int pos = gWidth; pos < canvas.getWidth(); pos += gWidth) {
			Line line = new Line(pos, 0, pos, canvas.getHeight());
			line.setStrokeColor(color);
			line.setStrokeWidth(thickness);
			line.setStrokeOpacity(opacity);
			canvas.add(line);
		}

		for (int pos = gHeight; pos < canvas.getHeight(); pos += gHeight) {
			Line line = new Line(0, pos - yoffset, canvas.getWidth(), pos - yoffset);
			line.setStrokeColor(color);
			line.setStrokeOpacity(opacity);
			line.setStrokeWidth(thickness);

			canvas.add(line);
		}
	}

}
