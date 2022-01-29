package dmdevcafe.ru.dmdev.dmdevcafe.storage.catalog;

import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Cashier;
import dmdevcafe.ru.dmdev.dmdevcafe.util.storagememory.HashSetStoredMemory;

public class CashierHashSetStoredMemory extends HashSetStoredMemory<Cashier> {
	/**
	 * String name;
	 */
	public CashierHashSetStoredMemory() {
		super.add(new Cashier("Кассир 1"));
		super.add(new Cashier("Кассир 2"));
	}

}