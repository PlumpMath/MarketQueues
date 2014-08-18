package shoo.competentum.server.populators;

import shoo.competentum.shared.Customer;


public interface Populator {
	public Customer populate() throws IllegalAccessException;
}
