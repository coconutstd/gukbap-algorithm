import heapq

def solution(n, recipes, orders):
    answer = 0
    q = []
    recipe = {}
    for r in recipes:
        menu, time = r.split(' ')
        recipe[menu] = int(time)

    for idx, o in enumerate(orders):
        menu, start = o.split(' ')
        start = int(start)
        end_time = start + recipe[menu]
        if not q:
            heapq.heappush(q, end_time)
        elif len(q) < n:
            heapq.heappush(q, end_time)
        elif len(q) == n and q[0] < start:
            heapq.heappop(q)
            heapq.heappush(q, end_time)
        elif len(q) == n and q[0] >= start:
            end_time = heapq.heappop(q) + recipe[menu]
            heapq.heappush(q, end_time)

        if idx == len(orders) - 1:
            answer = end_time

    return answer

print(solution(3, ["SPAGHETTI 3", "FRIEDRICE 2", "PIZZA 8"], ["PIZZA 1", "FRIEDRICE 2", "SPAGHETTI 4", "SPAGHETTI 6", "PIZZA 7", "SPAGHETTI 8"]))