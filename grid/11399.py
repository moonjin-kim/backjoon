N = int(input())

time = list(map(int,input().split()))
time.sort()
sum1 = 0
for i in range(N):
    sum1 += time[i] * (N - i)

print(sum1)