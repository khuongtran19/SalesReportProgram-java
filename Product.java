package Project2; 
import java.io.*;
import java.util.*;  

class Product 
{
   private int productid;
   private double unitprice;
   private String description; 
   public Product(int productid, double unitprice, String description) 
   {
      this.productid = productid;
      this.unitprice = unitprice; 
      this.description = description; 
   }
   public int getProductid() 
   {
      return productid; 
   } 
   public void setProductid(int productid) 
   {
      this.productid = productid; 
   }
   public double getUnitprice() 
   {
      return unitprice; 
   } 
   public void setUnitprice(int unitprice) 
   {
   this.unitprice = unitprice; 
   }
   public String getDescription() 
   {
   return description; 
   }
   public void setDescription(String description) 
   {
   this.description = description; 
   }
   @Override 
   public String toString() 
   {
   return + productid + "  " + description + "  " + unitprice; 
   } 
}

