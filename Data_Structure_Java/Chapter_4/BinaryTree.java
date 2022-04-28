/*
이진트리

순회 : O(N)
노드 수 : O(N)
트리 높이 : O(N)
동일성검사 : O(N)
*/

import java.util.*;

public class Main {
  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    Node fNode = new Node(1, null, null);
    Node sNode = new Node(2, null, null);
    Node tNode = new Node(3, null, null);
    bt.setRoot(fNode);
    bt.showOrder();
    bt.getRoot().setLeft(sNode);
    bt.getRoot().setRight(tNode);
    bt.showOrder();
  }
}

class Node<Key extends Comparable<Key>>{
  private Key item;
  private Node<Key> left;
  private Node<Key> right;
  // 노드 생성자
  public Node(Key newItem, Node lt, Node rt){
    item = newItem; left = lt; right = rt;
  }
  public Key getKey(){return item;}
  public Node<Key> getLeft(){return left;}
  public Node<Key> getRight(){return right;}
  public void setKey(Key newItem) {item = newItem;}
  public void setLeft(Node<Key> lt) {left = lt;}
  public void setRight(Node<Key> rt) {right = rt;}
}

class BinaryTree<Key extends Comparable<Key>>{
  private Node root;
  // 트리 생성자
  public BinaryTree(){root = null;}
  public Node getRoot(){return root;}
  public void setRoot(Node newRoot){root = newRoot;}
  public boolean isEmpty(){return root == null;}
  // 전위순회
  public void preorder(Node n){
    if (n != null){
      System.out.print(n.getKey()+" "); // 노드 n 방문
      preorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
      preorder(n.getRight()); // n의 오른쪽 서브트리를 순회하기 위해
    }
  }
  // 중위순회
  public void inorder(Node n){
    if (n != null){
      inorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
      System.out.print(n.getKey()+" "); // 노드 n 방문
      inorder(n.getRight()); // n의 오른쪽 서브트리를 순회하기 위해
    }
  }
  // 후위순회
  public void postorder(Node n){
    if (n != null){
      postorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
      postorder(n.getRight()); // n의 오른쪽 서브트리를 순회하기 위해
      System.out.print(n.getKey()+" "); // 노드 n 방문
    }
  }
  // 레벨순회
  public void levelorder(Node root){
    Queue<Node> q = new LinkedList<Node>(); // 큐 자료구조 이용
    Node t;
    q.add(root); // 루트노드 큐에 삽입
    while (!q.isEmpty()){
      t = q.remove(); // 큐에서 가장 앞에 있는 노드 제거
      System.out.print(t.getKey()+" "); // 제거된 노드 출력(방문)
      if (t.getLeft() != null) // 제거된 왼쪽 자식이 null이 아니면
        q.add(t.getLeft()); // 큐에 왼쪽 자식 삽입
      if (t.getRight() != null) // 제거된 오른쪽 자식이 null이 아니면
        q.add(t.getRight()); // 큐에 오른쪽 자식 삽입
    }
  }
  // n을 루트로하는 (서브)트리에 있는 노드 수
  public int size(Node n){
    if (n == null) 
      return 0; // null이면 0 리턴
    else 
      return (1 + size(n.getLeft()) + size(n.getRight()));
  }
  // n을 루트로하는 (서브)트리의 높이
  public int height(Node n){
    if (n == null)
      return 0; // null이면 0 리턴
    else
      return (1 + Math.max(height(n.getLeft()), height(n.getRight())));  
  }
  // 두 트리의 동일성 검사
  public static boolean isEqual(Node n, Node m){
    if (n == null || m == null) // 둘 중 하나라도 null이면
      return n == m; // 둘 다 null이면 true, 아니면 false

    if (n.getKey().compareTo(m.getKey()) != 0) // 둘 다 null이 아니면 item 비교
      return false;

    // item이 같으면 왼쪽/오른쪽 자식으로 재귀호출
    return (isEqual(n.getLeft(), m.getLeft()) && isEqual(n.getRight(), m.getRight()));
  }
  // 전위, 중위, 후위, 레벨순회 결과 보기
  public void showOrder(){
    preorder(root); System.out.println();
    inorder(root); System.out.println();
    postorder(root); System.out.println();
    levelorder(root); System.out.println();
  }
}
