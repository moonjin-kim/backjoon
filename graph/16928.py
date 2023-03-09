import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int,input().split())

ladder = dict()
snake = dict()

for _ in range(N):
    i, j = map(int,input().split())
    ladder[i] = j

for _  in range(M):
    i, j = map(int,input().split())
    snake[i] = j

visited = [False] * 101
dice_cnt = [0] * 101
visited[1] = True

queue = deque([1])

while queue:
    now = queue.popleft()
    for i in range(1,7):
        move = now + i
        if 0 < move <= 100 and not visited[move]:
            if move in ladder.keys():
                move = ladder[move]

            if move in snake.keys():
                move = snake[move]
            
            if not visited[move]:

                queue.append(move)
                visited[move] = True
                dice_cnt[move] = dice_cnt[now] + 1
                
print(dice_cnt[100])
