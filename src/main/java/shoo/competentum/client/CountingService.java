package shoo.competentum.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import shoo.competentum.shared.CheckoutCounter;

import java.util.List;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("countingService")
public interface CountingService extends RemoteService {
  List<CheckoutCounter> processCustomers(int numSteps, int numCounters) throws IllegalArgumentException;
}
