package Project2; 
import java.io.*;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
public class salesreceiptreadfile 
{
   static ArrayList<Product> products;
   static ArrayList<Sales> sales;
   static salesreceipt receipt;
   static ArrayList<Sales> finalSales = new ArrayList<Sales>();
   
   public static void main(String[]args) 
   {
      products = readProductData("Project2/Product Data.csv");
      sales = readSalesData("Project2/Sales Data.csv");
      System.out.println("Product ID "+" Description         " + " Units price "+" Total units "+" Total revenue");
      
      Collections.sort(sales);
      combine();
      printSales();
   }
   
   public static void combine(){
      Sales s1, s2;
      int index = 0;
      int size = sales.size();
      
      for(int i = 0; i < size; i++){
         if(i == 0)
            index++;
         else{
            s1 = sales.get(index - 1);
            s2 = sales.get(index);
            
            if(s1.getProductid() == s2.getProductid()){
               s1.setUnits(s1.getUnits() + s2.getUnits());
               sales.remove(index);
            }
            else{
               index++;
            }
         }
      }
   }
   
   private static void printSales(){
      for(Sales s: sales){
         Product p = findProductByID(s.getProductid());
         
         System.out.printf("%-11s %-30s %-12s %-5s %-5s\n",s.getProductid() , p.getDescription() ,s.getUnitprice(), s.getUnits(),s.total());
      }
   }
    
   private static ArrayList<Sales> readSalesData(String fileName) 
   {
      ArrayList<Sales> sales = new ArrayList<>();
      Path pathToFile = Paths.get(fileName);
      try (BufferedReader br = Files.newBufferedReader(pathToFile,StandardCharsets.US_ASCII)) 
      {
         String line = br.readLine();
         while (line != null) 
         {
            line = br.readLine();
            String[] data = null;
            if(line != null)
            {
               data = line.split(",");
            }
            if(data != null && data.length > 0)
            {
               Sales product = createSales(data);
               sales.add(product);
            }
         }
      }
      catch (IOException ioe) 
      {
         ioe.printStackTrace(); 
      }
      return sales; 
   }
   private static Product findProductByID(int id)
   {
      for(int i = 0; i < products.size(); i++)
      {
         if(products.get(i).getProductid() == id)
         {
            return products.get(i);
         }
      }
      return null;
   }
   private static Sales createSales(String[] data2) 
   {
      double customerid= Integer.parseInt(data2[0]);     
      int productid= Integer.parseInt(data2[1]);
      int units= Integer.parseInt(data2[2]);
      Product temp = findProductByID(productid);
      double price = temp.getUnitprice();
      return new Sales(productid, price, units);
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
      double unitprice = Double.parseDouble(data1[2].substring(1, data1[2].length()));
      String description = data1[1];
      return new Product(productid, unitprice, description);
   }
}