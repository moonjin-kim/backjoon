import sys
import heapq
import math
input = sys.stdin.readline


N, M = map(int,input().split())

edges = []
distance = [math.inf] * (N + 1)

for _ in range(M):
    start, end, cost = map(int,input().split())
    edges.append((start, end, cost))

def timeMachine(start):
    distance[start] = 0
    for i in range(N):
        for j in range(M):
            cur_node = edges[j][0]
            next_node = edges[j][1]
            edge_cost = edges[j][2]

            if distance[cur_node] != math.inf and distance[next_node] > distance[cur_node] + edge_cost:
                distance[next_node] = distance[cur_node] + edge_cost

                if i == N - 1:
                    return True

    return False

negative_cycle = timeMachine(1)

if negative_cycle:
    print("-1")
else:
    for i in range(2,N + 1):
        if distance[i] == math.inf:
            print("-1")
        else:
            print(distance[i])
