/*
BellmanFordSP - BellmanFord 알고리즘(최단경로)

수행시간 : O(N^3)
인접리스트 사용시 수행시간 : O(NM)
N : 정점의 수, M : 간선의 수

출발 정점으로부터 모든 정점을 방문 가능할 때에만 작동
방문 불가한 점은 D 값을 0으로 따로 처리해주어야함
*/

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello Wolrd!");

    int N = 8;
    int inf = Integer.MAX_VALUE;
    int[][] map = new int[N][N];
    for (int i = 0; i < N; i++){
      for (int j = 0; j < N; j++){
        map[i][j] = inf;
      }
    }
    map[0][1] = 1; map[0][3] = 2; map[1][3] = -2; map[3][4] = -1;
    map[1][4] = 1; map[1][5] = 6; map[1][2] = 4; map[4][6] = 4;
    map[5][2] = 1; map[7][5] = 3; map[2][7] = 2; map[6][7] = 1;
    map[6][2] = -1;

    // show map
    for (int i = 0; i < N; i++){
      for (int j = 0; j < N; j++){
        System.out.print(String.format("%10d", map[i][j]) + " ");
      }
      System.out.println();
    }

    BellmanFord bf = new BellmanFord(N);
    bf.shortestPath(0, map);
    bf.show();
    bf.printPaths(0);
  }  
}

class BellmanFord{
  public static final int INF = Integer.MAX_VALUE;
  private int D[];
  private int previous[]; // 경로 추출을 위해
  private int N;

  // 생성자
  public BellmanFord(int numOfVertices){
    N = numOfVertices;
    D = new int[N]; // 최단거리 저장
    previous = new int[N]; // 최단경로 추출하기 위해
  }

  public void shortestPath(int s, int adjMatrix[][]){
    for (int i = 0; i < N; i++){
      D[i] = INF; // 초기화
      previous[i] = -1;
    }
      
    D[s] = 0; previous[s] = 0; // D[0] = 0; << 접근 불가한 0에 대한 처리
    for (int k = 0; k < N-1; k++){ // 총 N-1번 반복
      for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
          if (adjMatrix[i][j] != INF){
            if (D[j] > D[i] + adjMatrix[i][j]){
              D[j] = D[i] + adjMatrix[i][j]; // 간선완화
              previous[j] = i; // i 덕분에 j까지 거리가 단축됨
            }
          } 
        }
      }
    }
  }
  // 결과 출력
  public void printPaths(int s){
    System.out.println("정점 " + s + "으로부터의 최단거리");
    for (int i = 0; i < N; i++){
      if (i != s){
        System.out.println("["+s+","+i+"] = "+D[i]);
      }
    }
  }
  // 테스트
  public void show(){
    for (int i = 0; i < N; i++){
      System.out.println("D : "+D[i]+", Prev : "+previous[i]);
    }
  }
}
