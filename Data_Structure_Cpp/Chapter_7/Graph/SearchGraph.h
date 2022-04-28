#include "AdjListGraph.h"
#include "../../Chapter_2/CircularQueue/CircularQueue.h"

class SearchGraph : public AdjListGraph
{
    bool visited[MAX_VTXS];
public:
    void resetVisited(){
        for (int i = 0; i < size; i++)
            visited[i] = false;
    }
    bool isLinked(int u, int v){
        for (Node* p=adj[u]; p != NULL; p=p->getLink())
            if (p->getId() == v) return true;
        return false;
    }

    // Depth First Search
    void DFS(int v){
        visited[v] = true;
        printf("%c ", getVertex(v));

        for (Node* p=adj[v]; p != NULL; p=p->getLink()){
            if (visited[p->getId()] == false)
                DFS(p->getId());
        }
    }

    // Breath First Search
    void BFS(int v){
        visited[v] = true;
        printf("%c ", getVertex(v));

        CircularQueue q;
        q.enqueue(v);

        while (!q.isEmpty()){
            int v = q.dequeue();
            for (Node* w=adj[v]; w != NULL; w=w->getLink()){
                int id = w->getId();
                if (!visited[id]){
                    visited[id] = true;
                    printf("%c ", getVertex(id));
                    q.enqueue(id);
                }
            }
        }
    }
};