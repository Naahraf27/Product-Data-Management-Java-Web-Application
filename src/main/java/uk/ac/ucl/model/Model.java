package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



import uk.ac.ucl.dao.CSVFileHandler;

public class Model {

  private List<ListItemEntity> items;

  public Model() {
    items = CSVFileHandler.readItems();
  }


  public ListItemEntity getProductByCode(String keyword) {
    for (ListItemEntity product : items) {
      if (product.getProductCode().equals(keyword)) {
        return product;
      }
    }
    return null;
  }

  public List<ListItemEntity> getItems() {
    return items;
  }

  public void addItem(ListItemEntity newItem) {
    items.add(newItem);
  }

  public void deleteProduct(String productCode) {
    ListItemEntity productToDelete = getProductByCode(productCode);
    if (productToDelete != null) {
      items.remove(productToDelete);
      CSVFileHandler.deleteProduct(productCode);
    }
  }


  public List<ListItemEntity> searchFor(String keyword, List<ListItemEntity> items) {
    if (keyword == null) {
      return items;
    }
    return items.stream()
            .filter(item -> item.getName().toLowerCase().contains(keyword.toLowerCase())
                    || item.getType().toLowerCase().contains(keyword.toLowerCase())
                    || item.getProductCode().toLowerCase().contains(keyword.toLowerCase()))
            .collect(Collectors.toList());
  }

  public List<ListItemEntity> getAllItems() {
    List<ListItemEntity> items = new ArrayList<>();

    try {
      BufferedReader br = new BufferedReader(new FileReader("data/products.csv"));
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

      br.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return items;
  }



}
