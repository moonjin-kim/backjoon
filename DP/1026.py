n=int(input())
A,B=list(map(int,input().split())),list(map(int,input().split()))
a,b=sorted(A, reverse=True),sorted(B)

sum = 0
for i in range(n):
    sum += a[i] * b[i]


print(sum) 