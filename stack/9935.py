import sys

str_data = list(map(str,input()))
boom_data = list(map(str,input()))
boom_data = boom_data[::-1]


boom_len = len(boom_data)
data = []

while str_data:
    data.append(str_data.pop())
    if data[len(data)-boom_len:len(data)] == boom_data:
        for i in range(boom_len):
            data.pop()
data = data[::-1]
result = ''.join(data)
if len(result) == 0:
    print("FRULA")
else:
    print(result)
