// bfs.java
// demonstrates breadth-first search
// to run this program: C>java BFSApp
////////////////////////////////////////////////////////////////
class Queue
   {
   private final int SIZE = 20;
   private int[] queArray;
   private int front;
   private int rear;
// -------------------------------------------------------------
   public Queue()            // constructor
      {
      queArray = new int[SIZE];
      front = 0;
      rear = -1;
      }
// -------------------------------------------------------------
   public void insert(int j) // put item at rear of queue
      {
      if(rear == SIZE-1)
         rear = -1;
      queArray[++rear] = j;
      }
// -------------------------------------------------------------
   public int remove()       // take item from front of queue
      {
      int temp = queArray[front++];
      if(front == SIZE)
         front = 0;
      return temp;
      }
// -------------------------------------------------------------
   public boolean isEmpty()  // true if queue is empty
      {
      return ( rear+1==front || (front+SIZE-1==rear) );
      }
// -------------------------------------------------------------
   }  // end class Queue
////////////////////////////////////////////////////////////////
class Vertex
   {
   public char label;        // label (e.g. 'A')
   public boolean wasVisited;
// -------------------------------------------------------------
   public Vertex(char lab)   // constructor
      {
      label = lab;
      wasVisited = false;
      }
// -------------------------------------------------------------
   }  // end class Vertex
////////////////////////////////////////////////////////////////
class Graph
   {
   private boolean directed;
   private final int MAX_VERTS = 20;
   private Vertex vertexList[]; // list of vertices
   private int adjMat[][];      // adjacency matrix
   private int nVerts;          // current number of vertices
   private Queue theQueue;
// ------------------------------------------------------------
   public Graph(boolean DirectedGraph)               // constructor
      {
        directed=DirectedGraph; // set flag whether or not this graph is directed or undirected
        vertexList = new Vertex[MAX_VERTS];
                                          // adjacency matrix
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int j=0; j<MAX_VERTS; j++)      // set adjacency
           for(int k=0; k<MAX_VERTS; k++)   //    matrix to 0
              adjMat[j][k] = 0;
        theQueue = new Queue();
      }  // end constructor
// -------------------------------------------------------------
   public void addVertex(char lab)
      {
      vertexList[nVerts++] = new Vertex(lab);
      }
// -------------------------------------------------------------
   public void addEdge(int start, int end)
      {
      adjMat[start][end] = 1;
      if ( !directed ) adjMat[end][start] = 1;
      }
// -------------------------------------------------------------
   public void displayAdjMatrix()
   {
       for(int i=0;i<nVerts;i++)
       {
           for(int j=0;j<nVerts;j++)
           {
               System.out.print(adjMat[i][j]+" ");
           }
           System.out.println();
       }
   }
   
   public void displayVertex(int v)
      {
      System.out.print(vertexList[v].label);
      }
// -------------------------------------------------------------
   public void bfs()                   // breadth-first search
      {                                // begin at vertex 0
       
      displayAdjMatrix();
      vertexList[0].wasVisited = true; // mark it
      displayVertex(0);                // display it
      theQueue.insert(0);              // insert at tail
      int v2;

      while( !theQueue.isEmpty() )     // until queue empty,
         {
         int v1 = theQueue.remove();   // remove vertex at head
         // until it has no unvisited neighbors
         while( (v2=getAdjUnvisitedVertex(v1)) != -1 )
            {                                  // get one,
            vertexList[v2].wasVisited = true;  // mark it
            displayVertex(v2);                 // display it
            theQueue.insert(v2);               // insert it
            }   
         }  // end while(queue not empty)

      // queue is empty, so we're done
      for(int j=0; j<nVerts; j++)             // reset flags
         vertexList[j].wasVisited = false;
      }  // end bfs()
// -------------------------------------------------------------
   // returns an unvisited vertex adj to v
   public int getAdjUnvisitedVertex(int v)
      {
      for(int j=0; j<nVerts; j++)
         if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
            return j;
      return -1;
      }  // end getAdjUnvisitedVertex()
// -------------------------------------------------------------
   }  // end class Graph
////////////////////////////////////////////////////////////////
class BFSApp
   {
   public static void main(String[] args)
      {
      Graph theGraph = new Graph(true);
      theGraph.addVertex('0');    // 0  (start for bfs)
      theGraph.addVertex('1');    // 1
      theGraph.addVertex('2');    // 2
      theGraph.addVertex('3');    // 3
      theGraph.addVertex('4');    // 4
      theGraph.addVertex('5');    // 5
      theGraph.addVertex('6');    // 6
      theGraph.addVertex('7');    // 7
	  	  
      theGraph.addEdge(0, 1);     // AB
      theGraph.addEdge(1, 3);     // AD
      theGraph.addEdge(2, 1);     // AE
      theGraph.addEdge(3, 2);     // BC
      theGraph.addEdge(3, 4);     // BE
      theGraph.addEdge(4, 5);     // CF
      theGraph.addEdge(4, 6);     // DG
      theGraph.addEdge(5, 7);     // EG
      theGraph.addEdge(6, 4);     // FH
      theGraph.addEdge(6, 7);     // FH
      theGraph.addEdge(7, 5);     // FH
      theGraph.addEdge(7, 6);     // FH
	  
      System.out.println("Visits: ");
      theGraph.bfs();             // breadth-first search
      System.out.println();
      }  // end main()
   }  // end class BFSApp
////////////////////////////////////////////////////////////////

