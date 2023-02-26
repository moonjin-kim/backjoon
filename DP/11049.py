N = int(input())

procession = []

for _ in range(N):
    procession.append(list(map(int,input().split())))

mult = [[0] * N for _ in range(N)]

subMult = {0: procession[0][1] * procession[0][0]}
for idx in range(1,N):
        subMult[idx] = subMult[idx-1] * procession[idx][1]

for size in range(1,N):
    for start in range(N-1):
        end = start + size
        if end>= len(procession):
            break
        result = float("inf")

        for cut in range(start, end):
            result = min(result, mult[start][cut] + mult[cut+1][end]+procession[start][0]*procession[cut][1]*procession[end][1])
        
        mult[start][end] = result

print(mult[0][N-1])