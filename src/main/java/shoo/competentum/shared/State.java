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
		return new State((LinkedList<Customer>) queue.clone());
	}
}
