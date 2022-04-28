/*
레드블랙트리

탐색 : O(logN)
삽입 : O(logN)
최솟값 삭제 : O(logN)
*/

public class Main {
  public static void main(String[] args) {
    RedBlackTree rbt = new RedBlackTree();
    rbt.put(50, "apple");
    System.out.println(rbt.get(50));
    rbt.put(40, "bpple");
    rbt.put(20, "cpple");
    rbt.put(60, "dpple");
    rbt.put(10, "epple");
    rbt.put(80, "fpple");
    rbt.put(90, "gpple");
    System.out.println(rbt.get(10));
    rbt.deleteMin();
    rbt.deleteMin();
    rbt.deleteMin();
    rbt.deleteMin();
    rbt.deleteMin();
    rbt.deleteMin();
    System.out.println(rbt.get(90));
    rbt.deleteMin();
  }
}

class RedBlackTree<Key extends Comparable<Key>, Value>{
  private static final boolean RED = true;
  private static final boolean BLACK = false;
  private Node root;
  // Node 클래스
  private class Node{
    Key id;
    Value name;
    Node left, right;
    boolean color; // 부모노드 link의 색
    // 노드 생성자
    public Node(Key k, Value v, boolean col){
      id = k;
      name = v;
      color = col;
      left = right = null;
    } 
  }
  private boolean isEmpty(){return root == null;}
  private boolean isRed(Node n){
    if (n == null) return false; // null의 색은 블랙
    return (n.color == RED);
  }
  // 탐색 연산
  public Value get(Key k){return get(root, k);} // 탐색 연산
  public Value get(Node n, Key k){
    if (n == null) return null; // 탐색 실패
    int t = n.id.compareTo(k);
    if (t > 0) return get(n.left, k); // 왼쪽 서브트리 탐색
    else if (t < 0) return get(n.right, k); // 오른쪽 서브트리 탐색
    else return (Value) n.name; // 탐색 성공
  }
  // 기본 연산
  private Node rotateLeft(Node n){
    Node x = n.right;
    n.right = x.left;
    x.left = n;
    x.color = n.color;
    n.color = RED;
    return x;
  }
  private Node rotateRight(Node n){
    Node x = n.left;
    n.left = x.right;
    x.right = n;
    x.color = n.color;
    n.color = RED;
    return x;
  }
  private void flipColors(Node n){
    n.color = !n.color;
    n.left.color = !n.left.color;
    n.right.color = !n.right.color;
  }
  private Node moveRedLeft(Node n){
    flipColors(n); // case 1과 case 2
    if (isRed(n.right.left)){ // case 2
      n.right = rotateRight(n.right);
      n = rotateLeft(n);
      flipColors(n);
    }
    return n;
  }
  private Node fixUp(Node n){
    if (isRed(n.right)) n = rotateLeft(n);
    if (isRed(n.left) && isRed(n.left.left)) n = rotateRight(n);
    if (isRed(n.left) && isRed(n.right)) flipColors(n);
    return n;
  }
  // 삽입 연산
  public void put(Key k, Value v){
    root = put(root, k, v);
    root.color = BLACK;
  }
  private Node put(Node n, Key k, Value v){
    if (n == null) return new Node(k, v, RED); // 새로운 레드 노드 생성
    int t = k.compareTo(n.id);
    if (t < 0) n.left = put(n.left, k, v);
    else if (t > 0) n.right = put(n.right, k, v);
    else n.name = v; // k가 트리에 있는 경우 v로 name을 갱신
    // 오른쪽 link가 레드인 경우 바로잡는다.
    if (!isRed(n.left) && isRed(n.right)) n = rotateLeft(n);
    if (isRed(n.left) && isRed(n.left.left)) n = rotateRight(n);
    if (isRed(n.left) && isRed(n.right)) flipColors(n);
    return n;
  }
  // 최솟값 삭제
  public void deleteMin(){
    root = deleteMin(root);
    if (root == null) return; // 루트가 최솟값일 경우
    root.color = BLACK;
  }
  private Node deleteMin(Node n){
    if (n.left == null) return null;
    if (!isRed(n.left) && !isRed(n.left.left))
      n = moveRedLeft(n);
    n.left = deleteMin(n.left);
    return fixUp(n);  
  }
}
