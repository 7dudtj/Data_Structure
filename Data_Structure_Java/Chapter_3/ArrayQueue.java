/*
큐

add : O(1) 
remove : O(1)
배열 크기 확대/축소 : O(N), 평균 O(1)
*/

import java.util.NoSuchElementException;

public class Main {
  public static void main(String[] args) {
    ArrayQueue aq = new ArrayQueue();
    aq.showQueue();
    aq.add("apple");
    aq.showQueue();
    aq.add("orange");
    aq.showQueue();
    aq.add("grape");
    aq.showQueue();
    aq.add("pineapple");
    aq.showQueue();
    aq.add("mango");
    aq.showQueue();
    aq.remove();
    aq.showQueue();
    System.out.println(aq.remove());
    aq.showQueue();
    aq.remove();
    aq.showQueue();
    aq.remove();
    aq.showQueue();
    aq.remove();
    aq.showQueue();
  }
}

class ArrayQueue<E>{
  private E[] q; // 큐를 위한 배열
  private int front, rear, size;
  // 큐 생성자
  public ArrayQueue(){
    q = (E[]) new Object[2]; // 초기에 크기가 2인 배열 생성
    front = rear = size = 0;
  }
  // 큐에 있는 항목의 수 리턴
  public int size(){return size;}
  // 큐가 empty이면 true를 리턴
  public boolean isEmpty(){return (size == 0);}
  // 큐 삽입 연산
  public void add(E newItem){
    if ((rear+1)%q.length == front) // 비어있는 원소가 1개뿐인 경우(즉, 큐가 full인 경우)
      resize(2 * q.length); // 큐의 크기를 2배로 확장
    rear = (rear+1) % q.length;
    q[rear] = newItem; // 새 항목을 add
    size++;  
  }
  // 큐 삭제 연산
  public E remove(){
    if (isEmpty()) throw new NoSuchElementException(); // underflow 경우에 프로그램 정지
    front = (front+1) % q.length;
    E item = q[front];
    q[front] = null; // null로 만들어 가비지 컬렉션되도록
    size--;
    if (size > 0 && size == q.length/4) // 쿠의 항목수가 배열 크기의 1/4가 되면
      resize(q.length/2); // 큐를 1/2 크기로 축소
    return item;  
  }
  // 큐의 배열 크기 조절
  private void resize(int newSize){
    Object[] t = new Object[newSize]; // newSize 크기의 새로운 배열 t 생성
    for (int i = 1, j = front + 1; i < size + 1; i++, j++){
      t[i] = q[j%q.length]; // 배열 q의 항목들을 t[1]로부터 복사
    }
    front = 0;
    rear = size;
    q = (E[]) t; // 배열 t를 배열 q로
  }
  // 큐의 내용 확인
  public void showQueue(){
    System.out.println("front : " + front + ", rear : " + rear + ", size : " + size());
    for (int i = 0; i < q.length; i++){
      System.out.print(q[i] + " ");
    }
    System.out.println();
  }
}
