package dmdevcafe.ru.dmdev.dmdevcafe.storage.catalog;

import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Dish;
import dmdevcafe.ru.dmdev.dmdevcafe.util.storagememory.HashSetStoredMemory;

/**
 * ����-����� (500 �������, 10$)
 * ������-����� (50 �������, 5$)
 * �����-��������� (300 �������, 3$)
 * �����-���� (25 �������, 2$)
 * ������-��������� (150 �������, 4$)
 */

public class DishHashSetStoredMemory extends HashSetStoredMemory<Dish> {
	/**
	 * String name; Integer calories; Integer price;
	 */
	public DishHashSetStoredMemory() {
		super.add(new Dish("����-�����", 500, 10));
		super.add(new Dish("������-�����", 50, 5));
		super.add(new Dish("�����-���������", 300, 3));
		super.add(new Dish("�����-����", 25, 2));
		super.add(new Dish("������-���������", 150, 4));
	}



	


}
