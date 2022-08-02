/**
 *
 * @author CS
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;
 
public class IterativeDeepening
{
    private Stack<Integer> stack;
    private int numberOfNodes;
    private int depth;
    private int maxDepth;
    private boolean goalFound = false;
    
            String DNArray[]={"","","D","N","A", 
                              "DD","DN","DA", 
                              "ND","NN","NA", 
                              "AD","AN","AA", 
                              "DDD","DDN","DDA",
                              "DND","DNN","DNA",
                              "DAD","DAN","DAA"};
 
    public IterativeDeepening()
    {
        stack = new Stack<Integer>();
    }
 
    public void iterativeDeeping(int adjacencyMatrix[][], String destination)
    {
        numberOfNodes = adjacencyMatrix[1].length - 1;
        while (!goalFound)
        {
            depthLimitedSearch(adjacencyMatrix, 1, destination);
            maxDepth++;
        }
        System.out.println("\nGoal Found at depth " + depth);
    }
 
    private void depthLimitedSearch(int adjacencyMatrix[][], int source, String goal)
    {
        int element, destination = 1;
        int[] visited = new int[numberOfNodes + 1];
        stack.push(source);
        depth = 0;
        System.out.println("\nAt Depth " + maxDepth);
        System.out.print(source + "\t");
 
        while (!stack.isEmpty())
        {
            element = stack.peek();
            while (destination <= numberOfNodes)
            {
                if (depth < maxDepth)
                {
                    if (adjacencyMatrix[element][destination] == 1)
                    {
                        stack.push(destination);
                        visited[destination] = 1;
                        System.out.print(DNArray [destination] + "\t");
                        depth++;
                        if (goal.equals(DNArray [destination]))
                        { 
                            goalFound = true;
                            return;
                        }
                        element = destination;
                        destination = 1;
                        continue;
                    }
                } else 
                {
                    break;
                }
                destination++;
            }
            destination = stack.pop() + 1;
            depth--;
        }
    }
 
    public static void main(String... arg)
    {
        int number_of_nodes;
        String destination;
        Scanner scanner = null;
        try
        {
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            number_of_nodes = scanner.nextInt();
 
            int adjacency_matrix[][] = {{0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}}; 
 
            System.out.println("Enter the destination for the graph");
            destination = scanner.next();
 
            long startTime = System.nanoTime();
            IterativeDeepening iterativeDeepening = new IterativeDeepening();
            iterativeDeepening.iterativeDeeping(adjacency_matrix, destination);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime)/1000;
            System.out.println("Runtime= "+duration+" microseconds"); 
            
        }catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input format");
        }
        scanner.close();
    }
}