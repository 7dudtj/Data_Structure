#include "Node.h"

class LinkedList{
    Node org;
public:
    LinkedList() : org(0) {}
    ~LinkedList() {clear();}
    void clear() {while (!isEmpty()) delete remove(0);}
    Node* getHead() {return org.getLink();}
    bool isEmpty() {return getHead() == NULL;}

    // pos��° �׸��� ��ȯ��
    Node* getEntry(int pos){
        Node* n = &org;
        for (int i = -1; i < pos; i++, n = n->getLink())
            if (n == NULL) break;
        return n;
    }

    // ����Ʈ�� � ��ġ�� �׸� ����
    void insert(int pos, Node* n){
        Node* prev = getEntry(pos-1);
        if (prev != NULL)
            prev->insertNext(n);
    }

    // ����Ʈ�� � ��ġ�� �׸� ����
    Node* remove(int pos){
        Node* prev = getEntry(pos-1);
        return prev->removeNext();
    }

    // Ž�� �Լ�
    Node* find(int val){
        for (Node* p = getHead(); p != NULL; p = p->getLink())
            if (p->hasData(val)) return p;
        return NULL;
    }

    // ����Ʈ�� � ��ġ�� �׸� ����
    void replace(int pos, Node* n){
        Node* prev = getEntry(pos-1);
        if (prev != NULL){
            delete prev->removeNext();
            prev->insertNext(n);
        }
    }

    // ����Ʈ �׸� ������ ��ȯ
    int size(){
        int count = 0;
        for (Node* p = getHead(); p != NULL; p = p->getLink())
            count++;
        return count;
    }

    // ȭ�鿡 ���� ���� ���
    void display(){
        printf("[number of contents : %2d] : ", size());
        for (Node* p = getHead(); p != NULL; p = p->getLink())
            p->display();
        printf("\n");
    }
};