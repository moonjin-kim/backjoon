import sys

N,C = map(int, input().split())

houses= list()
for i in range(N):
    houses.append(int(sys.stdin.readline().rstrip()))

houses.sort()

start = 1
end = houses[N-1] - houses[0]
result = 0

while (start <= end):
    mid = int((start + end) /2)

    cnt = 1
    prev_house = houses[0]

    for i in range(1,N):
        if houses[i] - prev_house >= mid:
            cnt += 1
            prev_house = houses[i]

    if cnt >= C:
        result = max(result,mid)
        start = mid + 1
    else:
        end = mid -1

print(result)