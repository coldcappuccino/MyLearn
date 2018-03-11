package fabric;

class Element{
  public int index;
  public Element next;
  
  public Element(int index){
     this.index = index;
  }
  
}

public class CircularList {
    
    private Element header = null;
    
    public void initList(){
        header = new Element(0);
        header.next = header;
    }
    
    //
    public void insertLit(Element e){
        
        //
        if(header.next == header){
             header.next = e;
             e.next = header;
        }else{
             Element temp = header;
             while(temp.next != header){
                 temp = temp.next;
             }
             temp.next = e;
             e.next = header;     //
        }
        
    }
    
    //
    public void deleteList(int i){
        Element temp = header;
        Element temp2 = header;
        
        if(i<=0||i>size()){
           return ;
        }
        
        int count = 1;
        while(count!=i){
           count++;
           temp = temp.next;
        }
        
        while(temp2.next!=temp){
           temp2 = temp2.next;
        }
        
        if(i==1){
           temp2.next = temp.next;
           header = header.next;
        }else{
          temp2.next = temp.next;
        }
    }
    
    
    
    public Element getElement(int i){
        int count = 1;
        Element temp = header;
        
        if(i<=0||i>size()){
            System.out.println("");
            return null; 
        }else{
           while(count!=i){
              count++;
              temp = temp.next;
           }
           return temp;
        }
        
    }
    
   
    int size()
    {
        Element temp = header;
        int size=0;
        
        if(temp!=null){
            size++;
        }
        
        while(temp.next!=header)
        {
            size++;
            temp=temp.next;
        }
        return size;
    }
    
    //
    Boolean isContain(Element o)
    {
        Element temp =header;
        if(header.index ==o.index){
             return true;
        }
        
        while(temp.next!=header)
        {
            if(temp.index == o.index)
            {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    //
    public void print()
    {
        System.out.println("��ӡ����");
        Element temp =header;
        
        while(temp.next!=header)
        {
            System.out.println(temp.index);
            temp=temp.next;
        }
        System.out.println(temp.index);
        System.out.println();
    }
    
    
    public static void main(String[]args){
       CircularList clist = new  CircularList();
       clist.initList();
       clist.insertLit(new Element(1));
       clist.insertLit(new Element(2));
       clist.insertLit(new Element(3));
       clist.insertLit(new Element(4));
       clist.insertLit(new Element(5));
       
       System.out.println(""+clist.size());
       clist.deleteList(1);
       clist.deleteList(2);
       System.out.println(""+clist.size());
       clist.print();
    }
}










