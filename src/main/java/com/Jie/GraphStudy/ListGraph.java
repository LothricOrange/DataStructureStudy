package com.Jie.GraphStudy;


import java.util.*;

public class ListGraph<V, E> extends Graph<V, E> {
    private HashMap<V, Vertex<V, E>> vertices = new HashMap();
    private HashSet<Edge<V, E>> edges = new HashSet<>();

    public int verticesSize() {
        return vertices.size();
    }

    public int edgesSize() {
        return edges.size();
    }

    public void addVertex(V value) {
        if (vertices.containsKey(value)) return;
        vertices.put(value, new Vertex<>(value));
    }

    public void removeVertex(V value) {
        Vertex<V, E> vertex = vertices.get(value);
        if (vertex == null) return;

        Iterator<Edge<V, E>> outIterator = vertex.outEdge.iterator();
        while (outIterator.hasNext()) {
            Edge<V, E> edge = outIterator.next();
            edge.to.inEdge.remove(edge);
            outIterator.remove();
            edges.remove(edge);
        }

        Iterator<Edge<V, E>> inIterator = vertex.inEdge.iterator();
        while (inIterator.hasNext()) {
            Edge<V, E> edge = inIterator.next();
            edge.from.outEdge.remove(edge);
            inIterator.remove();
            edges.remove(edge);
        }

    }

    public void addEdge(V from, V to) {
        addEdge(from, to, null);
    }

    public void addEdge(V from, V to, E weight) {
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) {
            fromVertex = new Vertex<>(from);
            vertices.put(from, fromVertex);
        }

        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) {
            toVertex = new Vertex<>(to);
            vertices.put(to, toVertex);
        }
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        edge.weight = weight;

        if (fromVertex.outEdge.remove(edge)) {
            toVertex.inEdge.remove(edge);
            edges.remove(edge);
        }

        fromVertex.outEdge.add(edge);
        toVertex.inEdge.add(edge);
        edges.add(edge);

    }

    public void removeEdge(V from, V to) {
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) return;
        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) return;
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);

        if (fromVertex.outEdge.remove(edge)) {
            toVertex.inEdge.remove(edge);
            edges.remove(edge);
        }

    }

    public void bfs(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;
        HashSet<Vertex<V, E>> selected = new HashSet<>();
        Queue<Vertex<V, E>> queue = new LinkedList<>();
        queue.offer(beginVertex);
        selected.add(beginVertex);
        while (!queue.isEmpty()) {
            Vertex<V, E> vertex = queue.poll();
            System.out.println(vertex.value);
            for (Edge<V, E> edge : vertex.outEdge) {
                if (selected.contains(edge.to)) continue;
                queue.offer(edge.to);
                selected.add(edge.to);
            }
        }
    }

    public void dfs(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;
        HashSet<Vertex<V, E>> visitedVertex = new HashSet<>();
        Stack<Vertex<V, E>> stack = new Stack<>();
        stack.push(beginVertex);
        visitedVertex.add(beginVertex);

        while (!stack.isEmpty()) {
            Vertex<V, E> vertex = stack.pop();
            if (visitedVertex.contains(vertex)) continue;
            for (Edge<V, E> edge : vertex.outEdge) {
                stack.push(edge.from);
                stack.push(edge.to);
                System.out.println(edge.to.value);
                visitedVertex.add(edge.to);
            }

        }
    }


    public List<V> topologicalSort() {
        List<V> list = new ArrayList<>();
        Queue<Vertex<V, E>> queue = new LinkedList<>();
        HashMap<Vertex<V, E>, Integer> map = new HashMap<>();
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            int inSize = vertex.outEdge.size();
            if (inSize == 0) {
                queue.offer(vertex);
            } else {
                map.put(vertex, inSize);
            }
        });

        while (!queue.isEmpty()) {
            Vertex<V, E> vertex = queue.poll();
            list.add(vertex.value);

            for (Edge<V, E> edge : vertex.outEdge) {
                int inSize = map.get(edge.to) - 1;
                if (inSize == 0) {
                    queue.offer(edge.to);
                } else {
                    map.put(edge.to, inSize);
                }
            }

        }
        return list;

    }

    @Override
    public Set<EdgeInfo<V, E>> mst() {
        return Math.random() > 0.5 ? prim() : kruskal();
    }

    private Set<EdgeInfo<V, E>> prim() {
        return null;
    }

    private Set<EdgeInfo<V, E>> kruskal() {
        return null;
    }

    public Map<V, E> shortestPath(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return null;
        Map<V, E> selectedPath = new HashMap<>();
        Map<Vertex<V, E>, E> paths = new HashMap<>();
        for (Edge<V, E> edge : beginVertex.outEdge) {
            paths.put(edge.to, edge.weight);
        }
        while (!paths.isEmpty()) {
            Map.Entry<Vertex<V, E>, E> minPath = getMinPath(paths);
            Vertex<V, E> minVertex = minPath.getKey();
            selectedPath.put(minVertex.value, minPath.getValue());
            paths.remove(minVertex);

            for (Edge<V, E> edge : minVertex.outEdge) {
                if (selectedPath.containsKey(edge.to.value)) continue;

                E oldWeight = paths.get(edge.to);
                E newWeight = weightManager.add(minPath.getValue(), edge.weight);
                if (oldWeight == null || weightManager.compare(oldWeight, newWeight) > 0) {
                    paths.put(edge.to, newWeight);
                }
            }
        }
        selectedPath.remove(begin);
        return selectedPath;
    }

    private Map.Entry<Vertex<V, E>, E> getMinPath(Map<Vertex<V, E>, E> paths) {
        Iterator<Map.Entry<Vertex<V, E>, E>> it = paths.entrySet().iterator();
        Map.Entry<Vertex<V, E>, E> minEntry = it.next();
        while (it.hasNext()) {
            Map.Entry<Vertex<V, E>, E> entry = it.next();
            if (weightManager.compare(entry.getValue(), minEntry.getValue()) < 0) {
                minEntry = entry;
            }
        }
        return minEntry;
    }


    private static class Vertex<V, E> {
        V value;
        HashSet<Edge<V, E>> inEdge = new HashSet<>();
        HashSet<Edge<V, E>> outEdge = new HashSet<>();

        public Vertex(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            return Objects.equals(value, ((Vertex<V, E>) o).value);
        }

        @Override
        public int hashCode() {
            int result = value != null ? value.hashCode() : 0;
            return result;
        }

        @Override
        public String toString() {
            return value == null ? "null" : value.toString();
        }
    }

    private static class Edge<V, E> {
        Vertex<V, E> from;
        Vertex<V, E> to;
        E weight;

        public Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
        }

        EdgeInfo<V, E> info() {
            return new EdgeInfo<>(from.value, to.value, weight);
        }

        @Override
        public boolean equals(Object o) {
            Edge<V, E> edge = (Edge<V, E>) o;
            return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {
            return from.hashCode() * 31 + to.hashCode();
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }
}
