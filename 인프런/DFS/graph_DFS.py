def DFS(v):
    if v==n+1:
        return 
    else:
        
        DFS(v*2)
         
        DFS(v*2+1)
        print(v)

DFS(1)