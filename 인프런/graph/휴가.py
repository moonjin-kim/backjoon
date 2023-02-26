N = int(input())

moneys = []
for i in range(N):
    a,b = map(int,input().split())
    moneys.append([a,b])

max_moneys = 0
def DFS(v,money):
    global max_moneys
    if  v == N:
        max_moneys = max(max_moneys,money)
    else:
        DFS(v+moneys[v][0],money+moneys[v][1])
        DFS(v+1,money)

DFS(0,0)

print(max_moneys)