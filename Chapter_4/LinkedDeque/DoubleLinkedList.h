#include "Node2.h"

class DoubleLinkedList{
    Node2 org; // ��� ���
public:
    DoubleLinkedList() : org(0) {} // ������
    ~DoubleLinkedList() {clear();}
    void clear() {while (!isEmpty()) delete remove(0);}
    Node2* getHead() {return org.getNext();}
    bool isEmpty() {return getHead()==NULL;}

    // pos��° ��� ��ȯ
    Node2* getEntry(int pos){
        Node2* n = &org;
        for (int i = -1; i < pos; i++, n=n->getNext())
            if (n == NULL) break;
        return n;
    }

    // pos ��ġ�� ��� ����
    void insert(int pos, Node2* n){
        Node2* prev = getEntry(pos-1);
        if (prev != NULL)
            prev->insertNext(n);
    }

    // pos ��ġ�� ��� ����
    Node2* remove(int pos){
        Node2* n = getEntry(pos);
        return n->remove();
    }

    // ���� val�� ��� Ž��
    Node2* find(int val){
        for (Node2* p = getHead(); p != NULL; p = p->getNext())
            if (p->hasData(val)) return p;
        return NULL;
    }

    // pos ��ġ�� ��� ��ü
    void replace(int pos, Node2* n){
        Node2* prev = getEntry(pos-1);
        if (prev != NULL){
            delete prev->getNext()->remove();
            prev->insertNext(n);
        }
    }

    // ����Ʈ�� ��ü ���� ��ȯ
    int size(){
        int count = 0;
        for (Node2* p = getHead(); p != NULL; p = p->getNext())
            count++;
        return count;
    }

    // ����Ʈ�� ȭ�鿡 ���� ���� ���
    void display(){
        printf("[number of contents = %2d] : ", size());
        for (Node2* p = getHead(); p != NULL; p = p->getNext())
            p->display();
        printf("\n");
    }
};