package dmdevcafe.ru.dmdev.dmdevcafe.storage.catalog;

import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Dish;
import dmdevcafe.ru.dmdev.dmdevcafe.util.storagememory.HashSetStoredMemory;

/**
 * Айти-стейк (500 калорий, 10$)
 * Легаси-салат (50 калорий, 5$)
 * Свитч-картофель (300 калорий, 3$)
 * Дебаг-кола (25 калорий, 2$)
 * Скрипт-мороженое (150 калорий, 4$)
 */

public class DishHashSetStoredMemory extends HashSetStoredMemory<Dish> {
	/**
	 * String name; Integer calories; Integer price;
	 */
	public DishHashSetStoredMemory() {
		super.add(new Dish("Айти-стейк", 500, 10));
		super.add(new Dish("Легаси-салат", 50, 5));
		super.add(new Dish("Свитч-картофель", 300, 3));
		super.add(new Dish("Дебаг-кола", 25, 2));
		super.add(new Dish("Скрипт-мороженое", 150, 4));
	}



	


}
