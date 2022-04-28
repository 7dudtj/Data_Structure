/*
DijkstraSP - Dijkstra 알고리즘(최단경로)

수행시간 : O(N^2)
N : 정점의 수

모든 정점이 연결되어있을때 사용. 그렇지 않을 경우, 96번째줄 밑에 'if (minVertex == -1) break;'를 넣을것
*/

import java.util.List;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) {
    // System.out.println("Hello Wolrd!");

    int N = 7;
    int[] answer;
    int s = 0; // 출발 지점
    List<Edge>[] adjList = new List[N];
    for (int i = 0; i < N; i++){
      adjList[i] = new LinkedList<>();
    }
    Edge e1 = new Edge(0,1,9); Edge e1a = new Edge(1,0,9);
    Edge e2 = new Edge(0,2,10); Edge e2a = new Edge(2,0,10);
    Edge e3 = new Edge(1,4,5); Edge e3a = new Edge(4,1,5);
    Edge e4 = new Edge(4,2,7); Edge e4a = new Edge(2,4,7);
    Edge e5 = new Edge(4,6,1); Edge e5a = new Edge(6,4,1);
    Edge e6 = new Edge(5,2,2); Edge e6a = new Edge(2,5,2);
    Edge e7 = new Edge(6,5,6); Edge e7a = new Edge(5,6,6); 
    Edge e8 = new Edge(1,6,3); Edge e8a = new Edge(6,1,3);
    Edge e9 = new Edge(1,3,10); Edge e9a = new Edge(3,1,10);
    Edge e10 = new Edge(6,3,8); Edge e10a = new Edge(3,6,8);
    Edge e11 = new Edge(5,3,4); Edge e11a = new Edge(3,5,4);
    Edge e12 = new Edge(2,3,9); Edge e12a = new Edge(3,2,9);
    adjList[0].add(e1); adjList[1].add(e1a);
    adjList[0].add(e2); adjList[2].add(e2a);
    adjList[1].add(e3); adjList[4].add(e3a);
    adjList[4].add(e4); adjList[2].add(e4a);
    adjList[4].add(e5); adjList[6].add(e5a); 
    adjList[5].add(e6); adjList[2].add(e6a);
    adjList[6].add(e7); adjList[5].add(e7a);
    adjList[1].add(e8); adjList[6].add(e8a);
    adjList[1].add(e9); adjList[3].add(e9a);
    adjList[6].add(e10); adjList[3].add(e10a);
    adjList[5].add(e11); adjList[3].add(e11a);
    adjList[2].add(e12); adjList[3].add(e12a);

    DijkstraSP dsp = new DijkstraSP(adjList);
    answer = dsp.shortestPath(s);
    System.out.println("출발지점 : " + s);
    for (int i = 0; i < answer.length; i++) System.out.println(i + "까지의 거리 : " + answer[i]);
  }  
}

class Edge{
  int vertex; // 간선의 한쪽 끝 정점
  int adjvertex; // 간선의 다른쪽 끝 정점
  int weight; // 간선의 가중치
  public Edge(int u, int v, int wt){
    vertex = u;
    adjvertex = v;
    weight = wt;
  }
}

class DijkstraSP{
  public int N; // 그래프 정점의 수
  List<Edge>[] graph;
  public int[] previous; // 최단경로상 이전 정점을 기록하기 위해
  public DijkstraSP(List<Edge>[] adjList){
    N = adjList.length;
    previous = new int[N];
    graph = adjList;
  }
  public int[] shortestPath(int s){
    boolean[] visited = new boolean[N];
    int[] D = new int[N];
    // 초기화
    for (int i = 0; i < N; i++){
      visited[i] = false;
      previous[i] = -1;
      D[i] = Integer.MAX_VALUE;
    }
    previous[s] = 0; // 시작점 s의 관련 정보 초기화
    D[s] = 0;
    for (int k = 0; k < N; k++){ // 방문 안된 정점들 중에서
      int minVertex = -1; // D원소 같이 최소인 minVertex 찾기
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < N; j++){
        if ((!visited[j]) && (D[j] < min)){
          min = D[j];
          minVertex = j;
        }
      }
      visited[minVertex] = true;
      for (Edge e: graph[minVertex]){ // minVertex에 인접한 각 정점에 대해
        if (!visited[e.adjvertex]){ // 아직 방문 안된 정점에 대해 
          int currentDist = D[e.adjvertex];
          int newDist = D[minVertex] + e.weight;
          if (newDist < currentDist){
            D[e.adjvertex] = newDist; // 간선완화
            previous[e.adjvertex] = minVertex;
          }
        }
      }
    }
    return D;
  }
}
