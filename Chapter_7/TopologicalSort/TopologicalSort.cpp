#include "TopoSortGraph.h"

int main(){
    TopoSortGraph g;

    for (int i = 0; i < 6; i++)
        g.insertVertex(i);
    
    g.insertDirEdge(0,2);
    g.insertDirEdge(1,3);
    g.insertDirEdge(2,3);
    g.insertDirEdge(3,5);
    g.insertDirEdge(4,5);
    g.insertDirEdge(0,3);
    g.insertDirEdge(1,4);
    g.insertDirEdge(2,5);

    printf("Topological Sort ==> ");
    g.TopoSort();

    return 0;
}