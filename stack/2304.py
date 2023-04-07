import sys

input = sys.stdin.readline

N = int(input())

max = 0
m_idx =0
maxL = 0
pillars = [0 for _ in range(1001)]

for _ in range(N):
    index, height = map(int, input().split())
    if maxL < index:
        maxL = index
    if height > max:
        max = height
        m_idx = index
    pillars[index] = height

total = 0
tmp = 0
for i in range(m_idx+1):
    if pillars[i] > tmp:
        tmp = pillars[i]
    total += tmp

tmp = 0
for i in range(maxL,m_idx,-1):
    if pillars[i] > tmp:
        tmp = pillars[i]
    total += tmp
    
print(total)