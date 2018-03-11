package fabric;


class TreeNode{
    public int number;
    public String date;
    public TreeNode leftNode;
    public TreeNode rightNode;
    
    public TreeNode(int number, String date) {
      super();
      this.number = number;
      this.date = date;
    }
    
}

public class BinaryTree {
  
  private TreeNode root=null;  
  
  public BinaryTree(){  
      root=new TreeNode(1,"A");  
  }  
  
   public void createBinTree(TreeNode root){
     
      TreeNode newNodeB = new TreeNode(2,"B");  
      TreeNode newNodeC = new TreeNode(3,"C");  
      TreeNode newNodeD = new TreeNode(4,"D");  
      TreeNode newNodeE = new TreeNode(5,"E");  
      TreeNode newNodeF = new TreeNode(6,"F");  
      root.leftNode=newNodeB;  
      root.rightNode=newNodeC;  
      root.leftNode.leftNode=newNodeD;  
      root.leftNode.rightNode=newNodeE;  
      root.rightNode.rightNode=newNodeF;
      
   }  
   
  public boolean isEmpty(){  
     return root==null;  
  }
  
  //
  public int height(){  
      return height(root);  
  }
  
  //
  public int size(){  
      return size(root);  
  }
  
  
  private int height(TreeNode subTree){  
      if(subTree==null)  
          return 0;//
      else{  
          int i=height(subTree.leftNode);  
          int j=height(subTree.rightNode);  
          return (i<j)?(j+1):(i+1);  
      }  
  }
  
  
  private int size(TreeNode subTree){  
      if(subTree==null){  
          return 0;  
      }else{  
          return 1+size(subTree.leftNode)+size(subTree.rightNode);  
      }  
  }
  
  //
  public TreeNode parent(TreeNode element){  
      return (root==null|| root==element)?null:parent(root, element);  
  }
  
  
   public TreeNode parent(TreeNode subTree,TreeNode element){  
        if(subTree==null)  
            return null;  
        if(subTree.leftNode==element||subTree.rightNode==element)  
            //
            return subTree;  
        TreeNode p;  
        //
        if((p=parent(subTree.leftNode, element))!=null)  
            //
            return p;  
        else  
            //
        return parent(subTree.rightNode, element);  
   }
   
   //
   public TreeNode getLeftChildNode(TreeNode element){  
     return (element!=null)?element.leftNode:null;  
   }
   
   //
   public TreeNode getRightChildNode(TreeNode element){  
     return (element!=null)?element.rightNode:null;  
   }
   
   public TreeNode getRoot(){  
     return root;  
  }  
   
  
   public void destroy(TreeNode subTree){  
      
       if(subTree!=null){  
         
           destroy(subTree.leftNode);  
        
           destroy(subTree.rightNode);  
          
           subTree=null;  
       }  
   }
   
   public void visted(TreeNode subTree){   
     System.out.println("key:"+subTree.number+"--name:"+subTree.date);
  }  
   
 
   public void preOrder(TreeNode subTree){  
       if(subTree!=null){  
           visted(subTree);  
           preOrder(subTree.leftNode);  
           preOrder(subTree.rightNode);  
       }  
   }  
     
   
   public void inOrder(TreeNode subTree){  
       if(subTree!=null){  
           inOrder(subTree.leftNode);  
           visted(subTree);  
           inOrder(subTree.rightNode);  
       }  
   }  
     
 
   public void postOrder(TreeNode subTree) {  
       if (subTree != null) {  
           postOrder(subTree.leftNode);  
           postOrder(subTree.rightNode);
           visted(subTree);  
       }  
   }  
   
   
   public TreeNode findbyNumber(TreeNode element,int number){
       if(element == null)
          return null;
       
       if(element.number == number)
         return element;
       
       TreeNode p;
       if((p=findbyNumber(element.leftNode,number))!=null){
           return p;
       }
       
       return findbyNumber(element.rightNode,number);
   }
   
   
   
   public void insert(TreeNode element,int number,String judge){
        TreeNode temp = findbyNumber(root,number);
        if(judge.equals("left")){
           if(temp.leftNode == null){
               temp.leftNode = element;
           }
        }
        
        if(judge.equals("right")){
           if(temp.rightNode == null){
               temp.rightNode = element;
           }
        }
        
   }
   
   public static void main(String[]args){
      BinaryTree bt = new BinaryTree();
      bt.createBinTree(bt.root);
      
      TreeNode node = new TreeNode(7,"g");
      bt.insert(node,6,"left");
      System.out.println("*******(ǰ�����)[ABDECF]����*****************");  
      bt.preOrder(bt.root);  
   }
   
}










