package dmdevcafe.ru.dmdev.dmdevcafe.util.storagememory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class HashSetStoredMemory<T extends EntityStoredMemory> implements StoredMemory<T> {

	private final Map<String, T> entitys = Collections.synchronizedMap(new HashMap<String, T>());

	public List<T> findAll() {
		return new ArrayList<>(entitys.values());
	}

	public T add(T item) {
		item.setId(this.generateId());
		entitys.put(item.getId(), item);
		return item;
	}

	public T findById(String id) {
		return entitys.get(id);
	}

	public String generateId() {
		return String.valueOf(entitys.size() + 1);
	}
	
	public int count() {
		return entitys.size();
	}

}