package shoo.competentum.shared;

import java.io.Serializable;
import java.util.Objects;


public class Customer implements Serializable {
	private int itemsInCart;
	private CustomerKind kind;

	public Customer() {
	}

	public int getItemsInCart() {
		return itemsInCart;
	}

	public void setItemsInCart(int itemsInCart) {
		this.itemsInCart = itemsInCart;
	}

	public CustomerKind getKind() {
		return kind;
	}

	public void setKind(CustomerKind kind) {
		this.kind = kind;
	}

	public Customer(int itemsInCart, CustomerKind kind) {
		this.itemsInCart = itemsInCart;
		this.kind = kind;
	}

	@Override
	public String toString() {
		return  kind + ": " +  itemsInCart;
	}

	public Object clone() {
		Customer customer = new Customer();
		customer.kind = kind;
		customer.itemsInCart = itemsInCart;
		return customer;
	}
}
