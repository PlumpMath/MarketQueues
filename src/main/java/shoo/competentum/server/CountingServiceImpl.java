package shoo.competentum.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import shoo.competentum.client.CountingService;
import shoo.competentum.shared.CheckoutCounter;

import java.util.List;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class CountingServiceImpl extends RemoteServiceServlet implements
		CountingService {


	public List<CheckoutCounter> processCustomers(int numSteps) throws IllegalArgumentException {
		CounterProcessor processor = new CounterProcessor();
		try {
			List<CheckoutCounter> result = processor.launch(numSteps);
			return result;
		} catch (Throwable t) {
			System.out.print("Failed on launch " + t.getStackTrace());
		}
		return null;
	}
}
