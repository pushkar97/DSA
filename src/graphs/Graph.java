package graphs;

import java.util.*;
import java.util.stream.Collectors;

public class Graph<V> {

    List<Node<V>> nodes;

    public Graph(){
        nodes = new ArrayList<>();
    }

    public Graph(V... nodes){
        this.nodes = Arrays.stream(nodes).map(Node::new).collect(Collectors.toList());
    }

    public boolean addNode(V node) {
        return nodes.add(new Node<>(node));
    }

    public List<Node<V>> getNodes() {
        return nodes;
    }

    public boolean addEdge(V source, V target) {
        return nodes.stream().filter(n -> n.value.equals(source)).findFirst().get()
                .addEdge(nodes.stream().filter(n -> n.value.equals(target)).findFirst().get());
    }

    public Node<V> getNodeByValue(V value) {
        return nodes.stream().filter(v -> v.value.equals(value)).findFirst().orElseThrow(RuntimeException::new);
    }

    public static class Node<V> {

        private final V value;
//        private final Set<Node<V>> edges;
        private final Map<Node<V>,Integer> edges;

        public Node(V value){
            this.value = value;
            this.edges = new HashMap<>();
        }

        public Node(V value, Node<V>... edges){
            this(value);
            for(Node<V> edge : edges) this.edges.put(edge, 1);
        }

        public boolean addEdge(Node<V> edge, int weight) {
            return null == this.edges.put(edge, weight);
        }

        public boolean addEdge(Node<V> edge) {
            return this.addEdge(edge, 1);
        }

        public V getValue() {
            return value;
        }

        public Set<Node<V>> getEdges() {
            return edges.keySet();
        }
    }
}
