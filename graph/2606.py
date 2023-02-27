import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
M = int(input())

graph = [[] for _ in range(N+1)]
visited = [0 for _ in range(N+1)]

for _ in range(M):
    start, end = map(int,input().split())
    graph[start].append(end) 
    graph[end].append(start)

stack = deque()
stack.append(1)
visited[1] = 1
count = 0

while stack:
    index = stack.popleft()
    for k in graph[index]:
        if visited[k] == 0:
            visited[k] = 1
            count += 1
            stack.append(k)

print(count)

