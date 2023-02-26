import sys
input=sys.stdin.readline

N = int(input())
histogram = []
data = []
result = 0
for i in range(N):
    input_data = int(input())
    data.append(input_data)
    while (histogram and data[histogram[-1]] > input_data):
        height = data[histogram.pop()]
        width = i
        if len(histogram)!=0:
            width = i - histogram[-1] -1
        if result < height * width:
            result = height * width
    histogram.append(i)
while histogram:
    height = data[histogram.pop()]
    width = N
    if len(histogram)!=0:
            width = N - histogram[-1] -1
    if result < height * width:
            result = height * width
print(result)
