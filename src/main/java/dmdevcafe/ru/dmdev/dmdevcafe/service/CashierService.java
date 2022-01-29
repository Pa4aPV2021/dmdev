package dmdevcafe.ru.dmdev.dmdevcafe.service;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

import dmdevcafe.ru.dmdev.dmdevcafe.dao.catalog.CashierMemoryRepository;
import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Cashier;
import dmdevcafe.ru.dmdev.dmdevcafe.service.modal.CashierStatistic;

public class CashierService {

	private CashierMemoryRepository cashierMemoryRepository;

	public CashierService() {
		this.cashierMemoryRepository = new CashierMemoryRepository();
	}

	public Cashier findById(String id) {
		return this.cashierMemoryRepository.findById(id);
	}

	public List<Cashier> findAll() {
		return this.cashierMemoryRepository.findAll();
	}

	public Cashier findRandom() {
		Random random = new Random();
		return this.findById(String.valueOf(random.nextInt(cashierMemoryRepository.count() - 1) + 1));

	}

	public Cashier best(List<CashierStatistic> cashierStatisticBunch) {

		String idBestCashier = cashierStatisticBunch.stream()
				.max(Comparator.comparing(cashierStatistic -> this.avgCheckByCashierStatistic(cashierStatistic)))
				.orElseThrow(() -> new RuntimeException("NoSuchElementException")).getId();

		return this.findById(idBestCashier);

	}

	private int avgCheckByCashierStatistic(CashierStatistic cashierStatistic) {
		int quantity = cashierStatistic.getQuantityOrders();
		int sum = cashierStatistic.getSum();
		return quantity != 0 ? sum / quantity : 0;
	}

}