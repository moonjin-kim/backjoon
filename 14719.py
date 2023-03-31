H, W = map(int,input().split())

blocks = list(map(int,input().split()))

rainwater = 0

for i in range(1,W-1):
    left_max = max(blocks[:i])
    right_max = max(blocks[i+1:])

    min_h = min(left_max,right_max)

    if blocks[i] < min_h:
        rainwater += min_h - blocks[i]

print(rainwater)