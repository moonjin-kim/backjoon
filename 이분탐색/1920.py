import sys

N = int(input())
numbers = list(map(int,input().split()))
numbers.sort()

M = int(input())
search_numbers = list(map(int,input().split()))

for num in search_numbers:
    start = 0
    end = len(numbers) -1
    search = 0
    while start < end:
        mid = (start + end) // 2
        if numbers[mid] == num:
            search = 1
            break
        elif numbers[mid] > num:
            end = mid - 1
        else:
            start = mid + 1
    print(search)