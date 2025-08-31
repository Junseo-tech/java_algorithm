import sys
import heapq
input = sys.stdin.readline

N = int(input())
max_heap = []

for _ in range(N):
    nums = list(map(int, input().split()))
    for num in nums:
        # heapq.heappush(max_heap, num)
        if len(max_heap) < N:
            heapq.heappush(max_heap, num)
        if max_heap[0] < num:
            heapq.heappushpop(max_heap, num)

# print(heapq.heappop(max_heap))
print(heapq.heappop(max_heap))
            
