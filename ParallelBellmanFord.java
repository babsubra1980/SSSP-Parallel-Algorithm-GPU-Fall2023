package path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ParallelBellmanFord {
    private static class Edge {
        int source;
        int dest;
        int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }
    
    
    public static List<Edge> generateRandomEdges(int numEdges, int numVertices, int maxWeight, int minWeight) {
        List<Edge> edges = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numEdges; i++) {
            int source = random.nextInt(numVertices);
            int dest = random.nextInt(numVertices);
            int weight = random.nextInt((maxWeight - minWeight) + 1) + minWeight;
            edges.add(new Edge(source, dest, weight));
        }

        return edges;
    }

    private static class Task implements Callable<Integer> {
        int vertex;
        int[] distance;
        List<Edge> edges;

        Task(int vertex, int[] distance, List<Edge> edges) {
            this.vertex = vertex;
            this.distance = distance;
            this.edges = edges;
        }

        @Override
        public Integer call() {
            for (Edge edge : edges) {
                if (distance[edge.source] != Integer.MAX_VALUE && distance[edge.source] + edge.weight < distance[edge.dest]) {
                    distance[edge.dest] = distance[edge.source] + edge.weight;
                }
            }
            return vertex;
        }
    }

    public static void parallelBellmanFord(int vertices, int source, List<Edge> edges) throws InterruptedException, ExecutionException {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        ExecutorService executor = Executors.newFixedThreadPool(vertices);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
        	
            futures.add(executor.submit(new Task(i, distance, edges)));
        }

        for (Future<Integer> future : futures) {
            future.get(); // Wait for tasks to complete
        }

        executor.shutdown();

        // Check for negative weight cycles
        for (Edge edge : edges) {
            if (distance[edge.source] != Integer.MAX_VALUE && distance[edge.source] + edge.weight < distance[edge.dest]) {
                System.out.println("Graph contains a negative weight cycle.");
                return;
            }
        }

        // Print the shortest distances
        for (int i = 0; i < vertices; i++) {
            System.out.println("Shortest distance from source to vertex " + i + " is " + distance[i]);
        }
    }

    public static void main(String[] args) {
//        int vertices = 5;
        int source = 0;
//        List<Edge> edges = Arrays.asList(
//            new Edge(0, 1, -1),
//            new Edge(0, 2, 4),
//            new Edge(1, 2, 3),
//            new Edge(1, 3, 2),
//            new Edge(1, 4, 2),
//            new Edge(3, 2, 5),
//            new Edge(3, 1, 1),
//            new Edge(4, 3, -3)
//        );

        int numEdges = 1000;  // Change this to the number of edges you want
        int numVertices = 250; // Change this to the number of vertices in your graph
        int maxWeight = 40;  // Change this to the maximum weight of edges
        int minWeight = -5;
        List<Edge> edges = generateRandomEdges(numEdges, numVertices, maxWeight, minWeight);

        try {
            parallelBellmanFord(numVertices, source, edges);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
