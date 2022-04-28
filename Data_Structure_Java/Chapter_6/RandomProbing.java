/*
개방주소방식 - 랜덤조사
Open Addressing - Random Probing
*/

import java.util.Random;

public class Main {
  public static void main(String[] args) {
    RandProbing rp = new RandProbing();
    rp.put(2001, "ys");
    rp.put(1909, "bj");
    rp.put(1912, "jj");
    rp.put(1910, "th");
    rp.put(2004, "y");
    rp.put(2004, "yj");
    rp.put(1923, "nan");
    System.out.println("find 1923 -> " + rp.get(1923));
    rp.showTable();
  }
}

class RandProbing<K, V>{
  private int N = 0, M = 13; // 테이블 크기
  private K[] a = (K[]) new Object[M]; // 해시테이블
  private V[] d = (V[]) new Object[M]; // key관련 데이터 저장
  // 해시코드
  private int hash(K Key){
    return (Key.hashCode() & 0x7fffffff) % M; // 나눗셈 함수
  }
  // 삽입 연산
  public void put(K key, V data){
    int initialpos = hash(key); // 초기 위치
    int i = initialpos;
    Random rand = new Random();
    rand.setSeed(10);
    do{
      if (a[i] == null){ // 삽입 위치 발견
        a[i] = key; // key를 해시테이블에 저장
        d[i] = data; N++; // key관련 데이터 저장, 항목 수 1증가
        return;
      }
      if (a[i].equals(key)){ // 이미 key 존재
        d[i] = data; // 데이터만 갱신
        return;
      }
      i = (initialpos + rand.nextInt(1000)) % M; // i = 다음 위치
    } while(N < M);
  }
  // 탐색 연산
  public V get(K key){
    Random rand = new Random();
    rand.setSeed(10); // 삽입 때와 같은 seed값 사용
    int initialpos = hash(key); // 초기 위치
    int i = initialpos;
    while (a[i] != null){
      if (a[i].equals(key))
        return d[i]; // 탐색 성공
      i = (initialpos + rand.nextInt(1000)) % M; // i = 다음 위치  
    }
    return null; // 탐색 실패
  }
  // 해시 테이블 보기
  public void showTable(){
    for (int i = 0; i < M; i++){
      System.out.println(i + " -> Key : " + a[i] + ", Data : " + d[i]);
    }
  }
}
