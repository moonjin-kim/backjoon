import sys
from collections import deque
import math
input = sys.stdin.readline
sys.setrecursionlimit(1000000)
print("a")
N,M,V = map(int,input().split())

graph = [[] for _ in range(N+1)]
visited = [0 for _ in range(N+1)]
dfs = []
bfs = []

def DFS(start):
    visited[start] = 1
    dfs.append(start)
    for i in graph[start]:
        if visited[i] == 0:
            DFS(i)

def BFS(V):
    d=deque()
    d.append(V)
    bfs.append(V)
    visited[V] = 1
    while d:
        index = d.popleft()
        for i in graph[index]:
            if visited[i] == 0:
                visited[i] = 1
                d.append(i)
                bfs.append(i)


for _ in range(M):
    start, end = map(int,input().split())
    graph[start].append(end) 
    graph[end].append(start)

for j in range(N+1):
    graph[j].sort()

DFS(V)
for j in range(N+1):
    visited[j]=0
BFS(V)


for m in dfs:
    print(m, end=' ')
print()
for n in bfs:
    print(n, end=' ')