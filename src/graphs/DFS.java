package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {

    //Recursive
    public <k>boolean dfs(Graph<k> graph, k source, k target, List<k> visited) {
        if(source.equals(target)) return true;
        visited.add(source);
        for(Graph.Node<k> n : graph.getNodeByValue(source).getEdges()){
            if(!visited.contains(n.getValue()) && dfs(graph, n.getValue(), target, visited)) return true;
        }
        return false;
    }

    //Iterative
    public <k>boolean dfs(Graph<k> graph, k source, k target) {
        List<k> visited = new ArrayList<>();
        Stack<Graph.Node<k>> stack = new Stack<>();
        stack.push(graph.getNodeByValue(source));
        visited.add(source);
        while (!stack.isEmpty()){
            Graph.Node<k> curr = stack.pop();
            if(curr.getValue().equals(target)) return true;
            for(Graph.Node<k> edge: curr.getEdges()){
                if(!visited.contains(edge.getValue())) {
                    stack.push(edge);
                    visited.add(edge.getValue());
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph<String> cities = new Graph<>("Mumbai", "Bengaluru", "Kolkata", "Chennai", "Jaipur", "Agra");
        cities.addEdge("Mumbai", "Jaipur");
        cities.addEdge("Mumbai", "Kolkata");
        cities.addEdge("Mumbai", "Bengaluru");
        cities.addEdge("Bengaluru", "Chennai");
        cities.addEdge("Bengaluru", "Mumbai");
        cities.addEdge("Chennai", "Bengaluru");
        cities.addEdge("Jaipur", "Kolkata");
        cities.addEdge("Jaipur", "Mumbai");
        cities.addEdge("Kolkata", "Jaipur");
        cities.addEdge("Kolkata", "Mumbai");
        DFS b = new DFS();
        System.out.println(b.dfs(cities, "Kolkata", "Agra", new ArrayList<>()));
        System.out.println(b.dfs(cities, "Kolkata", "Agra"));
    }
}
