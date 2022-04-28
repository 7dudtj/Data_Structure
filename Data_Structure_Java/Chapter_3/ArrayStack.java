/*
스택

push : O(1)
pop : O(1)
배열 크기 확대/축소 : O(N), 평균 O(1)
*/

import java.util.EmptyStackException;

class Main {
  public static void main(String[] args) {
    ArrayStack<String> stack = new ArrayStack<String>();
    stack.push("apple");
    stack.showStack();
    stack.push("orange");
    stack.showStack();
    stack.push("grape");
    stack.showStack();
    stack.pop();
    stack.showStack();
    System.out.println(stack.pop());
    stack.showStack();
  }
}

class ArrayStack<E>{
  private E s[]; // 스택을 위한 배열
  private int top; // 스택의 top 항목의 배열 원소 인덱스
  // 스택 생성자
  public ArrayStack(){
    s = (E[]) new Object[1]; // 초기에 크기가 1인 배열 생성
    top = -1;
  }
  // 스택에 있는 항목의 수를 리턴
  public int size(){return top + 1;}
  // 스택이 empty이면 true 리턴
  public boolean isEmpty() {return (top == -1);}
  // 스택 top 항목의 내용만을 리턴
  public E peek(){
    if (isEmpty()) throw new EmptyStackException(); // underflow 시 프로그램 정지
    return s[top];
  }
  // push 연산
  public void push(E newItem){
    if (size() == s.length)
      resize(2 * s.length); // 스택을 2배의 크기로 확장
    s[++top] = newItem; // 새 항목을 push
  }
  // pop 연산
  public E pop(){
    if (isEmpty()) throw new EmptyStackException(); // underflow 시 프로그램 정지
    E item = s[top];
    s[top--] = null; // null로 초기화
    if (size() > 0 && size() == s.length/4)
      resize(s.length/2); // 스택을 1/2 크기로 축소
    return item;  
  }

  // 배열 크기 조절
  private void resize(int newSize){
    Object[] t = new Object[newSize]; // newSize 크기의 새로운 배열 t 생성
    for (int i = 0; i < top + 1; i++)
      t[i] = s[i]; // 배열 s를 배열 t로 복사
    s = (E[]) t; // 배열 t를 배열 s로  
  }
  // 스택 내용 확인
  public void showStack(){
    for (int i = 0; i < s.length; i++)
      System.out.print(s[i] + " ");
    System.out.println();  
  }
}
