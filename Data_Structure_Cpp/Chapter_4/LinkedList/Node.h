#include <cstdio>

class Node{
    Node* link;
    int data;
public:
    Node(int val=0) : data(val), link(NULL) {}
    Node* getLink() {return link;}
    void setLink(Node* next) {link = next;}
    void display() {printf(" <%2d>", data);}
    bool hasData(int val) {return data == val;}

    // 자신 다음에 새로운 노드 n을 삽입하는 함수
    void insertNext(Node* n){
        if (n != NULL){
            n->link = link;
            link = n;
        }
    }

    // 자신의 다음 노드를 리스트에서 삭제하는 함수
    Node* removeNext(){
        Node* removed = link;
        if (removed != NULL)
            link = removed->link;
        return removed;
    }
};