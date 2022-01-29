package dmdevcafe.ru.dmdev.dmdevcafe.dao.catalog;

import java.util.List;

import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Dish;
import dmdevcafe.ru.dmdev.dmdevcafe.storage.catalog.DishHashSetStoredMemory;

public class DishMemoryRepository {
	
	private DishHashSetStoredMemory dishHashSetStoredMemory;

	public DishMemoryRepository() {
		this.dishHashSetStoredMemory= new DishHashSetStoredMemory();	
	}

	public Dish findById(String id) {
		return this.dishHashSetStoredMemory.findById(id);
	}
	
	public Dish create(Dish newDish) {
		return this.dishHashSetStoredMemory.add(newDish);
	}
	
	public List<Dish> findAll() {
		return (List<Dish>) this.dishHashSetStoredMemory.findAll();
	}
	
	public int count() {
		return  this.dishHashSetStoredMemory.count();
	}



}