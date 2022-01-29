package dmdevcafe.ru.dmdev.dmdevcafe.util.csv;
@FunctionalInterface
public interface CsvTransformative <T> {
	T toObject(String[] row);
}
