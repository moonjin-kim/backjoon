def solution(sequence, k):
    answer = [0,len(sequence)-1]
    
    #부분 수열의 최소 길이
    minLen = len(sequence)
    
    #최소 길이의 수열 시작, 끝
    start = 0
    end = 1
    
    curSum = sequence[0]
    
    while start < end:
        curLen = (end-start)
        if curSum == k and minLen > (end-start):
            minLen = curLen
            answer = [start,end-1]
            curSum -= sequence[start]
            start += 1
        elif curSum > k:
            curSum -= sequence[start]
            start += 1
        elif end < len(sequence):
            curSum += sequence[end]
            end += 1
        else:
            break
        
    return answer