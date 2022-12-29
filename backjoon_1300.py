import sys

N = int(input())
k = int(input())

start = 1
end = k

while start <= end:
    mid = int((start +end)/2)

    cnt = 0
    for i in range(1,N+1):
        cnt += min(N,mid//i)
    if cnt >= k:
        end = mid - 1
    else:
        start = mid + 1

    
print(int(start))
