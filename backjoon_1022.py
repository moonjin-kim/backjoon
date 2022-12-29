import sys

data = list(map(int, input().split()))

arr = [[0 for _ in range(data[3]-data[1]+1)] for _ in range(data[2]-data[0]+1)]

max_num = max(list(map(abs,data)))
x = max_num
y = max_num
minx = x + data[1]
miny = y + data[0]

x_dir = [1,0,-1,0]
y_dir = [0,-1,0,1]
direction = 0
y_rotate = 1
step =0
cnt = 1
linecount = 1
dir_count = 0
total = (data[3]-data[1]+1) * (data[2]-data[0]+1)
while total >0:
            if (x-max_num) >= data[1] and (x-max_num) <= data[3] and (y-max_num) >= data[0] and (y-max_num) <= data[2]:
                arr[y-miny][x-minx] = cnt
                total -= 1
                max_num1 = cnt
                
            
            x += x_dir[direction]
            y += y_dir[direction]
            step += 1
            cnt += 1
            if step == linecount:
                dir_count += 1
                step = 0
                direction = (direction + 1) % 4
                if (dir_count == 2):
                    dir_count = 0
                    linecount += 1 
                

max_num_len = len(str(max_num1 - 1))
for i in arr:
    for j in i:
        print(str(j).rjust(max_num_len), end=" ")
    print()