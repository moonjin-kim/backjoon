a = input()

a = a.split('-')
sum1 = 0
if len(a) == 2:
    b,c = map(int,a)
    sum1 = b - c
elif len(a) == 1:
    sum1 = sum(map(int,a[0].split('+')))
else:
    for i in range(1,len(a)):
        if '+' in a[i]:
            b = sum(map(int,a[i].split('+')))
            a[i] = b
        a[i] = -int(a[i])
    sum1 = sum(map(int,a))

print(sum1)