N, K = map(int,input().split())

coins = []
for i in range(N):
    coins.append(int(input()))

cases = [0] * (K +1)
cases[0] = 1
for i in range(N):
    for j in range(K+1):
        if j - coins[i] >= 0:
            cases[j] += cases[j-coins[i]]

print(cases[K])

