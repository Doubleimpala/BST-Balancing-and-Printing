import java.util.ArrayList;

public class BST <T>
{
    
    BSTNode root; 
    ArrayList<BSTNode> balancer;

    public void insert(T insertMe) {
        BSTNode insertNode = new BSTNode(insertMe);
        if (root == null) {
          root = insertNode;
          return;
        }
        BSTNode curr = root;
        boolean inserting = true;
        while (inserting == true){
          if (insertNode.compareTo(curr) < 0) {
            // go left
            if (curr.getLeft() == null){
              curr.setLeft(insertNode);
              return;
            } else {
              curr = curr.getLeft();
            }
          } else {
            //go right
            if (curr.getRight() == null){
              curr.setRight(insertNode);
              return;
            } else {
              curr = curr.getRight();
            }
          }
        }
    }

    public void inOrderPrint(){
      inOrderHelper(root);
    }

    public void inOrderHelper(BSTNode n){
      if (n == null) { return; }
      inOrderHelper(n.getLeft());
      System.out.println(n.get());
      inOrderHelper(n.getRight());
    }

    public boolean exists(T checkMe) {
      BSTNode checkNode = new BSTNode(checkMe);
      BSTNode curr = root;
      boolean checking = true;
      while(checking == true) {
        if (checkNode.compareTo(curr) == 0) {
          return true;
        } else if (checkNode.compareTo(curr) < 0) {
          //go left
          if (curr.getLeft() == null) {
            return false;
          } else {
            curr = curr.getLeft();
          }
        } else {
          //go right
          if(curr.getRight() == null) {
            return false;
          } else {
            curr = curr.getRight();
          }
        }
      }
      return false;
    }

    /*This method prints the tree in 
    breadth-first order*/
    public void printTree() {
      // should this queue be a variable inOrderHelper
      // or a class variable? 
      // answer: are you going to use this queue in other methods?
      // dependent on your programming style / how you organize

      if (root == null) {
        System.out.println("EMPTY TREE");
        return;
      }

      ArrayList<BSTNode> queue = new ArrayList<BSTNode>();
      BSTNode curr = root;
      queue.add(root);
      while(queue.isEmpty() == false) {
        curr = queue.get(0); 
        if (curr.getLeft() != null) {
            queue.add(curr.getLeft());
            curr = curr.getLeft();
          } 
        if (curr.getRight() != null) {
            queue.add(curr.getRight());
            curr = curr.getRight();
          } 
        
        System.out.println(queue.remove(0));
      }


    }
  

    /*balance() should balance the current BST
    WITHOUT PRINTING ANYTHING*/
    public void balance() {
      // in-order traversal, but put elements into an array
      balancer = new ArrayList<BSTNode>();  // make a new ArrayList

      balanceInOrder(root); // after this line, balancer should
      // contain all the nodes in order

      root = null;  // clear the entire BST
      // at this point, all of the nodes are just in the balancer
      // ArrayList

      balanceRecursive(balancer);

    }

    public void balanceRecursive(ArrayList<BSTNode> a) {

      // find the median and insert into the BST
      // you can just call the insert method from this class
      // DO NOT RECOE THE INSERTION ALGORITHM

      // divide the arraylist in half (minus the element you just inserted)

      // recursively call balanceRecursive on the first half

      // recursively call balanceRecursive on the 2nd half

    }
    
    public void balanceInOrder(BSTNode n){
      if (n == null) { return; }
      balanceInOrder(n.getLeft());
      balancer.add(n);
      balanceInOrder(n.getRight());
    }


    public class BSTNode implements Comparable
    {
        T value;
        BSTNode left;
        BSTNode right;

        public BSTNode(T val) {
            value = val;
        }

        public T get() {
            return value;
        }

        public void set(T val) {
            value = val;
        }

        public BSTNode getLeft() {
            return left;
        }

        public void setLeft(BSTNode n) {
            left = n;
        }

        public BSTNode getRight() {
            return right;
        }

        public void setRight(BSTNode n) {
            right = n;
        }

        public int compareTo(Object o) {
            BSTNode n = (BSTNode) o;
            return ((Comparable)value).compareTo((Comparable) n.get());
        }
    }
}