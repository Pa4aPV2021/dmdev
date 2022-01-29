package dmdevcafe.ru.dmdev.dmdevcafe.service.modal;

/*
 * id ������������, ���������� �������, ������� ���������� ��������, ������� ��������� ������
 */

public class CustomerStatistic extends DmdevCafeStatistic {
	private Integer avgCalories;
	private Integer avgPriceOrder;

	public static String[] getFieldsName() {
		return new String[] { "id ������������", "���������� �������", "������� ���������� ��������",
				"������� ��������� ������" };
	}

	public Integer getAvgCalories() {
		return avgCalories;
	}

	public void setAvgCalories(Integer avgCalories) {
		this.avgCalories = avgCalories;
	}

	public Integer getAvgPriceOrder() {
		return avgPriceOrder;
	}

	public void setAvgPriceOrder(Integer avgPriceOrder) {
		this.avgPriceOrder = avgPriceOrder;
	}

	@Override
	public String toString() {
		return "CustomerStatistic [avgCalories=" + avgCalories + ", avgPriceOrder=" + avgPriceOrder + ", getId()="
				+ getId() + ", getQuantityOrders()=" + getQuantityOrders() + "]";
	}

}
