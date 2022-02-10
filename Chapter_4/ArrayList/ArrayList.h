#include <cstdio>
#include <cstdlib>
#define MAX_LIST_SIZE 100

// 오류 처리 함수
inline void error(const char *message){
    printf("%s\n", message);
    exit(1);
}

class ArrayList{
    int data[MAX_LIST_SIZE];
    int length;
public:
    ArrayList(void) {length=0;}

    // 삽입 연산
    void insert(int pos, int e){
        if (!isFull() && pos >= 0 && pos <= length){
            for (int i = length; i > pos; i--)
                data[i] = data[i-1];
            data[pos] = e;
            length++;
        }
        else error("full state error or insert location error");
    }

    // 삭제 연산
    void remove(int pos){
        if (!isEmpty() && 0 <= pos && pos < length){
            for (int i = pos+1; i < length; i++)
                data[i-1] = data[i];
            length--;
        }
        else error("empty state error or delete location error");
    }

    int getEntry(int pos) {return data[pos];}
    bool isEmpty() {return length == 0;}
    bool isFull() {return length == MAX_LIST_SIZE;}
    bool find(int item){
        for (int i = 0; i < length; i++)
            if (data[i] == item) return true;
        return false;
    }
    void replace(int pos, int e){
        data[pos] = e;
    }
    int size() {return length;}
    void display(){
        printf("[number of contents = %2d] : ", size());
        for (int i = 0; i < size(); i++)
            printf("[%2d] ", data[i]);
        printf("\n");
    }
    void clear() {length = 0;}
};