package dmdevcafe.ru.dmdev.dmdevcafe.dao.catalog;

import java.util.List;

import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Cashier;
import dmdevcafe.ru.dmdev.dmdevcafe.storage.catalog.CashierHashSetStoredMemory;

public class CashierMemoryRepository {

	private CashierHashSetStoredMemory cashierHashSetStoredMemory;

	public CashierMemoryRepository() {
		this.cashierHashSetStoredMemory = new CashierHashSetStoredMemory();
	}

	public Cashier findById(String id) {
		return this.cashierHashSetStoredMemory.findById(id);
	}

	public Cashier create(Cashier newCashier) {
		return this.cashierHashSetStoredMemory.add(newCashier);
	}

	public List<Cashier> findAll() {
		return (List<Cashier>) this.cashierHashSetStoredMemory.findAll();
	}

	public int count() {
		return this.cashierHashSetStoredMemory.count();
	}

}