package Project2; 
import java.io.*;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
public class read 
{
   public static void main(String[]args) 
   {
      ArrayList<Product> products = readProductData("Project2/Product Data.csv");
      System.out.println("Product ID "+ "Description    "+"Unit Price");
      for (Product p : products) 
      {
         System.out.println(p); 
      } 
   }
   private static ArrayList<Product> readProductData(String fileName) 
   {
      ArrayList<Product> products = new ArrayList<>();
      Path pathToFile = Paths.get(fileName);
      try (BufferedReader br = Files.newBufferedReader(pathToFile,StandardCharsets.US_ASCII)) 
      {
         String line = br.readLine();
         while (line != null) 
         {
            line = br.readLine();
            String[] data = null;
            if(line != null){
               data = line.split(",");
            }
            if(data != null && data.length > 0){
               Product product = createProduct(data);
               products.add(product);
            }
         }
      }
      catch (IOException ioe) 
      {
         ioe.printStackTrace(); 
      }
      return products; 
   }
   private static Product createProduct(String[] data1) 
   {
      int productid = Integer.parseInt(data1[0]);
      String description = data1[1];
      double unitprice = Double.parseDouble(data1[2].substring(1, data1[2].length()));
      return new Product(productid, unitprice, description);
   }
}