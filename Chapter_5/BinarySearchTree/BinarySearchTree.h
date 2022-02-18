#include "..\BinaryTree\BinaryTree.h"

class BinarySearchTree : public BinaryTree
{
public:
    BinarySearchTree(void) {}
    ~BinarySearchTree(void) {}

    // search function
    BinaryNode* search(int key){
        BinaryNode* node = searchRecur(root, key);
        if (node != NULL){
            printf("search success: node which has key value %d = 0x%x\n",
            node->getData(), node);
        }
        else printf("search fail: no node which has key value %d\n", key);
        return node;
    }
    BinaryNode* searchRecur(BinaryNode* n, int key){
        if (n == NULL) return NULL;
        if (key == n->getData()) return n;
        else if (key < n->getData()) return searchRecur(n->getLeft(), key);
        else return searchRecur(n->getRight(), key);
    }

    // insert function
    void insert(BinaryNode* n) {
        if (n == NULL) return;
        if (isEmpty()) root = n;
        else insertRecur(root, n);
    }
    void insertRecur(BinaryNode* r, BinaryNode* n){
        if (n->getData() == r->getData()) return;
        else if (n->getData() < r->getData()){
            if (r->getLeft() == NULL) r->setLeft(n);
            else insertRecur(r->getLeft(), n);
        }
        else{
            if (r->getRight() == NULL) r->setRight(n);
            else insertRecur(r->getRight(), n);
        }
    }

    // delete function
    void remove(int key) {
        if (isEmpty()) return;

        BinaryNode* parent = NULL;
        BinaryNode* node = root;
        while (node != NULL && node->getData() != key){
            parent = node;
            node = (key < node->getData()) ? 
                node->getLeft() : node->getRight();
        }
        if (node == NULL){
            printf("Error: key is not in the tree!\n");
            return;
        }
        else remove(parent, node);
    }
    void remove(BinaryNode* parent, BinaryNode* node){
        // case 1: deleted node >> leaf
        if (node->isLeaf()){
            if (parent == NULL) root = NULL;
            else{
                if (parent->getLeft() == node) parent->setLeft(NULL);
                else parent->setRight(NULL);
            }
        }
        // case 2: deleted node >> has only one child
        else if (node->getLeft() == NULL || node->getRight() == NULL){
            BinaryNode* child = (node->getLeft() != NULL) ?
                node->getLeft() : node->getRight();
            if (node == root) root = child;
            else{
                if (parent->getLeft() == node) parent->setLeft(child);
                else parent->setRight(child);
            }
        }
        // case 3: deleted node >> has two children
        else{
            BinaryNode* succp = node;
            BinaryNode* succ = node->getRight();
            while (succ->getLeft() != NULL){
                succp = succ;
                succ = succ->getLeft();
            }
            if (succp->getLeft() == succ) succp->setLeft(succ->getRight());
            else succp->setRight(succ->getRight());
            node->setData(succ->getData());
            node = succ;
        }
        delete node;
    }
};