class Solution:
    def getSmallestNode(self):
        min_val = int(1e9)
        index = 0
        for i in range(1, self.n + 1):
            if self.distance[i] < min_val and not self.visited[i]:
                min_val = self.distance[i]
                index = i
        return index

    def dijkstra(self, start):
        self.distance[start] = 0
        self.visited[start] = True
        for j in self.graph[start]:
            self.distance[j[0]] = j[1]
        for i in range(self.n - 1):
            now = self.getSmallestNode()
            self.visited[now] = True
            for j in self.graph[now]:
                cost = self.distance[now] + j[1]
                if cost < self.distance[j[0]]:
                    self.distance[j[0]] = cost

    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        INF = int(1e9)
        self.graph = [[] for _ in range(n + 1)]
        self.visited = [False] * (n + 1)
        self.distance = [INF] * (n + 1)
        self.n = n

        for time in times:
            self.graph[time[0]].append((time[1], time[2]))

        self.dijkstra(k)
        max_val = -1
        for i in range(1, n + 1):
            if self.distance[i] == INF:
                return -1
            elif max_val < self.distance[i]:
                max_val = self.distance[i]
        return max_val