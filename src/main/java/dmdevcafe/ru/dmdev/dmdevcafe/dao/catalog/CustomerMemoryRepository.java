package dmdevcafe.ru.dmdev.dmdevcafe.dao.catalog;
import java.util.List;

import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Customer;
import dmdevcafe.ru.dmdev.dmdevcafe.storage.catalog.CustomerHashSetStoredMemory;


public class CustomerMemoryRepository {
	
	private CustomerHashSetStoredMemory customerHashSetStoredMemory;

	public CustomerMemoryRepository() {
		this.customerHashSetStoredMemory= new CustomerHashSetStoredMemory();	
	}

	public Customer findById(String id) {
		return this.customerHashSetStoredMemory.findById(id);
	}
	
	public Customer create(Customer newCustomer) {
		return this.customerHashSetStoredMemory.add(newCustomer);
	}
	
	public List<Customer> findAll() {
		return this.customerHashSetStoredMemory.findAll();
	}

	public int count() {
		return  this.customerHashSetStoredMemory.count();
	}



}