/*
선택정렬 (Selection Sort)

수행시간 : O(N^2)
*/

import java.lang.Comparable;

public class Main {
  public static void main(String[] args) {
    Selection ss = new Selection();
    Comparable[] list = new Comparable[6];
    list[0] = 40; list[1] = 70; list[2] = 60;
    list[3] = 30; list[4] = 10; list[5] = 50;
    ss.sort(list);
    for (int i = 0; i < 6; i++) System.out.print(list[i]+" ");
  }  
}

class Selection{
  public void sort(Comparable[] a){
    int N = a.length;
    for (int i = 0; i < N; i++){
      int min = i;
      // min 찾기
      for (int j = i+1; j < N; j++){
        if (isless(a[j], a[min])) min = j;
      }
      swap(a, i, min); // min과 a[i]의 교환
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
