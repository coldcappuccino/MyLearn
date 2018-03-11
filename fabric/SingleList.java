package fabric;

class Node{
   public int number;
   public Node next;
  
   public Node(int number) {
    super();
    this.number = number;
   }
   
}

public class SingleList {
    Node head;
    
    public void addNode(Node node){
         if(head==null){
            head = node;
            head.next = null;
         }else{
            Node temp = head;
            while(temp.next!=null){
               temp = temp.next;
            }
            temp.next = node;
            node.next = null;
         }
    }
    
    public void addIndexNode(Node node,int index){
         Node p1 = head;
         while(p1 != null){
            if(p1.number == index){
                if(p1.next == null){
                     p1.next = node;
                     node.next = null;
                }else{
                    node.next = p1.next;
                    p1.next = node;
                }
            }   
            p1 = p1.next;
         }
    }
    
    public void deleteIndexNode(int index){
          Node p1 = head;
          Node p2 = head.next;
          
          if(head.number == index){
              head = head.next;
          }else{
             while(p2!=null){
                if(p2.number == index){
                    if(p2.next == null){
                         p1.next = null;
                    }else{
                       p1.next = p2.next;
                    }
                }
             }
             p1 = p2.next;
             p2 = p2.next;
          }
    }
    
    
}












