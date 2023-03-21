import sys
sys.setrecursionlimit(1000000)

start_str = list(input())
target_str = list(input())

def dfs(AB_str):
    if AB_str == start_str:
        print(1)
        exit()

    if len(AB_str)==0:
        return 0
    
    if AB_str[-1] == "A":
        dfs(AB_str[:-1])
    if AB_str[0] == "B":
       dfs(AB_str[1:][::-1]) 
    
dfs(target_str)
print(0)