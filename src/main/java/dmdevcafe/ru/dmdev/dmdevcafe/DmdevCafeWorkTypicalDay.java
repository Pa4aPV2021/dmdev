package dmdevcafe.ru.dmdev.dmdevcafe;

import dmdevcafe.ru.dmdev.dmdevcafe.service.CashierService;
import dmdevcafe.ru.dmdev.dmdevcafe.service.CustomerService;
import dmdevcafe.ru.dmdev.dmdevcafe.service.DishService;
import dmdevcafe.ru.dmdev.dmdevcafe.service.OrderProcessor;
import dmdevcafe.ru.dmdev.dmdevcafe.service.OrderService;
import dmdevcafe.ru.dmdev.dmdevcafe.service.StatisticProcessor;

public class DmdevCafeWorkTypicalDay {

	private final OrderProcessor orderProcessor;
	private final StatisticProcessor statisticProcessor;

	public DmdevCafeWorkTypicalDay() {
		CustomerService customerService = new CustomerService();
		DishService dishService = new DishService();
		OrderService orderService = new OrderService();
		CashierService cashierService = new CashierService();
		this.orderProcessor = new OrderProcessor(customerService, dishService, orderService, cashierService);
		this.statisticProcessor = new StatisticProcessor(orderService, cashierService, customerService);
	}

	public void start() {
		this.orderProcessor.start();
		this.statisticProcessor.start();
	}

}
