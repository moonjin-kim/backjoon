import re


def solution(dartResult):
    darts = re.findall("([0-9]+)([SDT])([*#]?)", dartResult)
    answer = 0
    last_score = 0
    current_score = 0
    for dart in darts:
        answer += last_score
        last_score = current_score
        current_score = int(dart[0])
        
        current_score = square_score(current_score,dart[1])
        
        if dart[2] == '*':
            last_score *= 2
            current_score *= 2
        elif dart[2] == '#':
            current_score *= -1
        
    
    answer += last_score
    answer += current_score
    
    
    return answer

def square_score(current_score,grade):
    square = 1
    if grade == 'D':
        square = 2
    elif grade == 'T':
        square = 3
    return current_score ** square
        