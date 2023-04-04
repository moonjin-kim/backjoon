import sys
input = sys.stdin.readline

N = int(input())

left_up_num = list(map(int,input().split()))

num_position = [11 for i in range(N)]

for i in range(N):
    count = left_up_num[i]
    for j in range(N):
        if count == 0 and num_position[j] == 11:
            num_position[j] = i + 1
        if i < num_position[j]:
            count -= 1

print(*num_position)