package shoo.competentum.server.populators;

import shoo.competentum.shared.Customer;

/**
 * Реализации этого интерфейса представляют собой фабрики по созданию покупателей.
 */
public interface Populator {
	public Customer populate() throws IllegalAccessException;
}
