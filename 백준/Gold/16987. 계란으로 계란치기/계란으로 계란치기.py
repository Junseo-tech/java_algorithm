import sys
input = sys.stdin.readline
N = int(input())
eggs = [list(map(int, input().split())) for _ in range(N)]

def break_eggs(idx):
    if idx == N:
        return sum(1 for s,w in eggs if s <= 0)
    if eggs[idx][0] <= 0:
        return break_eggs(idx + 1)
    
    hit = False
    max_eggs = 0

    for i in range(N):
        if i != idx and eggs[i][0] >= 0:
            eggs[idx][0] -= eggs[i][1]
            eggs[i][0] -= eggs[idx][1]
            hit = True
            max_eggs = max(max_eggs, break_eggs(idx + 1))
            eggs[idx][0] += eggs[i][1]
            eggs[i][0] += eggs[idx][1]
    
    if not hit:
        return break_eggs(idx + 1)
    
    return max_eggs

print(break_eggs(0))
