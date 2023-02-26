from collections import deque

S, E = map(int,input().split())
MAX = 100000
ch = [0] * 100000
dis = [0] * 100000

ch[S] = 1
dis[S] = 0

dQ = deque()
dQ.append(S)

while dQ:
    now = dQ.popleft
    if now == S:
        break

    for next in(now-1,now+1,now+5):
        if MAX>=next > 0 and ch[next]==0:
            dQ.append(next)
            ch[next] =1
            dis[next]=dis[now]+1
    