package dmdevcafe.ru.dmdev.dmdevcafe.util.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvHandler {

	public synchronized void write(String csvResourcePath, String[] columns, List<List<String>> rows) {
		FileWriter csvWriter;
		try {
			csvWriter = new FileWriter(csvResourcePath);

			csvWriter.append(columns[0]);

			for (int i = 1; i < columns.length; i++) {
				csvWriter.append(",").append(columns[i]);
			}
			csvWriter.append("\n");

			for (List<String> rowData : rows) {
				csvWriter.append(String.join(",", rowData));
				csvWriter.append("\n");
			}

			csvWriter.flush();
			csvWriter.close();

		} catch (IOException e) {
			new RuntimeException("Ошибка записи csv");
			e.printStackTrace();
		}

	}
	
	
	public synchronized <T> List<T>  reader(String csvResourcePath, CsvTransformative<T> csvTransformative) {
		List<T>  csvDataObjectFormatBunch = new ArrayList<>();
		
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader(csvResourcePath));
			String row;
			csvReader.readLine();
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(",");
			    csvDataObjectFormatBunch.add(csvTransformative.toObject(data));
			    System.out.println(Arrays.toString(data));
			}
			csvReader.close();
		} catch (IOException e) {
			new RuntimeException("Ошибка чтения csv");
			e.printStackTrace();
		}
		
		return csvDataObjectFormatBunch;	
	}
	

//	public <T> List<T> readDefaultCsvFile(String[] columns, Class<T> toMapType)
//			throws FileNotFoundException, URISyntaxException {
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		CsvToBean<T> csv = new CsvToBean<T>();
//		String csvFilename = Paths.get(ClassLoader.getSystemResource(defaultCsvResourcePath).toURI()).toString();
//		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
//		ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<T>();
//		strategy.setType(toMapType);
//		strategy.setColumnMapping(columns);
//		return csv.parse(strategy, csvReader);
//	}

}