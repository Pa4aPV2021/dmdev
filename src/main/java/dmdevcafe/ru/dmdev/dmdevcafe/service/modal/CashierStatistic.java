package dmdevcafe.ru.dmdev.dmdevcafe.service.modal;

/*
 * id �������, ���������� �������, ����� �����
 */

public class CashierStatistic extends DmdevCafeStatistic {
	private Integer sum;
	
	public static String[] getFieldsName() {
		return new String[] {"�� �������", "���������� �������", "����� �����" };	
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "CashierStatistic [sum=" + sum + ", getId()=" + getId() + ", getQuantityOrders()=" + getQuantityOrders()
				+ "]";
	}
	
	

}
