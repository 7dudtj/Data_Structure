#include "BinarySearchTree.h"

int main(){
    BinarySearchTree tree;

    // make tree
    tree.insert(new BinaryNode(35));
    tree.insert(new BinaryNode(18));
    tree.insert(new BinaryNode(7));
    tree.insert(new BinaryNode(26));
    tree.insert(new BinaryNode(12));
    tree.insert(new BinaryNode(3));
    tree.insert(new BinaryNode(68));
    tree.insert(new BinaryNode(22));
    tree.insert(new BinaryNode(30));
    tree.insert(new BinaryNode(99));

    // print basic tree information
    printf("number of nodes = %d\n", tree.getCount());
    printf("number of leafs = %d\n", tree.getLeafCount());
    printf("height of tree = %d\n", tree.getHeight());

    // tree traverse
    tree.inorder();
    tree.preorder();
    tree.postorder();
    tree.levelorder();

    // search node
    tree.search(26);
    tree.search(25);

    // delete operation
    printf("case 1 ==> delete node 3\n");
    tree.remove(3);
    tree.levelorder();
    printf("case 2 ==> delete node 68\n");
    tree.remove(68);
    tree.levelorder();
    printf("case 3 ==> delete node 18\n");
    tree.remove(18);
    tree.levelorder();
    printf("case 3 ==> delete (root) node 35\n");
    tree.remove(35);
    tree.levelorder();

    // print final tree information
    printf("number of nodes = %d\n", tree.getCount());
    printf("number of leafs = %d\n", tree.getLeafCount());
    printf("height of tree = %d\n", tree.getHeight());

    return 0;
}