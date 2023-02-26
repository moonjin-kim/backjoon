import sys
a = []

N = int(input())

for i in range(N):
    b = list(map(str,sys.stdin.readline().split()))
    if b[0] == 'pop':
        if len(a) == 0:
            print(-1)
        else:
            print(a.pop());
    elif b[0] == 'push':
        a.append(b[1])
    elif b[0] == 'size':
        print(len(a))
    elif b[0] == 'top':
        if len(a) == 0:
            print(-1)
        else:
            print(a[-1]);
    elif b[0] == 'empty':
        if len(a) == 0:
            print(1)
        else:
            print(0);