#include "BinaryNode.h"
#include <stdlib.h>

inline void error(const char* str){
    fprintf(stderr, "%s\n", str);
    exit(1);
};

#define MAX_QUEUE_SIZE 100

class CircularQueue
{
private:
    int front;
    int rear;
    BinaryNode* data[MAX_QUEUE_SIZE];
public:
    CircularQueue() {front = rear = 0;}
    bool isEmpty() {return front == rear;}
    bool isFull() {return (rear+1)%MAX_QUEUE_SIZE == front;}
    void enqueue(BinaryNode* n){
        if (isFull()) error("Error: queue is full\n");
        else{
            rear = (rear+1) % MAX_QUEUE_SIZE;
            data[rear] = n;
        }
    }
    BinaryNode* dequeue(){
        if (isEmpty()) error("Error: queue is empty\n");
        else{
            front = (front+1) % MAX_QUEUE_SIZE;
            return data[front];
        }
    }
};