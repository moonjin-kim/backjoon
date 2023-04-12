import sys

input = sys.stdin.readline

str = list(input().rstrip())
count_zero = str.count('0')//2
count_one = str.count('1')//2
str = ''

for _ in range(count_zero):
    str += '0'

for _ in range(count_one):
    str += '1'

print(str)