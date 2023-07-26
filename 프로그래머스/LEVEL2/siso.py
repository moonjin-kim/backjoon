from collections import defaultdict

distances = [2,3,4]

def solution(weights):
    answer = 0
    counter = defaultdict(int)
    
    for weight in weights:
        answer += counter[weight]
        answer += counter[(weight * 2) /3] + counter[(weight * 3) /2]
        answer += counter[(weight * 2) /4] + counter[(weight * 4) /2]
        answer += counter[(weight * 3) /4] + counter[(weight * 4) /3]
        counter[weight] += 1
        
    
    return answer