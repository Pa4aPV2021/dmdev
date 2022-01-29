package dmdevcafe.ru.dmdev.dmdevcafe.domain;

import java.util.List;

import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Cashier;
import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Customer;
import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Dish;
import dmdevcafe.ru.dmdev.dmdevcafe.util.storagememory.EntityStoredMemory;

public class Order extends EntityStoredMemory {

	private Cashier cashier;
	private Customer customer;
	private List<Dish> dishs;

	public Order(Cashier cashier, Customer customer, List<Dish> dishs) {
		this.cashier = cashier;
		this.customer = customer;
		this.dishs = dishs;
	}

	public Cashier getCashier() {
		return cashier;
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Dish> getDishs() {
		return dishs;
	}

	public void setDishs(List<Dish> dishs) {
		this.dishs = dishs;
	}

	@Override
	public String toString() {
		return "Order [cashier=" + cashier + ", customer=" + customer + ", dishs=" + dishs + "]";
	}




	
	
	

}
