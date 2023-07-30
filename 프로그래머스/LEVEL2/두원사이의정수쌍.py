def solution(r1, r2):
    spot_count = 0
        
    answer = 0
    for i in range(1,r2):
        if i < r1:
            answer += calDotInSpot(i, r2, "r2") - calDotInSpot(i, r1, "r1");
        else:
            answer += calDotInSpot(i, r2, "r2")
        
    answer = answer + r2 - r1 + 1
    
    
    return answer * 4

def square(num):
    return num*num

def calDotInSpot(i,radius,aria):
    spotCount = (square(radius) - square(i)) ** (1/2) 
    if aria == "r1" and spotCount - int(spotCount) == 0.0 :
        return int(spotCount) - 1
    else: 
        return int(spotCount) 
    