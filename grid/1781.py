import sys
import heapq

N = int(sys.stdin.readline())

problem =[]

for _ in range(N):
    deadline, goods = map(int ,sys.stdin.readline().split())
    problem.append((deadline, goods))

problem.sort()

queue = []
for i in problem:
    heapq.heappush(queue, i[1])
    if i[0] < len(queue):
        heapq.heappop(queue)

print(sum(queue))