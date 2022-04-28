#include "../Graph/AdjListGraph.h"
#include "../../Chapter_2/ArrayStack/ArrayStack.h"

class TopoSortGraph : public AdjListGraph
{
    int indegree[MAX_VTXS];
public:
    void insertDirEdge(int u, int v){
        adj[u] = new Node(v, adj[u]);
    }
    void TopoSort(){
        for (int i = 0; i < size; i++)
            indegree[i] = 0;
        for (int i = 0; i < size; i++){
            Node* node = adj[i];
            while (node != NULL){
                indegree[node->getId()]++;
                node = node->getLink();
            }
        }
        ArrayStack s;
        for (int i = 0; i < size; i++)
            if (indegree[i] == 0) s.push(i);

        while (s.isEmpty() == false){
            int w = s.pop();
            printf(" %d ", getVertex(w));
            Node* node = adj[w];
            while (node != NULL){
                int u = node->getId();
                indegree[u]--;
                if (indegree[u] == 0)
                    s.push(u);
                node = node->getLink();
            }
        }
        printf("\n");
    }
};