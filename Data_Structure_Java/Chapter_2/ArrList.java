/*
배열로 구현한 리스트

탐색 : O(1)
삽입 : 최악 O(N), 평균 O(1)
삭제 : 최악 O(N), 평균 O(1)
*/

import java.util.NoSuchElementException;

public class Main {
  public static void main(String[] args) {
    ArrList al = new ArrList();
    al.insertLast("apple");
    al.showList();
    al.insertLast("orange");
    al.showList();
    al.insert("mango", 1);
    System.out.println(al.peek(0));
    al.showList();
    al.delete(1);
    al.showList();
    al.delete(0);
    al.showList();
  }
}

class ArrList <E> {
  private E a[]; // 리스트의 항목들을 저장할 배열
  private int size; // 리스트의 항목 수
  // 생성자
  public ArrList(){
    a = (E[]) new Object[1]; // 최초로 1개의 원소를 가진 배열 생성
    size = 0; // 항목 수를 0으로 초기화
  }
  // k번째 항목을 리턴, 단순히 읽기만 한다.
  public E peek(int k){
    if (size == 0) throw new NoSuchElementException(); // underflow 경우에 프로그램 정지
    return a[k];
  }
  // 가장 뒤에 새 항목 삽입
  public void insertLast(E newItem){
    if (size == a.length) // 배열에 빈 공간이 없으면
      resize(2 * a.length); // 배열 크기 2배로 확장
    a[size++] = newItem;  
  }
  // 새 항목을 k-1번째 항목 다음에 삽입
  public void insert(E newItem, int k){
    if (size == a.length) // 배열에 빈 공간이 없으면
      resize(2 * a.length); // 배열 크기 2배로 확장
    for (int i = size - 1; i >= k; i--) a[i+1] = a[i]; // 한 칸씩 뒤로 이동
    a[k] = newItem;
    size++;  
  }
  // 배열 크기 조정
  private void resize(int newSize){
    Object[] t = new Object[newSize]; // newSize 크기의 새로운 배열 t 생성
    for (int i = 0; i < size; i++) t[i] = a[i]; // 배열 a를 배열 t로 복사
    a = (E[]) t; // 배열 t를 배열 a로
  }
  // k번째 항목 삭제
  public E delete(int k){
    if (isEmpty()) throw new NoSuchElementException(); // underflow 경우에 프로그램 정지
    E item = a[k];
    for (int i = k; i < size; i++) a[i] = a[i+1]; // 한 칸씩 앞으로 이동
    size--;
    if (size > 0 && size == a.length/4) // 배열에 항목들이 1/4만 차지한다면
      resize(a.length / 2); // 배열을 1/2 크기로 축소
    return item;  
  }
  // 배열이 비었는지 확인
  public boolean isEmpty(){
    return (size == 0);
  }
  // 리스트 내용 확인
  public void showList(){
    for (int i = 0; i < a.length; i++)
      System.out.print(a[i] + " ");
    System.out.println();  
  }
}
