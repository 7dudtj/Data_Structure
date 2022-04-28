/*
단순연결리스트

탐색 : O(N)
삽입 : 노드 ref 있으면 O(1), 없으면 O(N)
삭제 : 노드 ref 있으면 O(1), 없으면 O(N)
*/

import java.util.NoSuchElementException;

public class Main {
  public static void main(String[] args) {
    SList sl = new SList();
    sl.insertFront("apple");
    sl.showList();
    sl.insertFront("pineapple");
    sl.showList();
    sl.insertAfter("orange", sl.head);
    sl.showList();
    System.out.println(sl.search("apple"));
    sl.deleteAfter(sl.head);
    sl.showList();
    sl.deleteFront();
    sl.showList();
  }
}

class Node <E>{
  private E item;
  private Node<E> next;
  // 생성자
  public Node(E newItem, Node<E> node){
    item = newItem;
    next = node;
  }
  // get과 set 메소드
  public E getItem() {return item;}
  public Node<E> getNext() {return next;}
  public void setItem(E newItem) {item = newItem;}
  public void setNext(Node<E> newNext) {next = newNext;}
}

class SList<E>{
  protected Node head; // 연결 리스트의 첫 노드 가리킴
  private int size;
  // 연결 리스트 생성자
  public SList(){
    head = null;
    size = 0;
  }
  // target을 탐색
  public int search(E target){
    Node p = head;
    for (int k = 0; k < size; k++){
      if (target == p.getItem()) return k;
      p = p.getNext();
    }
    return -1; // 탐색을 실패한 경우 -1 리턴
  }
  // 연결리스트 맨 앞에 새 노드 삽입
  public void insertFront(E newItem){
    head = new Node(newItem, head);
    size++;
  }
  // 노드 p 바로 다음에 새 노드 삽입
  public void insertAfter(E newItem, Node p){
    p.setNext(new Node(newItem, p.getNext()));
    size++;
  }
  // 리스트의 첫 노드 삭제
  public void deleteFront(){
    if (isEmpty()) throw new NoSuchElementException();
    head = head.getNext();
    size--;
  }
  // p가 가리키는 노드의 다음 노드를 삭제
  public void deleteAfter(Node p){
    if (p == null) throw new NoSuchElementException();
    Node t = p.getNext();
    p.setNext(t.getNext());
    t.setNext(null);
    size--;
  }
  // 배열이 비었는지 확인
  public boolean isEmpty(){
    return (size == 0);
  }
  // 리스트 내용 확인
  public void showList(){
    for (Node n = head; n != null; n = n.getNext()){
      System.out.print(n.getItem() + " ");
    }
    System.out.println();
  }
}
