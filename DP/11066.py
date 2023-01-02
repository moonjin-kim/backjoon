N = int(input())

for _ in range(N):
    chapterNum = int(input())
    chapters = list(map(int,input().split()))
    data = [0] * chapterNum
    data[0] = chapters[0]
    data[1] = chapters[0] + chapters[1]
    for i in range(2,chapterNum):
        case1 = (data[i-2] + chapters[i-1] + chapters[i])
        case2 = data[i-1]+ chapters[i]
        data[i] = min(case1,case2)
    print(data)
    print(data[chapterNum-1])
