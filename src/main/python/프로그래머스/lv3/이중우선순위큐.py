import heapq


def solution(operations):
    answer = []
    max_heap = []
    min_heap = []

    for op in operations:
        command, number = op.split(' ')
        if command == 'I':
            heapq.heappush(max_heap, -int(number))
            heapq.heappush(min_heap, int(number))
        else:
            if int(number) == 1 and max_heap:
                max_val = heapq.heappop(max_heap)
                min_heap.remove(-max_val)
            elif int(number) == -1 and min_heap:
                min_val = heapq.heappop(min_heap)
                max_heap.remove(-min_val)

    if max_heap:
        return [-max_heap[0], min_heap[0]]

    return [0, 0]