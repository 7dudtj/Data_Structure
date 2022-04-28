/*
PrimMST - Prim 알고리즘(최소신장트리)

수행시간 : O(N^2)
이진힙 사용시 수행시간 : O(MlogN)
N : 정점의 수, M : 간선의 수행
*/

import java.util.List;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello Wolrd!");

    int N = 7;
    int[] answer;
    List<Edge>[] adjList = new List[N];
    for (int i = 0; i < N; i++){
      adjList[i] = new LinkedList<>();
    }
    Edge e1 = new Edge(1,9); Edge e111 = new Edge(0,9);
    Edge e2 = new Edge(2,10); Edge e22 = new Edge(0,10);
    Edge e3 = new Edge(4,5); Edge e33 = new Edge(1,5);
    Edge e4 = new Edge(2,7); Edge e44 = new Edge(4,7);
    Edge e5 = new Edge(6,1); Edge e55 = new Edge(4,1);
    Edge e6 = new Edge(2,2); Edge e66 = new Edge(5,2);
    Edge e7 = new Edge(5,6); Edge e77 = new Edge(6,6);
    Edge e8 = new Edge(6,3); Edge e88 = new Edge(1,3);
    Edge e9 = new Edge(3,10); Edge e99 = new Edge(1,10);
    Edge e10 = new Edge(3,8); Edge e1010 = new Edge(6,8);
    Edge e11 = new Edge(3,4); Edge e1111 = new Edge(5,4);
    Edge e12 = new Edge(3,9); Edge e1212 = new Edge(2,9);
    adjList[0].add(e1); adjList[1].add(e111);
    adjList[0].add(e2); adjList[2].add(e22);
    adjList[1].add(e3); adjList[4].add(e33);
    adjList[4].add(e4); adjList[2].add(e44);
    adjList[4].add(e5); adjList[6].add(e55);
    adjList[5].add(e6); adjList[2].add(e66);
    adjList[6].add(e7); adjList[5].add(e77);
    adjList[1].add(e8); adjList[6].add(e88);
    adjList[1].add(e9); adjList[3].add(e99);
    adjList[6].add(e10); adjList[3].add(e1010);
    adjList[5].add(e11); adjList[3].add(e1111);
    adjList[2].add(e12); adjList[3].add(e1212);

    PrimMST pmst = new PrimMST(adjList);
    answer = pmst.mst(3);
    for (int i: answer) System.out.print(i+" ");
  }  
}

class Edge{
  int adjvertex; // 간선의 다른 한쪽의 끝 정점
  int weight; // 간선의 가중치
  public Edge(int v, int wt){
    adjvertex = v;
    weight = wt;
  }
}

class PrimMST{
  int N; // 그래프 정점의 수
  List<Edge>[] graph;

  // 생성자
  public PrimMST(List<Edge>[] adjList){
    N = adjList.length;
    graph = adjList;
  }

  // Prim 알고리즘, s는 시작정점
  public int[] mst(int s){
    boolean[] visited = new boolean[N]; // 방문된 정점은 true로
    int[] D = new int[N];
    int[] previous = new int[N]; // 최소신장트리의 간선으로 확정될 때 간선의 다른 쪽 (트리의)꿑점
    for (int i = 0; i < N; i++){ // 초기화
      visited[i] = false;
      previous[i] = -1;
      D[i] = Integer.MAX_VALUE; // D[i]를 최댓값으로 초기화
    }
    previous[s] = 0; // 시작정점의 s의 관련 정보 초기화
    D[s] = 0;

    for (int k = 0; k < N; k++){ // 방문안된 정점들의 D 원소들 중에서 최솟값가진 정점 찾기
      int minVertex = -1;
      int min = Integer.MAX_VALUE;
      for (int j = 0; j < N; j++){
        if ((!visited[j]) && (D[j] < min)){
          min = D[j];
          minVertex = j;
        }
      }
      System.out.println(minVertex); // for test
      visited[minVertex] = true;
      for (Edge i: graph[minVertex]){ // minVertex에 인접한 각 정점의 D 원소 갱신
        if (!visited[i.adjvertex]){ // 트리에 아직 포함 안된 정점이라면
          int currentDist = D[i.adjvertex];
          int newDist = i.weight;
          if (newDist < currentDist){
            D[i.adjvertex] = newDist; // minVertex와 연결된 정점들의 D 원소 갱신
            previous[i.adjvertex] = minVertex; // 트리 간선 추출을 위해
          }
        }
      }
    }
    return previous; // 최소신장트리 간선 정보 리턴
  }
}
