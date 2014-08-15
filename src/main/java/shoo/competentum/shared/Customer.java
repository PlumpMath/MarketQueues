package shoo.competentum.shared;

import shoo.competentum.shared.CustomerKind;

import java.io.Serializable;


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
}
