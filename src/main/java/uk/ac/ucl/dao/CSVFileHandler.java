// CSVFileHandler.java
package uk.ac.ucl.dao;

import uk.ac.ucl.model.ListItemEntity;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileHandler {

    private static final String FILE_NAME = "data/products.csv";
    private static final String HEADER = "Name,Type,Product-Code,Price\n";

    public static List<ListItemEntity> readItems() {
        List<ListItemEntity> items = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                String type = fields[1];
                String productCode = fields[2];
                double price = Double.parseDouble(fields[3]);

                items.add(new ListItemEntity(name, type, productCode, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return items;
    }

    public static void deleteProduct(String productCode) {
        List<ListItemEntity> items = readItems();
        items.removeIf(item -> item.getProductCode().equals(productCode));
        writeItems(items);
    }

    public static void writeItems(List<ListItemEntity> items) {
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            fw.write(HEADER);

            for (ListItemEntity item : items) {
                String line = String.format("%s,%s,%s,%.2f\n",
                        item.getName(), item.getType(), item.getProductCode(), item.getPrice());
                fw.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

