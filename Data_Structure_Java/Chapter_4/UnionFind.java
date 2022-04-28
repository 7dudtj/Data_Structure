/*
상호배타적 집합의 Union-Find

union : O(1)
find : O(log*N)
*/

public class Main {
  public static void main(String[] args) {
    Node[] a = new Node[10];
    for (int i = 0; i < 10; i++) a[i] = new Node(i, 1);
    UnionFind uf = new UnionFind(a);
    uf.union(2,1);
    uf.union(2,6);
    uf.union(7,3);
    uf.union(4,5);
    uf.union(9,5);
    uf.union(7,2);
    uf.union(7,8);
    uf.union(0,4);
    uf.union(9,1);
    for (int i = 0; i < 10; i++){
      System.out.println(i + " parent : " + uf.a[i].getParent());
    }
  }
}

class Node{
  int parent;
  int rank;
  public Node(int newParent, int newRank){
    parent = newParent;
    rank = newRank;
  }
  public int getParent(){return parent;}
  public int getRank(){return rank;}
  public void setParent(int newParent){parent = newParent;}
  public void setRank(int newRank){rank = newRank;}
}

class UnionFind{
  protected Node[] a;
  // 생성자
  public UnionFind(Node[] iarray){
    a = iarray;
  }
  // i가 속한 집합의 루트를 재귀적으로 찾고 경로상의 각 원소의 부모를 루트로 만든다.
  // 경로압축
  protected int find(int i){
    if (i != a[i].getParent())
      a[i].setParent(find(a[i].getParent()));
    return a[i].getParent();  
  }
  // Union 연산
  public void union(int i, int j){
    int iroot = find(i);
    int jroot = find(j);
    if (iroot == jroot) return; // 루트노드가 동일하면 더 이상의 수행없이 그대로 리턴
    // rank가 높은 루트노드가 승자가 된다.
    if (a[iroot].getRank() > a[jroot].getRank())
      a[jroot].setParent(iroot); // iroot가 승자
    else if (a[iroot].getRank() < a[jroot].getRank())
      a[iroot].setParent(jroot); // jroot가 승자
    else{
      a[jroot].setParent(iroot); // 둘 중에 하나 임의로 승자
      int t = a[iroot].getRank() + 1;
      a[iroot].setRank(t); // iroot의 rank 1 증가
    }
  }
}
