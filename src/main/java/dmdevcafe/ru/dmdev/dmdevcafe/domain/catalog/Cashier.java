package dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog;

import dmdevcafe.ru.dmdev.dmdevcafe.util.storagememory.EntityStoredMemory;

public class Cashier extends EntityStoredMemory {

	private String name;
	private boolean isFree;

	public Cashier(String name) {
		this.name = name;
		this.isFree = true;
	}

	public String getName() {
		return name;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}


	@Override
	public String toString() {
		return "Cashier [name=" + name + ", isFree=" + isFree + "]";
	}

	

}
