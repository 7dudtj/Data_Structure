/*
쉘정렬 (Shell Sort)

수행시간 : O(N^1.5)
*/

import java.lang.Comparable;

public class Main {
  public static void main(String[] args) {
    // System.out.println("Hello Wolrd!");

    Shell sh = new Shell();
    Comparable[] list = new Comparable[12];
    list[0] = 65; list[1] = 95; list[2] = 90;
    list[3] = 80; list[4] = 55; list[5] = 70;
    list[6] = 35; list[7] = 50; list[8] = 10;
    list[9] = 25; list[10] = 40; list[11] = 30;
    sh.sort(list);
    for (int i = 0; i < 12; i++) System.out.print(list[i]+" ");
  }  
}

class Shell{
  public void sort(Comparable[] a){
    int N = a.length;
    int h = 4; // 3x+1간격: 1, 4, 13, 40, 121,... 중에서 4와 1만 사용
    while (h >= 1){
      for (int i = h; i < N; i++){ // h-정렬 수행
        for (int j = i; j >= h && isless(a[j], a[j-h]); j -= h){
          swap(a, j, j-h);
        }
      }
      h /= 3;
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
