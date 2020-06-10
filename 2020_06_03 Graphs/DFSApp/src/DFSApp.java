// dfs.java
// demonstrates depth-first search
// to run this program: C>java DFSApp
////////////////////////////////////////////////////////////////
class StackX
   {
   private final int SIZE = 25;
   private int[] st;
   private int top;
// ------------------------------------------------------------
   public StackX()           // constructor
      {
      st = new int[SIZE];    // make array
      top = -1;
      }
// ------------------------------------------------------------
   public void push(int j)   // put item on stack
      { st[++top] = j; }
// ------------------------------------------------------------
   public int pop()          // take item off stack
      { return st[top--]; }
// ------------------------------------------------------------
   public int peek()         // peek at top of stack
      { return st[top]; }
// ------------------------------------------------------------
   public boolean isEmpty()  // true if nothing on stack
      { return (top == -1); }
// ------------------------------------------------------------
   }  // end class StackX
////////////////////////////////////////////////////////////////
class Vertex
   {
   public char label;        // label (e.g. 'A')
   public boolean wasVisited;
// ------------------------------------------------------------
   public Vertex(char lab)   // constructor
      {
      label = lab;
      wasVisited = false;
      }
// ------------------------------------------------------------
   }  // end class Vertex
////////////////////////////////////////////////////////////////
class Graph
   {
    private boolean directed;
   private final int MAX_VERTS = 25;
   private Vertex vertexList[]; // list of vertices
   private int adjMat[][];      // adjacency matrix
   private int nVerts;          // current number of vertices
   private StackX theStack;
// ------------------------------------------------------------
   public Graph(boolean DirectedGraph)               // constructor
      {
        directed=DirectedGraph; // set flag whether or not this graph is directed or undirected
        vertexList = new Vertex[MAX_VERTS];
                                        // adjacency matrix
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int y=0; y<MAX_VERTS; y++)      // set adjacency
        for(int x=0; x<MAX_VERTS; x++)   //    matrix to 0
          adjMat[x][y] = 0;
        theStack = new StackX();
      }  // end constructor
// ------------------------------------------------------------
   public void addVertex(char lab)
      {
      vertexList[nVerts++] = new Vertex(lab);
      }
// ------------------------------------------------------------
   public void addEdge(int start, int end)
      {
      adjMat[start][end] = 1;
      if ( !directed ) adjMat[end][start] = 1;
      }
// ------------------------------------------------------------
   public void displayVertex(int v)
      {
      System.out.print(vertexList[v].label);
      }
// ------------------------------------------------------------
   public void dfs()  // depth-first search
      {                                 // begin at vertex 0
      vertexList[0].wasVisited = true;  // mark it
      displayVertex(0);                 // display it
      theStack.push(0);                 // push it

      while( !theStack.isEmpty() )      // until stack empty,
         {
         // get an unvisited vertex adjacent to stack top
         int v = getAdjUnvisitedVertex( theStack.peek() );
         if(v == -1)                    // if no such vertex,
            theStack.pop();
         else                           // if it exists,
            {
            vertexList[v].wasVisited = true;  // mark it
            displayVertex(v);                 // display it
            theStack.push(v);                 // push it
            }
         }  // end while

      // stack is empty, so we're done
      for(int j=0; j<nVerts; j++)          // reset flags
         vertexList[j].wasVisited = false;
      }  // end dfs
// ------------------------------------------------------------
   // returns an unvisited vertex adj to v
   public int getAdjUnvisitedVertex(int v)
      {
      for(int j=0; j<nVerts; j++)
         if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
            return j;
      return -1;
      }  // end getAdjUnvisitedVertex()
// ------------------------------------------------------------
   }  // end class Graph
////////////////////////////////////////////////////////////////
class DFSApp
   {
   public static void main(String[] args)
      {
      Graph theGraph = new Graph(true);
      theGraph.addVertex('A');    // 0  (start for bfs)
      theGraph.addVertex('B');    // 1
      theGraph.addVertex('C');    // 2
      theGraph.addVertex('D');    // 3
      theGraph.addVertex('E');    // 4
      theGraph.addVertex('F');    // 5
      theGraph.addVertex('G');    // 6
      theGraph.addVertex('H');    // 7
      theGraph.addVertex('I');    // 8  (start for bfs)
      theGraph.addVertex('J');    // 9
      theGraph.addVertex('K');    // 10
      theGraph.addVertex('L');    // 11
      theGraph.addVertex('M');    // 12
      theGraph.addVertex('N');    // 13
      theGraph.addVertex('O');    // 14
      theGraph.addVertex('P');    // 15
      theGraph.addVertex('Q');    // 16  (start for bfs)
      theGraph.addVertex('R');    // 17
      theGraph.addVertex('S');    // 18
      theGraph.addVertex('T');    // 19
      theGraph.addVertex('U');    // 20
      theGraph.addVertex('V');    // 21
      theGraph.addVertex('W');    // 22
      theGraph.addVertex('X');    // 23
      theGraph.addVertex('Y');    // 24
      
      theGraph.addEdge(0, 1);     
      theGraph.addEdge(1, 2);     
      theGraph.addEdge(2, 3);     
      theGraph.addEdge(4, 3);     
      theGraph.addEdge(5, 4);     
      theGraph.addEdge(5, 6);     
      theGraph.addEdge(7, 6);     
      theGraph.addEdge(7, 8);     
      theGraph.addEdge(8, 9);     
      theGraph.addEdge(10, 9);
      
      theGraph.addEdge(11, 10);     
      theGraph.addEdge(12, 11);     
      theGraph.addEdge(13, 12);     
      theGraph.addEdge(13, 14);     
      theGraph.addEdge(14, 15);     
      theGraph.addEdge(15, 0);     
      theGraph.addEdge(1, 15);     
      theGraph.addEdge(16, 2);     
      theGraph.addEdge(3, 16);     
      theGraph.addEdge(16, 4);

      theGraph.addEdge(4, 17);     
      theGraph.addEdge(19, 5);     
      theGraph.addEdge(19, 7);     
      theGraph.addEdge(20, 8);     
      theGraph.addEdge(9, 21);     
      theGraph.addEdge(9, 11);     
      theGraph.addEdge(21, 11);     
      theGraph.addEdge(21, 12);     
      theGraph.addEdge(22, 12);     
      theGraph.addEdge(22, 13);
      
      theGraph.addEdge(14, 23);     
      theGraph.addEdge(15, 16);     
      theGraph.addEdge(17, 16);     
      theGraph.addEdge(17, 18);     
      theGraph.addEdge(19, 24);     
      theGraph.addEdge(21, 24);     
      theGraph.addEdge(23, 24);
      
      System.out.print("Visits: ");
      theGraph.dfs();             // depth-first search
      System.out.println();
      }  // end main()
   }  // end class DFSApp
////////////////////////////////////////////////////////////////

