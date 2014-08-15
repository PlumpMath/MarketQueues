package shoo.competentum.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import shoo.competentum.client.GreetingService;
import shoo.competentum.shared.CheckoutCounter;
import shoo.competentum.shared.Customer;
import shoo.competentum.shared.State;

import java.util.List;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {


	public String processCustomers(int numSteps) throws IllegalArgumentException {
		// populator
		// counterProcessor(populator)
		// counterProcessor.launch(numSteps)
		CounterProcessor processor = new CounterProcessor();
		try {
			String out = "";
			List<CheckoutCounter> result = processor.launch(numSteps);
			for (CheckoutCounter counter : result) {
				out += "Counter<" + counter.getPerformance() + ": <br/>";
				int i = 0;
				for (State state : counter.getHistory()) {
					out += i++;
					for (Customer customer : state.getQueue()) {
						out+= customer.toString() + ", ";
					}
					out += "<br/>";
				}
			}
			return out;
		} catch (Throwable t) {
			System.out.print("Failed on launch " + t.getStackTrace());
		}
		return "Boo!";
	}
}
