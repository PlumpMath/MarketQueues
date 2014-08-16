package shoo.competentum.shared;

import java.io.Serializable;
import java.util.LinkedList;


public class State implements Serializable, Cloneable {

	private Boolean customerAdded;
	private LinkedList<Customer> queue;


	public State(LinkedList<Customer> queue) {
		this.queue = queue;
	}

	public State() {
	}

	public LinkedList<Customer> getQueue() {
		return queue;
	}

	public void setQueue(LinkedList<Customer> queue) {
		this.queue = queue;
	}

	public Boolean getCustomerAdded() {
		return customerAdded;
	}

	public void setCustomerAdded(Boolean customerAdded) {
		this.customerAdded = customerAdded;
	}

	public Object clone(){
		LinkedList<Customer> clonedQueue = new LinkedList<Customer>();
		for (Customer customer: queue) {
			clonedQueue.add((Customer) customer.clone());
		}
		return new State(clonedQueue);
	}

	@Override
	public String toString() {
		return "State{" +
				"customerAdded=" + customerAdded +
				", queue=" + queue +
				'}';
	}
}
