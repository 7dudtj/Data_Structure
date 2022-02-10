#include "DoubleLinkedList.h"

class LinkedDeque : public DoubleLinkedList{
public:
    void addFront(Node2* n) {insert(0, n);}
    Node2* deleteFront() {return remove(0);}
    Node2* getFront() {return getEntry(0);}
    void addRear(Node2* n) {insert(size(), n);}
    Node2* deleteRear() {return remove(size()-1);}
    Node2* getRear() {return getEntry(size()-1);}
};