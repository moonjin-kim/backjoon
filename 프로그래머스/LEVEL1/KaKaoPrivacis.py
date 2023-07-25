from dateutil.relativedelta import relativedelta
from dateutil.parser import parse
import datetime 

def solution(today, terms, privacies):
    answer = []
    
    todayArr = parse(today)
    privaciesDicts = toDict(terms)
    
    for i in range(len(privacies)):
        day , term = privacies[i].split()
        expiration = parse(day) + relativedelta(months=privaciesDicts[term]) 
        if expiration <= todayArr:
            answer.append(i+1)
            
    return answer

def toDict(terms):
    termsDicts = {}
    for term in terms:
        data = term.split()
        termsDicts[data[0]] = int(data[1])
        
    return termsDicts