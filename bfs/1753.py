import sys
import heapq
import math
input = sys.stdin.readline

V, E = map(int,input().split())
K = int(input())
graph = [[] for _ in range(V+1)]
visited = [math.inf  for _ in range(V+1)]

for _ in range(E):
    start, end, cost = map(int,input().split())
    graph[start].append((end, cost))

que = []
heapq.heappush(que,(0,K))
visited[K] = 0

while que:
    cost, index = heapq.heappop(que)
    if visited[index] < cost:
        continue
    for i in graph[index]:
        next_cost = visited[index] + i[1]
        if visited[i[0]] > next_cost:
            visited[i[0]] = next_cost
            heapq.heappush(que,( next_cost, i[0]))

for i in range(1, V+1):
    if visited[i] == math.inf:
        print("INF")
    else:
        print(visited[i])