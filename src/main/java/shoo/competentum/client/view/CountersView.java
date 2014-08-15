package shoo.competentum.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HTML;
import shoo.competentum.shared.CheckoutCounter;
import shoo.competentum.shared.Customer;
import shoo.competentum.shared.State;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountersView extends Composite {
	public CountersView() {

	}



	public void setData(List<CheckoutCounter> counters) {
		Logger logger = Logger.getLogger("CountersView");
		logger.log(Level.SEVERE, "set date");
		DecoratorPanel contentDetailsDecorator = new DecoratorPanel();
		initWidget(contentDetailsDecorator);
		final HTML serverResponseLabel = new HTML();
		String out = "";

		for (CheckoutCounter counter : counters) {
			out += "Counter[" + counter.getPerformance() + "]: <br/>";
			int i = 0;
			for (State state : counter.getHistory()) {
				out += i++;
				for (Customer customer : state.getQueue()) {
					out += customer.getKind().toString() + ", " + customer.getItemsInCart();
				}
				out += "<br/>";
			}
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

		serverResponseLabel.setHTML(out);
		contentDetailsDecorator.add(serverResponseLabel);
	}


//	public Widget asWidget() {
//		return this;
//	}
}
