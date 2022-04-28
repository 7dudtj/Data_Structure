#include "HeapSort.h"
#include <cstdlib>

int main(){
    MaxHeap heap;
    int data[10];

    for (int i=0; i<10; i++) data[i] = rand() % 100;
    printf("\nbefore sort: ");
    for (int i=0; i<10; i++) printf("%3d", data[i]);
    heapSort(data, 10);
    printf("\n after sort: ");
    for (int i=0; i<10; i++) printf("%3d", data[i]);
    printf("\n");

    return 0;
}