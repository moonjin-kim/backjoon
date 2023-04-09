from collections import deque

N = int(input())

cards = deque()

for i in range(N):
        cards.append(N-i)

while len(cards)>1:
        cards.pop()
        if len(cards) == 1:
            break
        cards.appendleft(cards.pop())

print(cards.pop())