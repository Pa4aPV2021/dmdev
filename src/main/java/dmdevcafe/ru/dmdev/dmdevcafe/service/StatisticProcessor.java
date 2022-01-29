package dmdevcafe.ru.dmdev.dmdevcafe.service;

import dmdevcafe.ru.dmdev.dmdevcafe.util.csv.CsvHandler;

public class StatisticProcessor {
	private final StatisticCashierProcessor statisticCashierProcessor;
	private final StatisticCustomerProcessor statisticCustomerProcessor;

	public StatisticProcessor(OrderService orderService, CashierService cashierService,
			CustomerService customerService) {
		CsvHandler ñsvHandler = new CsvHandler();
		this.statisticCashierProcessor = new StatisticCashierProcessor(orderService, cashierService, ñsvHandler);
		this.statisticCustomerProcessor = new StatisticCustomerProcessor(orderService, customerService, ñsvHandler);
	}

	public void start() {
		this.statisticCashierProcessor.startGenerateStatisticCashier();
		this.statisticCashierProcessor.startDeterminingBestCashier();
		this.statisticCustomerProcessor.startGenerateStatisticCustomer();
		this.statisticCustomerProcessor.startDeterminingVoraciousCustomer();
	}

}
