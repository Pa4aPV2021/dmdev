package dmdevcafe.ru.dmdev.dmdevcafe.storage.catalog;

import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Customer;
import dmdevcafe.ru.dmdev.dmdevcafe.util.storagememory.HashSetStoredMemory;



public class CustomerHashSetStoredMemory extends HashSetStoredMemory<Customer> {
	/**
	 * String name;
	 */
	public CustomerHashSetStoredMemory() {

		super.add(new Customer("Петр Васильевич"));
		super.add(new Customer("Василий Петрович"));
		super.add(new Customer("Мария Фиалкина"));

	}

	


}