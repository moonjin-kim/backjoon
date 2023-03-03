import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 6) 

N, M, R = map(int,input().split())

graph=[[] for _ in range(N+1)]

visited = [0]*(N+1)
cnt=1

for i in range(M):
    a, b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(N+1):
    graph[i].sort(reverse=True)
  
def dfs(graph,go,visited):
    global cnt
    visited[go] = cnt
    for i in graph[go]:
        if visited[i] == 0:
            cnt += 1
            dfs(graph,i,visited);
        
dfs(graph,R,visited)

for i in range(1,N+1):
    print(visited[i])

