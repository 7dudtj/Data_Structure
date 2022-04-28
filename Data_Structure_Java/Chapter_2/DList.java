/*
이중연결리스트

탐색 : O(N)
삽입 : O(1)
삭제 : O(1)
*/

import java.util.NoSuchElementException;

public class Main {
  public static void main(String[] args) {
    DList dl = new DList();
    dl.insertAfter(dl.head, "apple");
    dl.showList();
    dl.insertBefore(dl.tail, "orange");
    dl.showList();
    dl.insertAfter(dl.head, "mango");
    dl.showList();
    dl.delete(dl.head.getNext().getNext());
    dl.showList();
  }
}

class DNode <E>{
  private E item;
  private DNode previous;
  private DNode next;
  // 노드 생성자
  public DNode(E newItem, DNode p, DNode q){
    item = newItem;
    previous = p;
    next = q;
  }
  // get 메소드와 set 메소드
  public E getItem(){return item;}
  public DNode getPrevious(){return previous;}
  public DNode getNext(){return next;}
  public void setItem(E newItem){item = newItem;}
  public void setPrevious(DNode p){previous = p;}
  public void setNext(DNode q){next = q;}
}

class DList<E>{
  protected DNode head, tail;
  protected int size;
  // 생성자
  public DList(){
    head = new DNode(null, null, null);
    tail = new DNode(null, head, null); // tail의 이전 노드를 head로 만든다
    head.setNext(tail); // head의 다음 노드를 tail로 만든다
    size = 0;
  }
  // p가 가리키는 노드 앞에 삽입
  public void insertBefore(DNode p, E newItem){
    DNode t = p.getPrevious();
    DNode newNode = new DNode(newItem, t, p);
    p.setPrevious(newNode);
    t.setNext(newNode);
    size++;
  }
  // p가 가리키는 노드 뒤에 삽입
  public void insertAfter(DNode p, E newItem){
    DNode t = p.getNext();
    DNode newNode = new DNode(newItem, p, t);
    t.setPrevious(newNode);
    p.setNext(newNode);
    size++;
  }
  // x가 가리키는 노드 삭제
  public void delete(DNode x){
    if (x == null) throw new NoSuchElementException();
    DNode f = x.getPrevious();
    DNode r = x.getNext();
    f.setNext(r);
    r.setPrevious(f);
    size--;
  }
  // 리스트 내용 확인
  public void showList(){
    for (DNode i = head.getNext(); i != tail; i = i.getNext()){
      System.out.print(i.getItem() + " ");
    }
    System.out.println();
  }
}
