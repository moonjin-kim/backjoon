import sys
input = sys.stdin.readline
sys.setrecursionlimit(1000000)

K = int(input())

def DFS(start, group):
    visited[start] = group

    for i in graph[start]:
        if not visited[i]:
            a = DFS(i,-group)
            if a == False:
                return False
        elif visited[i] == visited[start]:
            return False
    return True


for _ in range(K):
    V, E = map(int,input().split())
    graph = [[] for _ in range(V + 1)]
    visited = [False] * (V + 1)
    for i in range(E):
        start, end = map(int,input().split())
        graph[start].append(end)
        graph[end].append(start)

    for i in range(1,V+1):
        if not visited[i]:
            result = DFS(i,1)
            if result == False:
                break

    if not result:
        print('NO')
    else:
        print('YES')