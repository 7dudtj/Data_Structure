/*
큐

add : O(1) 
remove : O(1)
배열 크기 확대/축소 : O(N), 평균 O(1)
*/

import java.util.NoSuchElementException;

public class Main {
  public static void main(String[] args) {
    ListQueue lq = new ListQueue();
    lq.showQueue();
    lq.add("seoul");
    lq.showQueue();
    lq.add("beijing");
    lq.showQueue();
    lq.add("taibei");
    lq.showQueue();
    lq.remove();
    lq.showQueue();
    System.out.println(lq.remove());
    lq.showQueue();
    lq.remove();
    lq.showQueue();
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

class ListQueue<E>{
  private Node<E> front, rear;
  private int size;
  // 생성자
  public ListQueue(){
    front = rear = null;
    size = 0;
  }
  // 큐의 항목의 수를 리턴
  public int size(){return size;}
  // 큐가 empty이면 true 리턴
  public boolean isEmpty(){return size() == 0;}
  // 큐 삽입 연산
  public void add(E newItem){
    Node newNode = new Node(newItem, null); // 새 노드 생성
    if (isEmpty()) front = newNode; // 큐가 empty이었으면 front도 newNode를 가리키게 한다
    else rear.setNext(newNode); // 그렇지않으면 rear의 next를 newNode를 가리키게 한다
    rear = newNode; // 마지막으로 rear가 newNode를 가리키게 한다
    size++; // 큐 항목 수 1 증가
  }
  // 큐 삭제 연산
  public E remove(){
    if (isEmpty()) throw new NoSuchElementException(); // underflow 경우에 프로그램 정지
    E frontItem = front.getItem(); // front가 가리키는 노드의 항목을 frontItem에 저장
    front = front.getNext(); // front가 front 다음 노드를 가리키게 한다.
    if (isEmpty()) rear = null; // 큐가 empty이면 rear = null
    size--; // 큐 항목 수 1 감소
    return frontItem;
  }
  // 큐의 내용 확인
  public void showQueue(){
    for (Node i = front; i != null; i = i.getNext()){
      System.out.print(i.getItem() + " ");
    }
    System.out.println();
  }
}
