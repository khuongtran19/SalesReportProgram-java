public class TotalSorter implements Comparable<Sales>{
   public int compare(Sales one, Sales another){
           int total = 0;
   
       if(one.total() < another.total()){
           total =  -1;
       }else if(one.total() > another.total()){
           total =  1;
       }else if(one.total() == another.total()){
           total =  0;
       }
       return total;
   
       }
}