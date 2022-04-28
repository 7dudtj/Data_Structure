/*
퀵정렬 (Quick Sort)

수행시간
최선경우 : O(NlogN)
평균경우 : O(NlogN)
최악경우 : O(N^2)
*/

import java.lang.Comparable;

public class Main {
  public static void main(String[] args) {
    // System.out.println("Hello Wolrd!");

    Quick qk = new Quick();
    Comparable[] list = new Comparable[8];
    list[0] = 50; list[1] = 80; list[2] = 20;
    list[3] = 90; list[4] = 40; list[5] = 10;
    list[6] = 30; list[7] = 60; 
    qk.sort(list);
    for (int i = 0; i < 8; i++) System.out.print(list[i]+" ");
  }  
}

class Quick{
  public void sort(Comparable[] a){
    sort(a, 0, a.length-1);
  }
  private void sort(Comparable[] a, int low, int high){
    if (high <= low) return;
    int j = partition(a, low, high);
    sort(a, low, j-1); // 피벗보다 작은 부분을 재귀호출
    sort(a, j+1, high); // 피벗보다 큰 부분을 재귀호출
  }
  private int partition(Comparable[] a, int pivot, int high){
    int i = pivot + 1;
    int j = high;
    Comparable p = a[pivot];
    while (true){
      while (i <= high && !isless(p, a[i])) i++; // 피벗과 같거나 작으면 i++
      while (j >= pivot && isless(p, a[j])) j--; // 피벗보다 크면 j--
      if (i >= j) break; // i와 j가 교차되면 루프 나가기
      swap(a, i, j);
    }
    swap(a, pivot, j); // 피벗과 a[j] 교환
    return j; // a[j]의 피벗이 "영원히" 자리 잡은 곳"
  }
  private boolean isless(Comparable u, Comparable v){
    return (u.compareTo(v) < 0);
  }
  private void swap(Comparable[] a, int i, int j){
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
