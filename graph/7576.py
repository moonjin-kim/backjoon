import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

M, N = map(int, input().split())

tomatos = []

stack = deque()

for i in range(N):
    tomato = list(map(int,input().split()))
    tomatos.append(tomato)
    for j in range(M):
        if tomato[j] == 1:
            stack.append([j,i])

while stack:
    point = stack.popleft()
    x = point[0]
    y = point[1]
    for i in range(4):
        if 0 <= x+dx[i] and x+dx[i] < M and 0 <= y+dy[i] and y+dy[i] < N:
            if tomatos[y+dy[i]][x+dx[i]] == 0:
                tomatos[y+dy[i]][x+dx[i]] = tomatos[y][x] + 1
                stack.append([x+dx[i],y+dy[i]])

def days(day):
    for i in range(N):
        for j in range(M):
            if tomatos[i][j] == 0:
                return -1
            
            day = max(day, tomatos[i][j])

    return day-1

print(days(1))



