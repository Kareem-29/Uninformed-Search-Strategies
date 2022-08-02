// Recursive Java program for level order traversal of Binary Tree 
  
/* Class containing left and right child of current  
   node and key value*/
class Node 
{ 
    String data; 
    Node left, right, middle; 
    public Node(String item) 
    { 
        data = item; 
        left = right = middle = null; 
    } 
} 

class BFS 
{ 
    // Root of the Binary Tree 
    Node root; 
  
    public BFS() 
    { 
        root = new Node("") ; 
    } 

  
    /* function to print level order traversal of tree*/
    void printLevelOrder(String ref) 
    { 
        int h = height(root); 
        int i; 
        for (i=1; i<=h; i++) 
            printGivenLevel(root, ref, i);
            System.out.println("Found "+ref+"!");
    }
    
    
  
    /* Compute the "height" of a tree -- the number of 
    nodes along the longest path from the root node 
    down to the farthest leaf node.*/
    int height(Node root) 
    { 
        if (root == null) 
           return 0; 
        else
        { 
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int mheight = height(root.middle);
            int rheight = height(root.right);
            
              
            /* use the larger one */
            if (lheight > (rheight & mheight)) 
                return(lheight+1);
            else if (rheight > (lheight & mheight))
                return (rheight+1);
            else return(mheight+1);  
        } 
    } 
    
      void FillTree(Node root,int level){
        if (level==0)
            return;
        else
         root.left=new Node(root.data+"D");
         root.middle=new Node(root.data+"N");
         root.right=new Node(root.data+"A");
         FillTree(root.left, level-1);
         FillTree(root.middle, level-1);
         FillTree(root.right, level-1);
        
    }  
  
    /* Print nodes at the given level */
    boolean printGivenLevel (Node root, String ref ,int level) 
    { 
        if (root == null) 
            return false; 
        if (level == 1) {
            if(root.data.equals(ref))
                return true;
            System.out.println(root.data + " ");
        }
        else if (level > 1) 
        { 
            if(printGivenLevel(root.left, ref, level-1))
                return true; 
            if(printGivenLevel(root.middle, ref, level-1))
                return true; 
            if(printGivenLevel(root.right, ref, level-1))
                return true; 
        }
        return false;
    } 
      
    /* Driver program to test above functions */
    public static void main(String args[]) 
    { 
       BFS tree = new BFS(); 
       tree.FillTree(tree.root, 3);
            long startTime = System.nanoTime(); 
            tree.printLevelOrder("DAN"); 
            long endTime = System.nanoTime();
            long duration = (endTime - startTime)/1000;
            System.out.println("Runtime= "+duration+" microseconds");
            
            
        
    } 
} 