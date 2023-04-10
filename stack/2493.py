import sys

input = sys.stdin.readline

N = int(input())

laser_tops = list(map(int,input().split()))
answer = [0 for i in range(N)]
stack = []

for i in range(N):
    while stack:
        if stack[-1][1] > laser_tops[i]:
            answer[i] = stack[-1][0] + 1
            break
        else:
            stack.pop()
    stack.append([i, laser_tops[i]])

print(*answer)