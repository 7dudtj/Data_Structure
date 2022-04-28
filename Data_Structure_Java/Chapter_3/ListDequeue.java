/*
덱

add : O(1) 
remove : O(1)
배열 크기 확대/축소 : O(N), 평균 O(1)
*/

import java.util.NoSuchElementException;

public class Main {
  public static void main(String[] args) {
    ListDequeue lq = new ListDequeue();
    lq.showQueue();
    lq.addfront("seoul");
    lq.showQueue();
    lq.addfront("beijing");
    lq.showQueue();
    lq.addback("taibei");
    lq.showQueue();
    lq.removeback();
    lq.showQueue();
    System.out.println(lq.removefront());
    lq.showQueue();
    lq.removeback();
    lq.showQueue();
  }
}

// Node class
class Node <E>{
  public E item;
  public Node<E> next;
  public Node<E> before;
  // 생성자
  public Node(E newItem, Node<E> nnode, Node<E> bnode){
    item = newItem;
    next = nnode;
    before = bnode;
  }
  // get과 set 메소드
  public E getItem() {return item;}
  public Node<E> getNext() {return next;}
  public Node<E> getBefore() {return before;}
  public void setItem(E newItem) {item = newItem;}
  public void setNext(Node<E> newNext) {next = newNext;}
  public void setBefore(Node<E> newBefore) {before = newBefore;}
}

class ListDequeue<E>{
  public Node<E> front, rear;
  public int size;
  // 생성자
  public ListDequeue(){
    front = rear = null;
    size = 0;
  }
  // 큐의 항목의 수를 리턴
  public int size(){return size;}
  // 큐가 empty이면 true 리턴
  public boolean isEmpty(){return size() == 0;}
  // 큐 삽입 연산
  public void addback(E newItem){
    Node newNode = new Node(newItem, null, null);
    if (isEmpty()) {
      front = rear = newNode;
    }  
    else {
      rear.setNext(newNode);
      newNode.setBefore(rear);
      rear = newNode;
    }  
    size++;
  }
  public void addfront(E newItem){
    Node newNode = new Node(newItem, null, null);
    if (isEmpty()) {
      front = rear = newNode;
    }  
    else {
      newNode.setNext(front);
      front.setBefore(newNode);
      front = newNode;
    }  
    size++;
  }
  // 큐 삭제 연산
  public E removefront(){
    if (isEmpty()) throw new NoSuchElementException();
    E frontItem = front.getItem();
    front = front.getNext();
    size--;
    if (isEmpty()) {
      rear = null;
    }else{
      front.getBefore().setNext(null);
      front.setBefore(null);
    }
    return frontItem;
  }
  public E removeback(){
    if (isEmpty()) throw new NoSuchElementException();
    E backItem = rear.getItem();
    rear = rear.getBefore();
    size--;
    if (isEmpty()) {
      front = null;
    }else{
      rear.getNext().setBefore(null);
      rear.setNext(null);
    }
    return backItem;
  }
  // 큐의 내용 확인
  public void showQueue(){
    for (Node i = front; i != null; i = i.getNext()){
      System.out.print(i.getItem() + " ");
    }
    System.out.println();
  }
}
