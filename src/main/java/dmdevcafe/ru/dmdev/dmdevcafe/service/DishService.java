package dmdevcafe.ru.dmdev.dmdevcafe.service;

import java.util.List;
import java.util.Random;

import dmdevcafe.ru.dmdev.dmdevcafe.dao.catalog.DishMemoryRepository;
import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Dish;
import dmdevcafe.ru.dmdev.dmdevcafe.util.DmdevCafeRandomGenerator;

public class DishService {

	private DishMemoryRepository dishMemoryRepository;

	public DishService() {
		this.dishMemoryRepository = new DishMemoryRepository();
	}

	public Dish findById(String id) {
		return this.dishMemoryRepository.findById(id);
	}

	public List<Dish> findAll() {
		return this.dishMemoryRepository.findAll();
	}

	public Dish findRandom() {
		return this.findById(String.valueOf(DmdevCafeRandomGenerator.nextInt(dishMemoryRepository.count(), 1)));
	}

}