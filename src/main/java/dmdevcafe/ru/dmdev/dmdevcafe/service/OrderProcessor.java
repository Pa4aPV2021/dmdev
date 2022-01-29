package dmdevcafe.ru.dmdev.dmdevcafe.service;

import java.util.ArrayList;
import java.util.List;

import dmdevcafe.ru.dmdev.dmdevcafe.domain.Order;
import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Cashier;
import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Customer;
import dmdevcafe.ru.dmdev.dmdevcafe.domain.catalog.Dish;
import dmdevcafe.ru.dmdev.dmdevcafe.util.DmdevCafeRandomGenerator;

/**
 * Обслуживает клиентов
 */
public class OrderProcessor {
	private final CustomerService customerService;
	private final DishService dishService;
	private final OrderService orderService;
	private final CashierService cashierService;
	private final int SEARCH_FREE_CASHIER_WAITING_TIME = 2000;
	private final int ELEMENT_PREPARATION_WAITING_TIME = 1000; // task - 1000
	private final int NEW_ORDER_PROCESSING_WAITING_TIME = 4000; // task - 30 000

	public OrderProcessor(CustomerService customerService, DishService dishService, OrderService orderService,
			CashierService cashierService) {
		this.customerService = customerService;
		this.dishService = dishService;
		this.orderService = orderService;
		this.cashierService = cashierService;
	}

	public void start() {
		List<Customer> typicalDayClients = customerService.findAll();

		Thread orderProcessorThread = new Thread(

				() -> {

					while (true) {
						try {
							Thread.sleep(NEW_ORDER_PROCESSING_WAITING_TIME);

							for (Customer customer : typicalDayClients) {

								String name = customer.getId() + " " + customer.getName();

								System.out.println(name + " пробует сделать заказ");

								Cashier freeCashier = this.searchFreeCashier(name);

								Thread orderCreateThread = new Thread(

										() -> {
											try {
												List<Dish> dishes = this.chooseDishes();
												this.createOrder(dishes, freeCashier, customer);
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();

											}
										}

				);
								System.out.println("Поток: " + orderCreateThread.getName() + " " + name
										+ " начинает работу с " + freeCashier.getName());
								orderCreateThread.start();

							}

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}

		);
		orderProcessorThread.start();

	}

	private void createOrder(List<Dish> dishes, Cashier cashier, Customer customer) throws InterruptedException {

		this.changeStatusFreeForСashier(cashier);
		int s = dishes.size();

		for (Dish dish : dishes) {
			Thread.sleep(ELEMENT_PREPARATION_WAITING_TIME);
			System.out.println(String.join(" ", "Касса: ", cashier.getName(), "будет занята", String.valueOf(s -= 1)));
		}

		orderService.create(new Order(cashier, customer, dishes));

		this.changeStatusFreeForСashier(cashier);

	}

	private synchronized void changeStatusFreeForСashier(Cashier cashier) {
		cashier.setFree(!cashier.isFree());
	}

	private List<Dish> chooseDishes() {

		List<Dish> dishs = new ArrayList<>();

		for (int i = 0; i <= DmdevCafeRandomGenerator.nextInt(4, 1); i++) {
			dishs.add(this.dishService.findRandom());
		}

		return dishs;
	}

	private Cashier searchFreeCashier(String name) throws InterruptedException {
		List<Cashier> cashiers = this.cashierService.findAll();

		while (true) {
			Thread.sleep(SEARCH_FREE_CASHIER_WAITING_TIME);

			for (Cashier cashier : cashiers) {

				if (cashier.isFree()) {
					return cashier;
				} else {
					System.out.println("для " + name + " Касса " + cashier.getName() + " занята");
				}
			}

		}

	}

}
