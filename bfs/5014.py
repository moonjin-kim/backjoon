import sys
from collections import deque
input = sys.stdin.readline

def BFS(top,start,goal,up,down):
    visited = [0] * (F+1)
    d=deque()
    d.append(start)
    visited[start] = 1
    while d:
        index = d.popleft()
        if index == goal:
            return visited[index] -1
        
        for next_index in (index + up, index - down):
            if next_index <= top and next_index >0 and visited[next_index] == 0:
                visited[next_index] = visited[index] + 1
                d.append(next_index)

    return "use the stairs"

F, S, G, U, D = map(int,input().split())
print(BFS(F, S, G, U, D))