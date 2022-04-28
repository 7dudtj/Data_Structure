/*
허프만 코드 (Huffman Code)

허프만 트리 생성 : O(NlogN)
*/

public class Main {
  public static void main(String[] args) {
    //System.out.println("Hello World!");

    Entry[] a = new Entry[100];
    a[1] = new Entry(60, "a", null, null, "");
    a[2] = new Entry(20, "b", null, null, "");
    a[3] = new Entry(30, "c", null, null, "");
    a[4] = new Entry(35, "d", null, null, "");
    a[5] = new Entry(40, "e", null, null, "");
    a[6] = new Entry(90, "f", null, null, "");

    Huffman hm = new Huffman(a, 6);
    hm.showHeap();
    hm.createHeap();
    hm.showHeap();
    Entry huff = hm.createTree();
    hm.setHuff(huff);
  }  
}

class Entry{
  private int frequency; // 빈도 수
  private String word; // 이파리 노드의 문자 또는 내부노드의 합성된 문자열
  private Entry left; // 왼쪽 자식
  private Entry right; // 오른쪽 자식
  private String code; // 허프만 코드
  public Entry(int newFreq, String newValue, Entry l, Entry r, String s){
    frequency = newFreq;
    word = newValue;
    left = l;
    right = r;
    code = s;
  }
  public int getKey(){return frequency;}
  public String getValue(){return word;}
  public String getCode(){return code;}
  public Entry getLeft(){return left;}
  public Entry getRight(){return right;}
  public void setCode(String newCode){code = newCode;}
}

class Huffman{
  private Entry[] a; // a[0]은 사용 안함
  private int N; // 힙의 크기
  // 생성자
  public Huffman(Entry[] harray, int initialSize){
    a = harray;
    N = initialSize;
  }
  private boolean greater(int i, int j){
    return a[i].getKey() > a[j].getKey();
  }
  public int size(){return N;} // 힙의 크기 리턴
  // a[i]와 a[j]를 교환
  private void swap(int i, int j){
    Entry temp = a[i]; a[i] = a[j]; a[j] = temp;
  }
  // 초기 힙 만들기
  public void createHeap(){
    for (int i = N/2; i > 0; i--){
      downheap(i);
    }
  }
  // 새로운 항목 삽입
  public void insert(int freq, String wo){
    Entry temp = new Entry(freq, wo, null, null, ""); // Entry 생성
    a[++N] = temp; // 새로운 키(항목)를 배열 마지막 항목 다음에 저장
    upheap(N); // 위로 올라가며 힙속성 회복시키기 위해
  }
  // 최솟값 삭제
  public Entry deleteMin(){
    Entry min = a[1]; // a[1]의 최솟값을 min으로 지정하여 리턴
    swap(1, N--); // 힙의 마지막 항목과 교환하고 힙 크기 1 감소
    a[N+1] = null; // 마지막 항목을 null로 처리
    downheap(1); // 힙속성을 회복시키기 위해
    return min;
  }
  private void downheap(int i){ // i는 현재 노드의 인덱스
    while (2*i <= N){ // i의 왼쪽 자식노드가 힙에 있으면
      int k = 2*i; // k는 왼쪽 자식노드의 인덱스
      if (k < N && greater(k, k+1)) k++; // k가 승자의 인덱스가됨
      if (!greater(i,k)) break; // 현재 노드가 자식 승자와 같거나 작으면 루프를 중단하고
      swap(i, k); // 현재 노드가 자식 승자보다 크면 현재 노드와 자식 승자와 교환
      i = k; // 자식 승자가 현재 노드가 되어 다시 반복하기 위해
    }
  }
  private void upheap(int j){ // j는 현재 노드의 인덱스
    while (j > 1 && greater(j/2, j)){ // 현재 노드가 루트가 아니고 동시에 부모가 크면
      swap(j/2, j); // 부모와 현재 노드 교환
      j = j/2; // 부모가 현재 노드가 되어 다시 반복하기 위해
    }    
  }
  public Entry createTree(){
    while (size() > 1){ // 힙에 1개의 노드만 남을 때까지
      Entry e1 = deleteMin(); // 힙에서 최소 빈도수 가진 노드 제거하여 e1이 참조
      Entry e2 = deleteMin(); // 힙에서 최소 빈도수 가진 노드 제거하여 e2가 참조
      Entry temp = new Entry(e1.getKey()+e2.getKey(), // e1과 e2의 빈도수를 합산
      e1.getValue()+e2.getValue(), // string 이어붙이기
      e1, e2, ""); // e1, e2가 각각 새노드의 왼쪽, 오른쪽 자식
      // insert(temp)
      a[++N] = temp;
      upheap(N);
    }
    return deleteMin(); // 1개 남은 노드(루트 노드)를 힙에서 제거하며 리턴
  }
  // 허프만 코드 생성
  public void setHuff(Entry huff){
    if (huff.getLeft() != null) {
      huff.getLeft().setCode(huff.getCode()+"0");
      setHuff(huff.getLeft());
    }  
    if (huff.getRight() != null) {
      huff.getRight().setCode(huff.getCode()+"1");
      setHuff(huff.getRight());
    } 
    if (huff.getLeft() == null){
      System.out.print(huff.getValue()+" : "+huff.getCode()+"   ");
    }
  }
  // 힙 내용 보기
  public void showHeap(){
    for (int i = 1; i <= N; i++){
      System.out.print(i+" >> key : "+a[i].getKey()+", data : "+a[i].getValue());
      System.out.println();
    }
    System.out.println("-----------------------------------");
  }
}

