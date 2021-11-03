# 인접리스트 만들기

# 1 - 2 - 3 - 4 - 5
#             6

v = 5
graph = [[] for _ in range(v + 1)]
visited = [False for _ in range(v + 1)]
graph[1].append(2)
graph[2].append(3)
graph[3].append(4)
graph[4].append(5)
graph[4].append(6)


def dfs(graph, visited, start):

    stack = []
    # 시작 정점은 1
    print(start)
    stack.append(start)
    visited[start] = True
    while True:
        for i in range(len(graph[start])):
            next = graph[start][i]
            if not visited[next]:
                stack.append(next)
                visited[next] = True
                print(next)
                start = next
                break
        if stack:
            stack.pop()
        else:
            break

dfs(graph, visited, 1)



