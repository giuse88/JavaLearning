import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: giuseppe
 * Date: 08/02/2014
 * Time: 19:12
 * To change this template use File | Settings | File Templates.
 */


public class Graph {

    Map<String, Vertex>  graph;

    Graph(){
        graph = new HashMap<String, Vertex>();
    }

    // dfs
    public void traverse(Vertex root, String identifier){
        root.visited = true;



        System.out.print("-->" + root.getIdentifier());

        if (root.getIdentifier().equals(identifier))
            return;

        for (Edge e : root.getNeighbours())
            if(!e.to.isVisited())
               traverse(e.to, identifier);
    }

    public void traverse( String start, String end){
        Vertex root = graph.get(start);
        setAllVertexUnvisited();
        System.out.println("Starting node : " + root.getIdentifier());
        traverse(root, end);
        System.out.println();
    }

    public void addVertex( String newVertexStr ){
        graph.put(newVertexStr, new Vertex(newVertexStr));
    }

    private void setAllVertexUnvisited(){
        for (Map.Entry<String, Vertex> entry : graph.entrySet())  {
            entry.getValue().visited =false;
        }
    }


    public void shortPath(String start, String end) {

        Map<Vertex, Integer> graphNode = new HashMap<Vertex, Integer>();
        Vector<Vertex> shortPath= new Vector<Vertex>();

        for (Map.Entry<String, Vertex> entry : graph.entrySet())  {
            graphNode.put(entry.getValue(), Integer.MAX_VALUE);
        }

        setAllVertexUnvisited();
        graphNode.put(graph.get(start), 0);

        shortPath.add(graph.get(start));



    }

    public boolean  addEdge(String first, String second,  int cost ) {
       if ( !graph.containsKey(first) ||  !graph.containsKey(second))
           return false;

        Vertex firstVertex = graph.get(first);
        Vertex secondVertex = graph.get(second);

        firstVertex.addNeighbour(new Edge(cost, secondVertex));
        secondVertex.addNeighbour(new Edge(cost, firstVertex));
        return true;
    }

    public String toString() {

        if(graph.isEmpty())
            return "The graph is empty";

        String output = new String();
        for (Map.Entry<String, Vertex> entry : graph.entrySet())  {
            output += entry.getValue().toString() + "\n";
        }
        return output;
    }


    public class Vertex{
        String identifier;
        List<Edge> neighbours = null;
        boolean visited = false;

        public Vertex(String identifier){
            neighbours = new ArrayList<Edge>();
            this.identifier= identifier;
        }

        public void setVisited() {
             visited= true;
        }
        public boolean isVisited() {
            return visited;
        }
        public String getIdentifier() {
            return identifier;
        }

        public void addNeighbour (Edge newLink) {
           neighbours.add(newLink);
        }

        public List<Edge> getNeighbours() {
            return neighbours;
        }

        public String toString(){
           return this.identifier + " : " + this.neighbours.toString();
        }

    }

    public class Edge implements Comparable {

        int weight;
        Vertex to= null;

        Edge(int weight, Vertex to){
            this.weight=weight;
            this.to = to;
        }

        @Override
        public int compareTo(Object o) {
          Edge local = (Edge)o;
          return this.weight - local.weight;
        }

        public String toString() {
            return to.getIdentifier() + ":" + weight;
        }
    }

}



