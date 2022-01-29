package dmdevcafe.ru.dmdev.dmdevcafe.service.modal;

public abstract class DmdevCafeStatistic {
	private String id;
	private Integer quantityOrders;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getQuantityOrders() {
		return quantityOrders;
	}

	public void setQuantityOrders(Integer quantityOrders) {
		this.quantityOrders = quantityOrders;
	}



}
