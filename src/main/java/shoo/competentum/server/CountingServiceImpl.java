package shoo.competentum.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import shoo.competentum.client.CountingService;
import shoo.competentum.server.populators.Populator;
import shoo.competentum.server.populators.SetPopulator;
import shoo.competentum.shared.CheckoutCounter;

import java.util.List;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class CountingServiceImpl extends RemoteServiceServlet implements
		CountingService {

	public List<CheckoutCounter> processCustomers(int numSteps, int numCounters, double malePercent, double femalePercent) throws IllegalArgumentException {
		Populator populator = new SetPopulator(malePercent, femalePercent, numSteps);
		QueuesProcessor processor = new QueuesProcessor(numCounters, populator);
		List<CheckoutCounter> result = processor.launch(numSteps);
		return result;
	}
}
