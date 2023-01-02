n = int(input())

data = [0] * n
house_cost = []
R = [0] * n
G = [0] * n
B = [0] * n

for i in range(n):
    R[i],G[i],B[i] = map(int,input().split())

for i in range(1,n):
    R[i] = min(G[i-1],B[i-1]) + R[i]
    G[i] = min(R[i-1],B[i-1]) + G[i]
    B[i] = min(G[i-1],R[i-1]) + B[i]

print(min(R[n-1],G[n-1],B[n-1]))