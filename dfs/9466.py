import sys
sys.setrecursionlimit(10**6)

def DFS(x):
    global count

    visited[x] = True
    cycle_list.append(x)

    if visited[arr[x]] == True:
        if arr[x] in cycle_list:
            count -= len(cycle_list[cycle_list.index(arr[x]):])
        return
    else:
        DFS(arr[x])
    

t = int(input())

for i in range(t):
    n = int(input())

    arr = [0]
    arr.extend([int(x) for x in sys.stdin.readline().rstrip().split()])

    visited = [False] * (n+1)
    count = n

    for i in range(1, n+1):
        if not visited[i]:
            cycle_list = []
            DFS(i)
    print(count)