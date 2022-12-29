import sys

N = int(input())

sugar_type = [5, 3]

answer = []

def select(N, redue,count):
    global answer
    if redue == 0:
        answer.append(count)
    elif redue < 0:
        return 0
    else:
        select(N,redue - 5,count + 1)
        select(N,redue - 3,count + 1)

select(N,N,0)

if len(answer) == 0:
    print(-1)
else:
    print(min(answer))