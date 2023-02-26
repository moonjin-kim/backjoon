N, M = map(int,input().split())

scores = []
for i in range(N):
    a,b = map(int,input().split())
    scores.append([a,b])

max_score = 0
def DFS(v,score,time):
    global max_score
    if time > 20:
        return
    elif  v == N:
        max_score = max(score,max_score)
    else:
        DFS(v+1,score+scores[v][0],time+scores[v][1])
        DFS(v+1,score,time)

DFS(0,0,0)

print(max_score)