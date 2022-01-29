package dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog;

import dmdevcafe.ru.dmdev.dmdevcafe.util.storagememory.EntityStoredMemory;

public class Dish extends EntityStoredMemory {

	private String name;
	private Integer calories;
	private Integer price;

	public Dish(String name, Integer calories, Integer price) {
		this.name = name;
		this.calories = calories;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Integer getCalories() {
		return calories;
	}

	public Integer getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Dish [name=" + name + ", calories=" + calories + ", price=" + price + "]";
	}
	
	

}
