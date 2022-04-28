/*
LSD 기수정렬 (LSD Sort)

수행시간 : O(d(N + R))
d : 키의 자리 수, R : 기(Radix), N : 입력의 크
*/

public class Main {
  public static void main(String[] args) {
    // System.out.println("Hello Wolrd!");

    LSDsort ls = new LSDsort();
    int[] a = {251,430,301,540,551,401,2,10,124,22,204,115};
    ls.sort(a);
  }  
}

class LSDsort{
  public void sort(int[] a){
    int R = 10;
    int N = a.length;
    int[] t = new int[N];
    for (int k = 10; k <= 1000; k *= 10){
      int[] startIndex = new int[R+1];
      for (int i = 0; i < N; i++) // 빈도수 계산
        startIndex[(a[i]%k)/(k/10) + 1]++; // (a[i]%k)/(k/10)은 a[i]의 각 자릿수를 추출
      for (int r = 0; r < R; r++) // 각 버킷 인덱스 값이 저장될 배열 t의 시작 인덱스 계산
        startIndex[r+1] += startIndex[r];
      for (int i = 0; i < N; i++) // a[i]를 배열 t에 차례로 저장
        t[startIndex[(a[i]%k)/(k/10)]++] = a[i];
      for (int i = 0; i < N; i++) // 배열 t를 배열 a로 복사
        a[i] = t[i];
      System.out.println();
      System.out.println(k/10+"의 자리 정렬 결과:");
      for (int i = 0; i < N; i++){
        System.out.print(String.format("%3d", a[i]) + " ");
      }
      System.out.println();
      for (int i = 0; i < N; i++){
        System.out.print(String.format("%03d", a[i]) + " ");
      }
      System.out.println();          
    }
  }
}
