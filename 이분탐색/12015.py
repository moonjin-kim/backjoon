import sys

K = int(input())
sequence = list(map(int,input().split()))
lis = [0]

for num in sequence:
    if lis[-1]<num:
        lis.append(num)
    else:
        start = 0
        end = len(list)
        while start < end:
            mid = (start + end) // 2

            if lis[mid] < num:
                start = mid + 1
            else:
                end = mid
            
        lis[end] = num
print(lis)
print(len(lis)-1)