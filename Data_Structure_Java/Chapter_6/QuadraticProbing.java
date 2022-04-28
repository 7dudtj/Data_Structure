/*
개방주소방식 - 이차조사
Open Addressing - Quadratic Probing
*/

public class Main {
  public static void main(String[] args) {
    QuadProbing qp = new QuadProbing();
    qp.put(2001, "ys");
    qp.put(1909, "bj");
    qp.put(1912, "jj");
    qp.put(1910, "th");
    qp.put(2004, "y");
    qp.put(2004, "yj");
    qp.put(1923, "nan");
    System.out.println("find 1923 -> " + qp.get(1923));
    qp.showTable();
  }
}

class QuadProbing<K, V>{
  private int N = 0, M = 13;
  private K[] a = (K[]) new Object[M]; // 해시테이블
  private V[] d = (V[]) new Object[M]; // key관련 데이터 저장
  // 해시코드
  private int hash(K Key){
    return (Key.hashCode() & 0x7fffffff) % M; // 나눗셈 함수
  }
  // 삽입 연산
  public void put(K key, V data){
    int initialpos = hash(key); // 초기 위치
    int i = initialpos, j = 1;
    do{
      if (a[i] == null){ // 삽입 위치 발견
        a[i] = key; // key를 해시테이블에 저장
        d[i] = data; N++; // key관련 데이터 저장, 항목 수 1증가
        return;
      }
      if (a[i].equals(key)){ // 이미 key 존재
        d[i] = data; // data만 갱신
        return;
      }
      i = (initialpos + j * j++) % M; // i = 다음 위치
    } while(N < M);
  }
  // 탐색 연산
  public V get(K key){
    int initialpos = hash(key);
    int i = initialpos, j = 1;
    while (a[i] != null){ // a[i]가 empty가 아니면
      if (a[i].equals(key))
        return d[i]; // 탐색 성공
      i = (initialpos + j * j++) % M; // i = 다음 위치  
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
