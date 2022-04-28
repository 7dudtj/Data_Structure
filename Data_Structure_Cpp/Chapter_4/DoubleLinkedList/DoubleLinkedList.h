#include "Node2.h"

class DoubleLinkedList{
    Node2 org; // 헤드 노드
public:
    DoubleLinkedList() : org(0) {} // 생성자
    ~DoubleLinkedList() {clear();}
    void clear() {while (!isEmpty()) delete remove(0);}
    Node2* getHead() {return org.getNext();}
    bool isEmpty() {return getHead()==NULL;}

    // pos번째 노드 반환
    Node2* getEntry(int pos){
        Node2* n = &org;
        for (int i = -1; i < pos; i++, n=n->getNext())
            if (n == NULL) break;
        return n;
    }

    // pos 위치에 노드 삽입
    void insert(int pos, Node2* n){
        Node2* prev = getEntry(pos-1);
        if (prev != NULL)
            prev->insertNext(n);
    }

    // pos 위치의 노드 삭제
    Node2* remove(int pos){
        Node2* n = getEntry(pos);
        return n->remove();
    }

    // 값이 val인 노드 탐색
    Node2* find(int val){
        for (Node2* p = getHead(); p != NULL; p = p->getNext())
            if (p->hasData(val)) return p;
        return NULL;
    }

    // pos 위치의 노드 교체
    void replace(int pos, Node2* n){
        Node2* prev = getEntry(pos-1);
        if (prev != NULL){
            delete prev->getNext()->remove();
            prev->insertNext(n);
        }
    }

    // 리스트의 전체 노드수 반환
    int size(){
        int count = 0;
        for (Node2* p = getHead(); p != NULL; p = p->getNext())
            count++;
        return count;
    }

    // 리스트를 화면에 보기 좋게 출력
    void display(){
        printf("[number of contents = %2d] : ", size());
        for (Node2* p = getHead(); p != NULL; p = p->getNext())
            p->display();
        printf("\n");
    }
};