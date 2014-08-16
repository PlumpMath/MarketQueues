package shoo.competentum.shared;

import java.io.Serializable;
import java.util.LinkedList;


public class CheckoutCounter implements Serializable {
	private int performance;
	private LinkedList<State> history;



	public CheckoutCounter() {
		history = new LinkedList<State>();
		history.add(new State(new LinkedList<Customer>()));
	}

	public CheckoutCounter(int performance) {
		this();
		this.performance = performance;
	}

	public LinkedList<State> getHistory() {
		return history;
	}

	public State getCurrentState() {
		return history.getLast();
	}

	public State createState() {
		State state = (State) history.getLast().clone();
		history.add(state);
		return state;
	}

	public void setHistory(LinkedList<State> history) {
		this.history = history;
	}

	public int getPerformance() {
		return performance;
	}

	public void setPerformance(int performance) {
		this.performance = performance;
	}

	@Override
		public String toString() {
			return "CheckoutCounter{" +
					"performance=" + performance +
					"currentState=" + getCurrentState() +
					'}' ;
		}


}
