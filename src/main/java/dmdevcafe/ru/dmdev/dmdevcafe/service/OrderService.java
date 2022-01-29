package dmdevcafe.ru.dmdev.dmdevcafe.service;

import java.util.List;

import dmdevcafe.ru.dmdev.dmdevcafe.dao.OrderMemoryRepository;
import dmdevcafe.ru.dmdev.dmdevcafe.domain.Order;
import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Cashier;
import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Customer;
import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Dish;
import dmdevcafe.ru.dmdev.dmdevcafe.service.modal.CashierStatistic;
import dmdevcafe.ru.dmdev.dmdevcafe.service.modal.CustomerStatistic;

public class OrderService {

	private OrderMemoryRepository orderMemoryRepository;

	public OrderService() {
		this.orderMemoryRepository = new OrderMemoryRepository();
	}

	public Order findById(String id) {
		return this.orderMemoryRepository.findById(id);
	}

	public Order create(Order newOrder) {
		return this.orderMemoryRepository.create(newOrder);
	}

	public List<Order> findAll() {
		return this.orderMemoryRepository.findAll();
	}

	public CashierStatistic getCashierStatisticInfoByIdCashier(String idCashier) {
		CashierStatistic cashierStatistic = new CashierStatistic();
		int quantity = 0;
		int sum = 0;

		for (Order order : this.findAll()) {

			Cashier orderCashier = order.getCashier();

			if (idCashier.equals(orderCashier.getId())) {
				quantity++;
				for (Dish dish : order.getDishs()) {
					sum += dish.getPrice();
				}
			}

		}

		cashierStatistic.setId(idCashier);
		cashierStatistic.setQuantityOrders(quantity);
		cashierStatistic.setSum(sum);

		return cashierStatistic;
	}

	public CustomerStatistic getCustomerStatisticInfoByIdCashier(String idCustomer) {
		CustomerStatistic customerStatistic = new CustomerStatistic();

		int quantity = 0;
		int sumCalories = 0;
		int sumPriceOrder = 0;

		for (Order order : this.findAll()) {

			Customer orderCustomer = order.getCustomer();

			if (idCustomer.equals(orderCustomer.getId())) {
				quantity++;
				for (Dish dish : order.getDishs()) {
					sumCalories += dish.getCalories();
					sumPriceOrder += dish.getPrice();
				}
			}

		}

		customerStatistic.setId(idCustomer);
		customerStatistic.setQuantityOrders(quantity);
		customerStatistic.setAvgCalories(quantity != 0 ? sumCalories / quantity : 0);
		customerStatistic.setAvgPriceOrder(quantity != 0 ? sumPriceOrder / quantity : 0);

		return customerStatistic;
	}
}