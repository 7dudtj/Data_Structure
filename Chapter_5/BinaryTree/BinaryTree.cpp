#include "BinaryTree.h"

int main(){
    BinaryTree tree;
    BinaryNode* d = new BinaryNode('D', NULL, NULL);
    BinaryNode* e = new BinaryNode('E', NULL, NULL);
    BinaryNode* b = new BinaryNode('B', d, e);
    BinaryNode* f = new BinaryNode('F', NULL, NULL);
    BinaryNode* c = new BinaryNode('C', f, NULL);
    BinaryNode* a = new BinaryNode('A', b, c);

    tree.setRoot(a);
    tree.inorder();
    tree.preorder();
    tree.postorder();
    tree.levelorder();
    printf("\n");

    printf("number of nodes = %d\n", tree.getCount());
    printf("number of leafs = %d\n", tree.getLeafCount());
    printf("height of tree = %d\n", tree.getHeight());

    return 0;
}