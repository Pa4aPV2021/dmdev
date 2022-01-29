package dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog;

import dmdevcafe.ru.dmdev.dmdevcafe.util.storagememory.EntityStoredMemory;

public class Customer extends EntityStoredMemory {
	private String name;

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + "]";
	}

	

}