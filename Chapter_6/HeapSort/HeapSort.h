#include "../Heap/MaxHeap.h"

void heapSort(int a[], int n){
    MaxHeap h;
    for (int i=0; i<n; i++) h.insert(a[i]);
    for (int i=n-1; i>=0; i--) a[i] = h.remove().getKey();
}