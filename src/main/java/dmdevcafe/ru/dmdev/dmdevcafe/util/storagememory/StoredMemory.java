package dmdevcafe.ru.dmdev.dmdevcafe.util.storagememory;

import java.util.List;

public interface StoredMemory<T extends EntityStoredMemory> {

	public T add(T item);

	public T findById(String id);
	
	public List<T> findAll();
	
	public String generateId();
	
	public int count();
	


}