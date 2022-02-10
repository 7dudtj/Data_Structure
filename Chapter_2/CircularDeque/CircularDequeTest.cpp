#include "CircularDeque.h"

int main(){
    CircularDeque deque;
    for (int i = 1; i < 10; i++){
        if (i % 2) deque.addFront(i);
        else deque.addRear(i);
    }
    deque.display();
    deque.deleteFront();
    deque.deleteRear();
    deque.deleteFront();
    deque.display();

    return 0;
}