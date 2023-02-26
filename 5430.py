 from collections import deque


test_case = int(input())
answer = []
data = 0
for _ in range(test_case):
    p = input()
    num_count = int(input())
    arr = input()
    arr = arr.replace('[', '')
    arr = arr.replace(']', '')
    arr = arr.replace(',',' ', num_count-1)
    arr = deque(list(map(int, arr.split())))
    data=0
    reverse = 1
    for i in list(p):
        if i == 'R':
            reverse = -reverse
        if i == 'D':
            if len(arr) == 0:
                data = 1
                break
            else:
                if reverse == 1:
                    arr.popleft()
                else:
                    arr.pop()
    if data == 0:
        answer.append([arr,reverse])
    else:
        answer.append('error')
for i in answer:
    if len(i) != 2:
        print('error')
    else:
        a = list(i[0])
        if i[1] != 1:
            a.reverse()
        a=list(map(str,a))
        print('[' + ",".join(a) + ']')
        