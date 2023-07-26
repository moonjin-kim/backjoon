from collections import deque

def solution(book_time):
    #시간을 분으로 변경
    book_time_minute = [(int(s[:2]) * 60 + int(s[3:]), int(e[:2]) * 60 + int(e[3:]) + 10) for s, e in book_time]
    book_time_minute.sort()
    
    #room
    room = [0 for _ in range(24 * 60 + 10)] 
    
    for time in book_time_minute:
        room[time[0]] += 1
        room[time[1]] -= 1
        
    for i in range(1,24 * 60):
        room[i] += room[i-1]
        
    return max(room)
