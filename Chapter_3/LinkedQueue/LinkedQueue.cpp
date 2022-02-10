#include "LinkedQueue.h"

int main(){
    LinkedQueue q;
    for (int i = 1; i < 10; i++)
        q.enqueue(new Node(i));
    q.display();
    delete q.dequeue();
    delete q.dequeue();
    delete q.dequeue();
    q.display();

    return 0;
}