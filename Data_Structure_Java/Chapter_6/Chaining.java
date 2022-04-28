/*
폐쇄주소방식 - 체이닝
Closed Addressing - Chaining
*/

public class Main {
  public static void main(String[] args) {
    Chaining ch = new Chaining();
    ch.put(25, "apple");
    ch.put(37, "banana");
    ch.put(18, "carrot");
    ch.put(55, "dango");
    ch.put(22, "eqe");
    ch.put(35, "fruit");
    ch.put(50, "grape");
    ch.put(63, "h");
    ch.showTable();
  }  
}

// 노드 클래스
class Node{
  public Object key;
  public Object data;
  public Node next;
  // 생성자
  public Node(Object newkey, Object newdata, Node ref){
    key = newkey;
    data = newdata;
    next = ref;
  }
  public Object getKey(){return key;}
  public Object getData(){return data;}
}

class Chaining<K, V>{
  public int M = 13; // 테이블 크기
  public Node[] a = new Node[M]; // 해시 테이블
  
  // 해시코드
  private int hash(K key){
    return (key.hashCode() & 0x7fffffff) % M; // 나눗셈 연산
  }
  // 탐색 연산
  public V get(K key){
    int i = hash(key);
    for (Node x = a[i]; x != null; x = x.next) // 연결리스트 탐색
      if (key.equals(x.key)) return (V) x.data; // 탐색 성공
    return null; // 탐색 실패  
  }
  // 삽입 연산
  public void put(K key, V data){
    int i = hash(key);
    for (Node x = a[i]; x != null; x = x.next){
      if (key.equals(x.key)){ // 이미 key 존재
        x.data = data; // 데이터만 갱신
        return;
      }
    }
    a[i] = new Node(key, data, a[i]); // 연결리스트의 첫 노드로 삽입
  }
  // 해시 테이블 보기
  public void showTable(){
    for (int i = 0; i < M; i++){
      System.out.print(i);
      for (Node m = a[i]; m != null; m = m.next){
        System.out.print("-->["+m.key+", "+m.data+"]");
      }
      System.out.println();
    }
  }
}
