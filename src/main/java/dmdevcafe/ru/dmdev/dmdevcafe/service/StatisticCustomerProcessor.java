package dmdevcafe.ru.dmdev.dmdevcafe.service;

import java.util.ArrayList;
import java.util.List;

import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Customer;
import dmdevcafe.ru.dmdev.dmdevcafe.service.modal.CustomerStatistic;
import dmdevcafe.ru.dmdev.dmdevcafe.util.csv.CsvHandler;

public class StatisticCustomerProcessor {
	private final OrderService orderService;
	private final CustomerService customerService;
	private final CsvHandler ñsvHandler;

	private final int DETERMINING_VORACIOUS_CUSTOMER_WAITING_TIME = 5000; // task - 3 600 000
	private final int GENERATE_CUSTOMER_STATISTICS_WAITING_TIME = 5000; // task - 120 000

	public StatisticCustomerProcessor(OrderService orderService, CustomerService customerService,
			CsvHandler ñsvHandler) {
		this.orderService = orderService;
		this.customerService = customerService;
		this.ñsvHandler = ñsvHandler;
	}
	
	
	/**
	 * Ôîðìèðîâàíèå ñòàòèñòèêè ïî ïîñåòèòåëÿì
	 */
	public void startGenerateStatisticCustomer() {
		Thread generateStatisticsCustomerThread = new Thread(

				() -> {

					while (true) {
						try {
							Thread.sleep(GENERATE_CUSTOMER_STATISTICS_WAITING_TIME);

//							orderService.findAll().stream().forEach(System.out::println);

							List<List<String>> customerStatisticsRows = new ArrayList<List<String>>();

							for (Customer customer : customerService.findAll()) {
								List<String> customerStatisticsRowData = new ArrayList<String>();
								CustomerStatistic customerStatistic = orderService
										.getCustomerStatisticInfoByIdCashier(customer.getId());
								customerStatisticsRowData.add(customerStatistic.getId());
								customerStatisticsRowData.add(String.valueOf(customerStatistic.getQuantityOrders()));
								customerStatisticsRowData.add(String.valueOf(customerStatistic.getAvgPriceOrder()));
								customerStatisticsRowData.add(String.valueOf(customerStatistic.getAvgCalories()));
								customerStatisticsRows.add(customerStatisticsRowData);
								System.out.println("Ñòàòèñòèêà ïî ïîñåòèòåëÿì: " + customerStatistic);
							}

							ñsvHandler.write("customerstatistic.csv", CustomerStatistic.getFieldsName(),
									customerStatisticsRows);

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}

		);

		generateStatisticsCustomerThread.start();

	}

	/**
	 * Îïðåäåëåíèå ïðîæîðëåâîãî ïîñåòèòåëÿ
	 */
	public void startDeterminingVoraciousCustomer() {
		Thread determiningVoraciousCustomerThread = new Thread(

				() -> {

					while (true) {
						try {
							Thread.sleep(DETERMINING_VORACIOUS_CUSTOMER_WAITING_TIME);

							Customer bestCustomer = customerService
									.voracious(ñsvHandler.reader("customerstatistic.csv", row -> {
										CustomerStatistic ñustomerStatistic = new CustomerStatistic();
										ñustomerStatistic.setId(row[0]);
										ñustomerStatistic.setQuantityOrders(Integer.valueOf(row[1]));
										ñustomerStatistic.setAvgPriceOrder(Integer.valueOf(row[2]));
										ñustomerStatistic.setAvgCalories(Integer.valueOf(row[3]));

										return ñustomerStatistic;
									}));

							System.out.println("Ïðîæîðëåâûé ïîñåòèòåëü: " + bestCustomer.getName());

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				});
		determiningVoraciousCustomerThread.start();
	}

}
