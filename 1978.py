import sys
input = sys.stdin.readline

N = int(input())

num = list(map(int,input().split()))

count = 0

def isPrime(num):
    i = 2
    if num == 1:
        return 0
    while i*i <= num:
        if num % i == 0:
            return 0
        i += 1
    return 1

for i in num:
    count += isPrime(i)

print(count)