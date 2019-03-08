package Project2; 
import java.io.*;
import java.util.*;
public class salesreceipt
{
   private int productid;
   private int customerid;
   private double unitprice; 
   private int units;
   public salesreceipt(int productid, double unitprice, int customerid, int units) 
   {
      this.productid = productid;
      this.unitprice = unitprice; 
      this.customerid = customerid;
      this.units = units; 
   }
   public int getProductid() 
   {
      return productid; 
   } 
   public void setProductid(int productid) 
   {
      this.productid = productid; 
   }
   public int getCustomerid() 
   {
      return customerid; 
   } 
   public void setCustomerid(int customerid) 
   {   
      this.customerid = customerid; 
   }
   public double getUnitprice() 
   {
      return unitprice; 
   } 
   public void setUnitprice(int unitprice) 
   {
      this.unitprice = unitprice; 
   }
   public int getUnits() 
   {
   return units; 
   }
   public void setUnits(int units) 
   {
   this.units = units; 
   }
   @Override 
   public String toString() 
   {
      return ""; 
   } 

}