// Java program for different tree traversals 
  
/* Class containing left and right child of current 
   node and key value*/
class Node 
{ 
    String key; 
    Node left, right, middle; 
  
    public Node(String item) 
    { 
        key = item; 
        left = right = middle = null; 
    } 
} 
  
class BinaryTree 
{ 
    // Root of Binary Tree 
    Node root; 
  
    BinaryTree() 
    { 
        root = new Node(""); 
    } 
  
    /* Given a binary tree, print its nodes according to the 
      "bottom-up" postorder traversal. */
    boolean searchPostorder(Node node, String ref) 
    { 
        if (node == null) 
            return false; 
  
        // first recur on left subtree 
        if(searchPostorder(node.left, ref))
            return true; 
        
        // then recur on middle subtree 
        if(searchPostorder(node.middle, ref))
            return true; 
  
        // then recur on right subtree 
        if(searchPostorder(node.right, ref))
            return true; 
  
        // now deal with the node
        if(node.key.equals(ref)){
            System.out.println("Found "+ref+"!");
            return true;
        }
        System.out.println(node.key); 
        return false;
    } 
  
    /* Given a binary tree, print its nodes in inorder*/
    boolean searchInorder(Node node, String ref) 
    { 
        if (node == null) 
            return false; 
  
        /* first recur on left child */
        if(searchInorder(node.left, ref))
            return true; 
  
        /* then recur on middle child */
        if(searchInorder(node.middle, ref))
            return true; 
        
        /* then print the data of node */
        if(node.key.equals(ref)){
            System.out.println("Found "+ref+"!");
            return true;
        }
        
        System.out.println(node.key); 
        
        /* now recur on right child */
        if(searchInorder(node.right, ref))
            return true;
        return false;
    } 
  
    /* Given a binary tree, print its nodes in preorder*/
    boolean searchPreorder(Node node,String ref) 
    { 
        if (node == null) 
            return false; 
  
        /* first print data of node */
        if(node.key.equals(ref)){
        System.out.println("Found "+ref+"!"); 
        return true;
        }
        
        System.out.println(node.key);
        
        /* then recur on left subtree */
        if(searchPreorder(node.left, ref))
            return true; 
        
        /* then recur on middle subtree */
        if(searchPreorder(node.middle, ref))
            return true; 
  
        /* now recur on right subtree */
        if(searchPreorder(node.right, ref))
            return true;
        return false;
    } 
  
    // Wrappers over above recursive functions 
    void printPostorder()  {     searchPostorder(root,"DAN");  } 
    void printInorder()    {     searchInorder(root, "DAN");   } 
    void printPreorder()   {     searchPreorder(root, "DAN");  } 
    
    
     void FillTree(Node root,int level){
        if (level==0)
            return;
        else
         root.left=new Node(root.key+"D");
         root.middle=new Node(root.key+"N");
         root.right=new Node(root.key+"A");
         FillTree(root.left, level-1);
         FillTree(root.middle, level-1);
         FillTree(root.right, level-1);
        
    } 
  
    // Driver method 
    public static void main(String[] args) 
    { 
        BinaryTree tree = new BinaryTree();
        tree.FillTree(tree.root, 3);
        
        System.out.println("Preorder traversal of binary tree is ");
        
        long startTime = System.nanoTime();
        tree.printPreorder();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000;
        System.out.println("Runtime= "+duration+" microseconds"); 
  
        System.out.println("\nInorder traversal of binary tree is "); 

        startTime = System.nanoTime();
        tree.printInorder();
        endTime = System.nanoTime();
        duration = (endTime - startTime)/1000;
        System.out.println("Runtime= "+duration+" microseconds");
  
        System.out.println("\nPostorder traversal of binary tree is ");
        
        startTime = System.nanoTime();
        tree.printPostorder(); 
        endTime = System.nanoTime();
        duration = (endTime - startTime)/1000;
        System.out.println("Runtime= "+duration+" microseconds");
        
    } 
} 