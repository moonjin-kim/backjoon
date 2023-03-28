def fec(n):
    if n >= 1:
        return n*fec(n-1)
    else:
        return 1
    
n = int(input())
print(fec(n))