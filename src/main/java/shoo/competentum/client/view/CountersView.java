package shoo.competentum.client.view;

import com.google.gwt.dom.client.*;
import com.google.gwt.user.client.ui.*;
import shoo.competentum.shared.CheckoutCounter;
import shoo.competentum.shared.Customer;
import shoo.competentum.shared.State;

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


		for (CheckoutCounter counter : counters) {
//			TableElement table = Document.get().createTableElement();
//			table.setCellSpacing(3);
//			table.setBorder(1);
//			TableSectionElement tHead = table.createTHead();
//			tHead.insertRow(-1).insertCell(-1).setInnerHTML("<h2>Counter [" + counter.getPerformance() + "]</h2>");
//
//			TableSectionElement tbody;
//			table.appendChild(tbody = Document.get().createTBodyElement());
//
//
//			TableRowElement content = tbody.insertRow(-1);
			HorizontalPanel counterContainer = new HorizontalPanel();

			//  create table // out += "Counter[" + counter.getPerformance() + "]: <br/>";
			int i = 0;

			for (State state : counter.getHistory()) {
				i++;
				Grid stateTable = new Grid(15,1);
				stateTable.setBorderWidth(1);
//				TableElement stateTable = Document.get().createTableElement();
//				TableSectionElement stateHead = stateTable.createTHead();
//				stateHead.insertRow(-1).insertCell(-1).setInnerHTML("<h3>S [" + i + "]</h3>");
//				TableSectionElement stateBody;
//				stateTable.appendChild(stateBody = Document.get().createTBodyElement());
//
              int cCount = 0;
				for (Customer customer : state.getQueue()) {
					stateTable.setText(cCount, 0, customer.getKind().toString().charAt(0) + ": " + customer.getItemsInCart());
					stateTable.getRowFormatter().getElement(cCount).setPropertyString("bgcolor", "#ff0000");
					stateTable.getRowFormatter().getElement(cCount).setPropertyString("height", "32");
					cCount++;
//					TableCellElement customerCell = stateBody.insertRow(-1).insertCell(-1);
//					customerCell.setInnerHTML(customer.getKind().toString().charAt(0) + ": " + customer.getItemsInCart());
				}
				stateTable.getColumnFormatter().setWidth(0, "32");

				counterContainer.add(stateTable);

			}
			container.add(new Label("Counter[" + counter.getPerformance() + "]:"));
			container.add(counterContainer);
		}

//		TableElement table = Document.get().createTableElement();
//		TableSectionElement tbody;
//		table.appendChild(tbody = Document.get().createTBodyElement());
//
//		for (int i = 0; i < counters.size(); ++i) {
//			TableRowElement row = tbody.insertRow(-1);
//			CheckoutCounter t = counters.get(i);
//
//			for (int j = 0; j < columnDefinitions.size(); ++j) {
//				TableCellElement cell = row.insertCell(-1);
//				StringBuilder sb = new StringBuilder();
//				columnDefinitions.get(j).render(t, sb);
//				cell.setInnerHTML(sb.toString());
//
//				// TODO: Really total hack! There's gotta be a better way...
//				Element child = cell.getFirstChildElement();
//				if (child != null) {
//					Event.sinkEvents(child, Event.ONFOCUS | Event.ONBLUR);
//				}
//			}
//		}

//		contentDetailsDecorator.add(serverResponseLabel);
	}


//	public Widget asWidget() {
//		return this;
//	}
}
