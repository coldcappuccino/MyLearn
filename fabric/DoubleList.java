package fabric;

class Node2{
   public int date;
   public Node2 front;
   public Node2 next;
   
   public Node2(int date){
      this.date = date;
   }
   
}


public class DoubleList{
   
   Node2 head;  
   Node2 tail;  
   int count;
   
   public DoubleList(){  
     this.head=null;  
     this.tail=null;  
     this.count=0;  
   }  
   
}











