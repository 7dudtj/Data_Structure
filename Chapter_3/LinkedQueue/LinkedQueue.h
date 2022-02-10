#include "Node.h"

class LinkedQueue{
    Node* front;
    Node* rear;
public:
    LinkedQueue() : front(NULL), rear(NULL) {}
    ~LinkedQueue() {while (!isEmpty()) delete dequeue();}
    bool isEmpty() {return front == NULL;}

    // 삽입 연산
    void enqueue(Node* p){
        if (isEmpty()) front = rear = p;
        else{
            rear -> setLink(p);
            rear = p;
        }
    }

    // 삭제 연산
    Node* dequeue(){
        if (isEmpty()) return NULL;
        Node* p = front;
        front = front -> getLink();
        if (front == NULL) rear = NULL;
        return p;
    }

    Node* peek() {return front;}
    void display(){
        printf("[queue contents] : ");
        for (Node* p = front; p != NULL; p = p->getLink())
            p->display();
        printf("\n");
    }
};