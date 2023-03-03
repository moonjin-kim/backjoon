import sys
input = sys.stdin.readline

n, k = map(int,input().split())
p = 1000000007

arr = [1 for i in range(n+1)]

def power(a, b):
    if b == 0:
        return 1
    if b % 2:   #홀수이면
        return (power(a, b//2) ** 2 * a) % p
    else:
        return (power(a, b//2) ** 2) % p

for i in range(1,n+1):
    arr[i] = arr[i-1] * i % p
    
A = arr[n]    
b = (arr[k] * arr[n-k]) % p

print(arr)