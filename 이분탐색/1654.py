import sys

K, N = map(int, input().split())
lan = [int(sys.stdin.readline()) for _ in range(K)]
start, end = 1, max(lan)

while start <= end:
    mid = (start + end) // 2
    count = 0
    for i in lan:
        count += i // mid
    
    if count >= N: #랜선의 개수가 분기점
        start = mid + 1
    else:
        end = mid - 1

print(end)