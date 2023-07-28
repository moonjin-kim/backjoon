def solution(targets):
    answer = 1
    targets.sort()
    
    preStart = targets[0][0]
    preEnd = targets[0][1]
    
    for target in targets:
        curStart = target[0]
        curEnd = target[1]
        if preStart <= curStart and curStart < preEnd:
            preStart = max(preStart, curStart)
            preEnd = min(preEnd, curEnd);
        else:
            preStart = curStart
            preEnd = curEnd
            answer += 1
            
    return answer