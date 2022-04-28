/*
힙정렬 (Heap Sort)

수행시간 : O(NlogN)
*/

import java.lang.Comparable;

public class Main {
  public static void main(String[] args) {
    // System.out.println("Hello Wolrd!");

    Heap hs = new Heap();
    Comparable[] list = new Comparable[10];
    list[0] = null;
    list[1] = 80; list[2] = 60; list[3] = 70;
    list[4] = 50; list[5] = 30; list[6] = 40;
    list[7] = 10; list[8] = 20; list[9] = 90;
    hs.sort(list);
    for (int i = 1; i < 10; i++) System.out.print(list[i]+" ");
  }  
}

class Heap{
  public void sort(Comparable[] a){
    int heapSize = a.length - 1; // a[0]은 사용 안함
    for (int i = heapSize/2; i > 0; i--) // 힙 만들기
      downheap(a, i, heapSize);
    while(heapSize > 1){ // 힙정렬
      swap(a, 1, heapSize--); // a[1]과 힙의 마지막 원소와 교환
      downheap(a, 1, heapSize); // 위배된 힙속성 고치기
    }  
  }
  private void downheap(Comparable[] a, int p, int heapSize){
    while (2*p <= heapSize){
      int s = 2*p; // s=왼쪽 자식의 인덱스
      if (s < heapSize && isless(a[s], a[s+1])) s++; // 오른쪽 자식이 큰 경우
      if (!isless(a[p], a[s])) break; // 힙속성 만족하는 경우
      swap(a, p, s); // 힙속성 만족 안하면 부모(p)와 자식 승자(s) 교환
      p = s; // 이제 자식 승자의 자리에 부모가 있게됨
    }
  }
  // 키 비교
  private boolean isless(Comparable i, Comparable j){
    return (i.compareTo(j) < 0);
  }
  // 원소 교환
  private void swap(Comparable[] a, int i, int j){
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
