max_weight = 30

bibers = [8,12,2,12,22,5,9,9,3]
preBibers=[]
cnt = 0
bibers.sort()

while len(bibers)!=0:
    weight = bibers[0]
    if max_weight - weight < 0:
        pre_weight = preBibers.pop()
        bibers.append(pre_weight)
        max_weight += pre_weight
    elif max_weight - weight == 0:
        cnt += 1
        max_weight = 30
        preBibers.append(bibers.pop(0))
    else:
        max_weight -= weight
        preBibers.append(bibers.pop(0))
    

    
print(cnt)

