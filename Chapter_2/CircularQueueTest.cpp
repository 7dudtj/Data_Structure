#include "CircularQueue.h"

int main(){
    CircularQueue queue;
    for (int i = 1; i < 10; i++)
        queue.enqueue(i);
    queue.display();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.display();

    return 0;
}