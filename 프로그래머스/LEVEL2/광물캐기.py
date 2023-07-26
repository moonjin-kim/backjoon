from collections import deque


fatigue = [{"diamond" : 1, "iron" : 1, "stone" : 1},
           {"diamond" : 5, "iron" : 1, "stone" : 1},
           {"diamond" : 25, "iron" : 5, "stone" : 1}]

def solution(picks, minerals):
    answer = [float("inf") for _ in range(3)]
    for i in range(3):
        copyPicks = picks[:]
        if copyPicks[i] > 0:
            copyPicks[i] -= 1
            print(copyPicks)
            answer[i] = DFS(copyPicks,minerals,0,i,0)
        
    return min(answer)


def DFS(picks, minerals, answer, selectPick,visit):
    count = 0
    while len(minerals) > visit:
        if count == 5:
            break
        data = minerals[visit]
        answer += fatigue[selectPick][data]
        visit += 1
        count += 1
    
    if len(minerals) == visit or any(picks) == False:
        return answer
    
    dfsAnswer = [float("inf") for _ in range(3)]
    for i in range(3):
        copyPicks = picks[:]
        
        if copyPicks[i] > 0:
            copyPicks[i] -= 1
            dfsAnswer[i] = DFS(copyPicks,minerals,answer,i,visit)
            
            
    return min(dfsAnswer)
        
        