package shoo.competentum.server.populators;

import shoo.competentum.shared.Customer;
import shoo.competentum.shared.CustomerKind;

import java.util.ArrayList;
import java.util.Random;

public class SetPopulator implements Populator {

	private ArrayList<Customer> setOfCustomers;
	private static final Random RND = new Random();
	private static final int MAX_ITEMS = 10;

	public SetPopulator(ArrayList<Customer> setOfCustomers) {
		this.setOfCustomers = setOfCustomers;
	}

	public SetPopulator(double malesPercent, double femalesPercent, int n) {
		this(generateCustomersSet(malesPercent, femalesPercent, n));
	}


	public Customer populate() throws IllegalAccessException {
		if (setOfCustomers.size() > 0) {
			int idx = RND.nextInt(setOfCustomers.size());
			return setOfCustomers.remove(idx);
		}
		throw new IllegalAccessException("SetPopulator: set is out of customers");
	}

	/**
	 * Генерирует набор экземпляров покупателей согласно переданным процентам в следующем порядке:
	 * рассчитывается число мужчин как процент от n, затем рассчитывается число женщин как процент от n.
	 * Число детей берется как n за вычетом общего числа мужчин и женщин. Значение в мапе игнорируется.
	 * Процент мужчин и женщин не может быть меньше нуля и превышать 100 в сумме.
	 */

	public static ArrayList<Customer> generateCustomersSet(double malesPercent, double femalesPercent, int n) {
		ArrayList<Customer> result = new ArrayList<Customer>();
		if (malesPercent > 100 || malesPercent < 0) {
			throw new IllegalArgumentException("Percentage of male customers should be between 0 and 100");
		}
		int numMales = (int) Math.round(malesPercent / 100 * n);
		if (femalesPercent < 0 || femalesPercent + malesPercent > 100) {
			throw new IllegalArgumentException("Percentage of female and male customers should be between 0 and 100 in total");
		}
		int numFemales = (int) Math.round(femalesPercent / 100 * n);
		for (int i = 0; i < n; i++) {
			CustomerKind kind;
			if (i < numMales) {
				kind = CustomerKind.MALE;
			} else if (i < numFemales + numMales) {
				kind = CustomerKind.FEMALE;
			} else {
				kind = CustomerKind.CHILD;
			}
			result.add(new Customer(RND.nextInt(MAX_ITEMS - 1) + 1, kind));
		}
		return result;
	}
}
