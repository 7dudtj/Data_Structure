#include "CircularQueue.h"

class BinaryTree
{
protected:
    BinaryNode* root;
public:
    BinaryTree() : root(NULL) {}
    void setRoot(BinaryNode* node) {root = node;}
    BinaryNode* getRoot() {return root;}
    bool isEmpty() {return root==NULL;}

    // traverse functions
    void inorder(){ printf("\n    inorder: "); inorder(root); }
    void inorder(BinaryNode* node){
        if (node != NULL){
            if (node->getLeft() != NULL) inorder(node->getLeft());
            printf(" [%d] ", node->getData());
            if (node->getRight() != NULL) inorder(node->getRight());
        }
    }
    void preorder(){ printf("\n   preorder: "); preorder(root); }
    void preorder(BinaryNode* node){
        if (node != NULL){
            printf(" [%d] ", node->getData());
            if (node->getLeft() != NULL) inorder(node->getLeft());
            if (node->getRight() != NULL) inorder(node->getRight());
        }
    }
    void postorder(){ printf("\n  postorder: "); postorder(root); }
    void postorder(BinaryNode* node){
        if (node != NULL){
            if (node->getLeft() != NULL) inorder(node->getLeft());
            if (node->getRight() != NULL) inorder(node->getRight());
            printf(" [%d] ", node->getData());
        }
    }
    void levelorder(){
        printf("\n levelorder: ");
        if (!isEmpty()){
            CircularQueue q;
            q.enqueue(root);
            while (!q.isEmpty()){
                BinaryNode* n = q.dequeue();
                if (n != NULL){
                    printf(" [%d] ", n->getData());
                    q.enqueue(n->getLeft());
                    q.enqueue(n->getRight());
                }
            }
        }
        printf("\n");
    }

    // functions
    int getCount(){ return isEmpty() ? 0 : getCount(root); }
    int getCount(BinaryNode* node){
        if (node == NULL) return 0;
        return 1+getCount(node->getLeft())+getCount(node->getRight());
    }
    int getLeafCount() { return isEmpty() ? 0 : getLeafCount(root); }
    int getLeafCount(BinaryNode* node){
        if (node == NULL) return 0;
        if (node->isLeaf()) return 1;
        else return getLeafCount(node->getLeft())+getLeafCount(node->getRight());
    }
    int getHeight() { return isEmpty() ? 0 : getHeight(root); }
    int getHeight(BinaryNode* node){
        if (node == NULL) return 0;
        int hLeft = getHeight(node->getLeft());
        int hRight = getHeight(node->getRight());
        return (hLeft>hRight) ? hLeft+1 : hRight+1;
    }
};