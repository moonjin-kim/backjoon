import sys
from collections import deque
input = sys.stdin.readline

def searchGame(N):
    visited = [0] * 100001
    d=deque()
    d.append(N)

    count = 0

    while d:
        index = d.popleft()
        if index == K:
            return visited[index]
        
        for next_index in (index + 1, index - 1, index * 2):
            if 0 <= next_index < 100001:
                if visited[next_index] == 0:
                    if next_index == index * 2 and next_index != 0:
                        visited[next_index] = visited[index]
                        d.appendleft(next_index)
                    else:
                        visited[next_index] = visited[index] + 1
                        d.append(next_index)


N, K = map(int,input().split())
print(searchGame(N))