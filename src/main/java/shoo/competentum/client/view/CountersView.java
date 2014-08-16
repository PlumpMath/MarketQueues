package shoo.competentum.client.view;

import com.google.gwt.dom.client.*;
import com.google.gwt.user.client.ui.*;
import org.vaadin.gwtgraphics.client.DrawingArea;
import org.vaadin.gwtgraphics.client.shape.Rectangle;
import shoo.competentum.shared.CheckoutCounter;
import shoo.competentum.shared.Customer;
import shoo.competentum.shared.CustomerKind;
import shoo.competentum.shared.State;

import java.util.HashMap;
import java.util.List;

public class CountersView extends Composite {
	public CountersView() {

	}


	public void setData(List<CheckoutCounter> counters) {

		//region Canvas
/*	Canvas canvas = Canvas.createIfSupported();
		Context2d context = canvas.getContext2d();
		canvas.setCoordinateSpaceWidth(900);
		context.setFillStyle("#f0f0f0");
		context.beginPath();
		context.arc(0, 0, 1000, 0, Math.PI * 2.0, true);
		context.closePath();
		context.fill();
		initWidget(canvas);
		*/
		//endregion

//		Logger logger = Logger.getLogger("CountersView");
//		logger.log(Level.SEVERE, "set date");
		VerticalPanel container = new VerticalPanel();
		initWidget(container);


		//region Text
//		final HTML serverResponseLabel = new HTML();
//				String out = "";
		//		for (CheckoutCounter counter : counters) {
//			out += "Counter[" + counter.getPerformance() + "]: <br/>";
//			int i = 0;
//			for (State state : counter.getHistory()) {
//				out += i++;
//				for (Customer customer : state.getQueue()) {
//					out += customer.getKind().toString() + ", " + customer.getItemsInCart();
//				}
//				out += "<br/>";
//			}
//		}
		//endregion


//		TextCell textCell = new TextCell();
//
//	    // Create a CellList that uses the cell.
//	    CellList<String> cellList = new CellList<String>(textCell);
//
//
//
//	    // Set the total row count. This isn't strictly necessary, but it affects
//	    // paging calculations, so its good habit to keep the row count up to date.
//	    cellList.setRowCount(DAYS.size(), true);
//
//	    // Push the data into the widget.
//	    cellList.setRowData(0, DAYS);
		int UNIT_WIDTH = 6;
		int SPACING_WIDTH = 2;
		int ITEM_HEIGHT = 3;
		int SPACING_HEIGHT = 2;
		HashMap<CustomerKind, String> colors = new HashMap<CustomerKind, String>(){{
		    put(CustomerKind.CHILD, "#8dc63f");
		    put(CustomerKind.FEMALE, "#ed145b");
		    put(CustomerKind.MALE, "#0072bc");
		}};;


		for (CheckoutCounter counter : counters) {

			//  create table // out += "Counter[" + counter.getPerformance() + "]: <br/>";
			int statesCount = 0;
			DrawingArea counterCanvas = new DrawingArea((counter.getHistory().size() + 1) *  (UNIT_WIDTH + SPACING_WIDTH), 100);


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
			container.add(new HTML("<h2>Counter[" + counter.getPerformance() + "]</h2>"));
			container.add(counterCanvas);
		}

	}


//	public Widget asWidget() {
//		return this;
//	}
}
