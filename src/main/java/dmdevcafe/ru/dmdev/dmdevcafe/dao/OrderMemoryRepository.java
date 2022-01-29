package dmdevcafe.ru.dmdev.dmdevcafe.dao;

import java.util.List;

import dmdevcafe.ru.dmdev.dmdevcafe.domain.Order;
import dmdevcafe.ru.dmdev.dmdevcafe.storage.OrderHashSetStoredMemory;

public class OrderMemoryRepository {

	private OrderHashSetStoredMemory orderHashSetStoredMemory;

	public OrderMemoryRepository() {
		this.orderHashSetStoredMemory = new OrderHashSetStoredMemory();
	}

	public Order findById(String id) {
		return this.orderHashSetStoredMemory.findById(id);
	}

	public Order create(Order newOrder) {
		return this.orderHashSetStoredMemory.add(newOrder);
	}

	public List<Order> findAll() {
		return (List<Order>) this.orderHashSetStoredMemory.findAll();
	}

}