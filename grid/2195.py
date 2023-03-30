import sys
  
input = sys.stdin.readline 

S = input().rstrip()
P = input().rstrip()

count = 0
index = 0
while index < len(P):
    copy =''
    if S.find(P[index:]) != -1:
        count += 1
        break
    
    for j in range(index,len(P)):
        copy += P[j]
        
        if S.find(copy) == -1:
            count +=1
            index = j
            break

print(count)

