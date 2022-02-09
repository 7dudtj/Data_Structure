#include <cstdio>
#include <cstdlib>

// 오류 처리 함수
inline void error(const char *message){
    printf("%s\n", message);
    exit(1);
}

const int MAX_STACK_SIZE = 20;

class ArrayStack
{
private:
    int top;
    int data[MAX_STACK_SIZE];

public:
    ArrayStack(){top = -1;} // 생성자
    ~ArrayStack(){} // 소멸자
    bool isEmpty(){return top == -1;}
    bool isFull(){return top == MAX_STACK_SIZE;}

    void push(int e){
        if (isFull()) error("full stack");
        data[++top] = e;
    }

    int pop(){
        if (isEmpty()) error("empty stack");
        return data[top--];
    }

    int peek(){
        if (isEmpty()) error("empty stack");
        return data[top];
    }

    void display(){
        printf("[number of items in stack = %2d] ==> ", top+1);
        for (int i = 0; i <= top; i++)
            printf("<%2d>", data[i]);
        printf("\n");
    }
};