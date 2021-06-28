package study.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra {
    class Edge implements Comparable<Edge> {
        int distance;
        String vertex;

        public Edge(int distance, String vertex) {
            this.distance = distance;
            this.vertex = vertex;
        }

        public String toString() {
            return "vertex: " + this.vertex + ", distance: " + this.distance;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.distance - edge.distance;
        }
    }

    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start) {
        Edge edgeNode, adjacentNode;
        int currentDistance, weight, distance;
        String currentVertex, adjacent;
        ArrayList<Edge> nodeList;

        //초기화
        HashMap<String, Integer> distances = new HashMap<>();
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(distances.get(start), start));

        //알고리즘
        //priority queue에 아무 것도 없을 때까지
        while (priorityQueue.size() > 0) {
            //현재 봐야하는 노드를 priority queue에서 뽑기
            edgeNode = priorityQueue.poll();
            currentDistance = edgeNode.distance;
            currentVertex = edgeNode.vertex;

            //현재 봐야하는 노드의 가중치가 기존의 가중치 리스트에 있는 동일 노드의 가중치보다 클 경우에는 볼 필요가 없음
            if (distances.get(currentVertex) < currentDistance) {
                continue;
            }

            //현재 뽑은 노드에서 이동가능한 인접 노드들 리스트
            nodeList = graph.get(currentVertex);

            //이동 가능한 인접 노드를 하나씩 확인하면서,
            //(현재 노드의 가중치 + 인접 노드의 가중치)를 계산
            //(현재 노드의 가중치 + 인접 노드의 가중치)가 가중치 리스트에 있는 인접 노드의 가중치보다 작을 경우
            //가중치 리스트의 현재 뽑은 노드의 인접 노드의 가중치를 변경
            //가중치가 변경 되었기 때문에, priority queue에 (현재 노드의 가중치 + 인접 노드의 가중치)를 distance
            //인접 노드의 이름을 vertex로 갖는 edge를 추가
            for (int i = 0; i < nodeList.size(); i++) {
                adjacentNode = nodeList.get(i);
                adjacent = adjacentNode.vertex;
                weight = adjacentNode.distance;
                distance = weight + currentDistance;

                if (distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);
                    priorityQueue.add(new Edge(distance, adjacent));
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {

    }
}
