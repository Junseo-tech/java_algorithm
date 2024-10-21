import sys
input = sys.stdin.readline
N = int(input())
soulutions = list(map(int, input().split()))
start, end = 0,N-1
temp = sys.maxsize

a,b = 0,0
while start < end:
    check = soulutions[start] + soulutions[end]
    if abs(check) <= temp:
        temp = abs(soulutions[start] + soulutions[end])
        a,b = soulutions[start], soulutions[end]
    if check >= 0:
        end -= 1
    else:
        start += 1

print(a,b)
