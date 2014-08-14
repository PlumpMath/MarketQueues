package shoo.competentum.shared;

import java.io.Serializable;

/**
 * Created by shoo on 8/14/2014.
 */
public class Customer implements Serializable {
	private Integer itemsInCart;

	public Customer() {
	}

	public Customer(Integer itemsInCart) {
		this.itemsInCart = itemsInCart;
	}

}
