import collections

def solution(want, number, discount):
    answer = 0
    dict = {}
    for i in range(len(want)):
        dict[want[i]] = number[i]
    
    for i in range(len(discount)):
        ex_counter = collections.Counter(discount[i:10+i])
        if ex_counter == dict:
            answer += 1
        
    return answer