import sys
input = sys.stdin.readline

n, k = map(int,input().split())

arr = [[1 for j in range(n)] for i in range(n)]

for i in range(n):
    for j in range(min(i,k)):
        if j==0 and j==i:
            arr[i][j] = 1
        else:
            arr[i][j] = arr[i-1][j-1] + arr[i-1][j]
    
print(arr[n-1][k-1] % 10007)