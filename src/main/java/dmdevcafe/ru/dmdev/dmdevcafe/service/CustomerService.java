package dmdevcafe.ru.dmdev.dmdevcafe.service;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

import dmdevcafe.ru.dmdev.dmdevcafe.dao.catalog.CustomerMemoryRepository;
import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Cashier;
import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Customer;
import dmdevcafe.ru.dmdev.dmdevcafe.service.modal.CashierStatistic;
import dmdevcafe.ru.dmdev.dmdevcafe.service.modal.CustomerStatistic;

public class CustomerService {

	private CustomerMemoryRepository customerMemoryRepository;

	public CustomerService() {
		this.customerMemoryRepository = new CustomerMemoryRepository();
	}

	public Customer findById(String id) {
		return this.customerMemoryRepository.findById(id);
	}

	public List<Customer> findAll() {
		return this.customerMemoryRepository.findAll();
	}

	public Customer findRandom() {
		Random random = new Random();
		return this.findById(String.valueOf(random.nextInt(customerMemoryRepository.count() - 1) + 1));

	}

	public Customer voracious(List<CustomerStatistic> customerStatisticBunch) {
		String idVoraciousCustomer = customerStatisticBunch.stream()
				.max(Comparator.comparing(CustomerStatistic::getAvgCalories))
				.orElseThrow(() -> new RuntimeException("NoSuchElementException")).getId();
		return this.findById(idVoraciousCustomer);
	}

}