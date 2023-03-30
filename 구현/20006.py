import sys

def assign_player(playerId, playerLevel, rooms):
    for _,  meta in rooms.items():
        leaderLevel = players[meta['leader']]
        if abs(leaderLevel - playerLevel) <= 10 and len(meta['party']) < M -1:
            meta['party'].append(playerId)
            return True
        
    return False

def solution():
    rooms = {}
    
    for playerId, playerLevel in players.items():
        if not assign_player(playerId,playerLevel,rooms):
            rooms[len(rooms)] = {'leader': playerId, 'party': []}

    for room in rooms:
        leader =rooms[room]['leader']
        party =rooms[room]['party']

        if len(party) == M-1:
            print('Started!')
        else:
            print('Waiting!')

        for player in sorted(party + [leader]):
            print(players[player],player)

if __name__ == '__main__':
    P, M = list(map(int,input().split()))
    players = {}

    for _ in range(P):
        level, name = list(sys.stdin.readline().split())
        players[name] = int(level)
    solution()
