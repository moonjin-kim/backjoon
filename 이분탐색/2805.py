import sys

K, N = map(int, input().split())
lan = list(map(int,input().split()))
start, end = 1, max(lan)

while start <= end:
    mid = (start + end) // 2
    count = 0
    for i in lan:
        size = i - mid
        if size > 0:
            count += size
    
    if count >= N: #랜선의 개수가 분기점
        start = mid + 1
    else:
        end = mid - 1

print(end)