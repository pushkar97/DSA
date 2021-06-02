package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringJoiner;

public class BFS {

    public <k> int bfs(Graph<k> graph,k source, k target) {

        Queue<Graph.Node<k>> toVisit = new LinkedList<>();
        boolean[] visited = new boolean[graph.nodes.size()];
        int[] parent = new int[graph.nodes.size()];

        Graph.Node<k> sourceNode = graph.getNodeByValue(source);
        toVisit.add(sourceNode);
        int sourceIndex = graph.nodes.indexOf(sourceNode);
        visited[sourceIndex] = true;
        parent[sourceIndex] = -1;

        int targetIndex = -1;
        while (!toVisit.isEmpty()){
            Graph.Node<k> curr = toVisit.poll();
            if(curr.getValue() == target) {
                targetIndex = graph.nodes.indexOf(curr);
                break;
            }
            curr.getEdges().forEach(n -> {
                if(!visited[graph.nodes.indexOf(n)]){
                    visited[graph.nodes.indexOf(n)] = true;
                    toVisit.add(n);
                    parent[graph.nodes.indexOf(n)] = graph.nodes.indexOf(curr);
                }
            });
        }
        int distance = -1;
        Stack<k> path = new Stack<>();
        while (targetIndex != -1) {
            path.push(graph.nodes.get(targetIndex).getValue());
            targetIndex = parent[targetIndex];
            distance++;
        }
        StringJoiner j = new StringJoiner(" -> ", "[", "]");
        while (!path.isEmpty()) j.add(path.pop().toString());
        System.out.println(j);
        return distance;
    }

    public static void main(String[] args) {
        Graph<String> cities = new Graph<>("Mumbai", "Bengaluru", "Kolkata", "Chennai", "Jaipur");
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
        BFS b = new BFS();
        System.out.println(b.bfs(cities, "Kolkata", "Chennai"));
    }
}
