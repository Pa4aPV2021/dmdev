package dmdevcafe.ru.dmdev.dmdevcafe.service;

import java.util.ArrayList;
import java.util.List;

import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Cashier;
import dmdevcafe.ru.dmdev.dmdevcafe.service.modal.CashierStatistic;
import dmdevcafe.ru.dmdev.dmdevcafe.util.csv.CsvHandler;

public class StatisticCashierProcessor {

	private final OrderService orderService;
	private final CashierService cashierService;
	private final CsvHandler �svHandler;

	private final int DETERMINING_BEST_CASHIER_WAITING_TIME = 5000; // task - 3�600 000
	private final int GENERATE_CASHIER_STATISTICS_WAITING_TIME = 5000; // task - 60 000

	public StatisticCashierProcessor(OrderService orderService, CashierService cashierService, CsvHandler �svHandler) {
		this.orderService = orderService;
		this.cashierService = cashierService;
		this.�svHandler = �svHandler;
	}

	/**
	 * ������������ ���������� �� ������
	 */
	public void startGenerateStatisticCashier() {
		Thread generateStatisticsCashierThread = new Thread(

				() -> {

					while (true) {
						try {
							Thread.sleep(GENERATE_CASHIER_STATISTICS_WAITING_TIME);

//							orderService.findAll().stream().forEach(System.out::println);

							List<List<String>> cashierStatisticsRows = new ArrayList<List<String>>();

							for (Cashier cashier : cashierService.findAll()) {
								List<String> cashierStatisticsRowData = new ArrayList<String>();
								CashierStatistic cashierStatistic = orderService
										.getCashierStatisticInfoByIdCashier(cashier.getId());
								cashierStatisticsRowData.add(cashierStatistic.getId());
								cashierStatisticsRowData.add(String.valueOf(cashierStatistic.getQuantityOrders()));
								cashierStatisticsRowData.add(String.valueOf(cashierStatistic.getSum()));
								cashierStatisticsRows.add(cashierStatisticsRowData);
								System.out.println("���������� �� ��������: " + cashierStatistic);
							}

							�svHandler.write("cashierstatistic.csv", CashierStatistic.getFieldsName(),
									cashierStatisticsRows);

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}

		);

		generateStatisticsCashierThread.start();

	}

	/**
	 * ����������� ������� �������
	 */
	public void startDeterminingBestCashier() {
		Thread determiningBestCashierThread = new Thread(

				() -> {

					while (true) {
						try {
							Thread.sleep(DETERMINING_BEST_CASHIER_WAITING_TIME);

							Cashier bestCashier = cashierService.best(�svHandler.reader("cashierstatistic.csv", row -> {
								CashierStatistic cashierStatistic = new CashierStatistic();
								cashierStatistic.setId(row[0]);
								cashierStatistic.setQuantityOrders(Integer.valueOf(row[1]));
								cashierStatistic.setSum(Integer.valueOf(row[2]));
								return cashierStatistic;
							}));

							System.out.println("������ ������: " + bestCashier.getName());

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				});
		determiningBestCashierThread.start();
	}

}
