/*
원형연결리스트

탐색 : O(N)
삽입 : O(1)
삭제 : O(1)
*/

import java.util.NoSuchElementException;

public class Main {
  public static void main(String[] args) {
    CList cl = new CList();
    cl.insert("apple");
    cl.showList();
    cl.insert("orange");
    cl.showList();
    cl.insert("mango");
    cl.showList();
    cl.delete();
    cl.showList();
    cl.delete();
    cl.showList();
    cl.delete();
    cl.showList();
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

class CList<E>{
  private Node last; // 리스트의 마지막 노드(항목)을 가리킨다
  private int size; // 리스트의 항목(노드) 수
  // 리스트 생성자
  public CList(){
    last = null;
    size = 0;
  }
  // last가 가리키는 노드의 다음에 새노드 삽입
  public void insert(E newItem){
    Node newNode = new Node(newItem, null); // 새 노드 생성
    if (last == null) { // 리스트가 empty일때
      newNode.setNext(newNode);
      last = newNode;
    }
    else{
      newNode.setNext(last.getNext()); // newNode의 다음 노드가 last가 가리키는 노드의 다음 노드가 되도록
      last.setNext(newNode); // last가 가리키는 노드의 다음 노드가 newNode가 되도록
    }
    size++;
  }
  // last가 가리키는 노드의 다음 노드를 제거
  public Node delete(){
    if (isEmpty()) throw new NoSuchElementException();
    Node x = last.getNext(); // x가 리스트의 첫 노드를 가리킴
    if (x == last) last = null; // 리스트에 1개의 노드만 있는 경우
    else{
      last.setNext(x.getNext()); // last가 가리키는 노드의 다음 노드가 x의 다음 노드가 되도록
      x.setNext(null); // x의 next를 null로 만든다
    }
    size--;
    return x;
  }
  // 리스트가 비었는지 확인
  public boolean isEmpty(){
    return (size == 0);
  }
  // 리스트 내용 확인
  public void showList(){
    int count = 0;
    for (Node i = last; count < size; i = i.getNext()){
      count++;
      System.out.print(i.getItem() + " ");
    }
    System.out.println();
  }
}
