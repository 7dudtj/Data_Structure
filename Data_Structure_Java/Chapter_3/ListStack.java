/*
스택

push : O(1)
pop : O(1)
배열 크기 확대/축소 : O(N), 평균 O(1)
*/

import java.util.EmptyStackException;

class Main {
  public static void main(String[] args) {
    ListStack<String> ls = new ListStack<String>();
    ls.push("orange");
    ls.showStack();
    ls.push("apple");
    ls.showStack();
    ls.push("grape");
    ls.showStack();
    System.out.println("peek : " + ls.peek());
    ls.pop();
    ls.showStack();
    System.out.println("top : " + ls.pop());
    ls.showStack();
    ls.pop();
    ls.showStack();
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

class ListStack<E>{
  private Node<E> top; // 스택 top 항목을 가진 Node를 가리키기 위해
  private int size; // 스택의 항목 수
  // 스택 생성자
  public ListStack(){
    top = null;
    size = 0;
  }
  // 스택의 항목의 수를 리턴
  public int size(){return size;}
  // 스택이 empty이면 true 리턴
  public boolean isEmpty(){return size == 0;}
  // 스택 top 항목만을 리턴
  public E peek(){
    if (isEmpty()) throw new EmptyStackException(); // underflow 시 프로그램 정지
    return top.getItem();
  }
  // 스택 push 연산
  public void push(E newItem){
    Node newNode = new Node(newItem, top); // 리스트 앞부분에 삽입
    top = newNode; // top이 새 노드 가리킴
    size++; // 스택 항목 수 1 증가
  }
  // 스택 pop 연산
  public E pop(){
    if (isEmpty()) throw new EmptyStackException(); // underflow 시 프로그램 정지
    E topItem = top.getItem(); // 스택 top 항목을 topItem에 저장
    top = top.getNext(); // top이 top 바로 아래 항목을 가리킴
    size--;
    return topItem;
  }
  // 스택 내용 확인
  public void showStack(){
    int count = 0;
    System.out.print("top -> ");
    for (Node n = top; count < size; n = n.getNext()){
      count++;
      System.out.print(n.getItem() + " ");
    }
    System.out.println();  
  }
}
