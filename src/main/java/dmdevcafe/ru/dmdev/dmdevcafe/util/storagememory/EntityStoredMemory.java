package dmdevcafe.ru.dmdev.dmdevcafe.util.storagememory;

public abstract class EntityStoredMemory {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {

		if (this.id == null) {
			this.id = id;
		}

	}

}