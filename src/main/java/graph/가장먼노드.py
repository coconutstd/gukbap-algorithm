# n개의 노드가 있는 그래프가 있습니다.
# 가장 먼 노드란 1번 노드에서 최단 경로로 이동하면서 가장 많은 간선을 사용한 노드입니다.
# 이런 노드의 개수는 몇개 일까요?
# n = 6 [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]

# 인접리스트 생성
# bfs로 거리를 적어가며 순회
# 가장 긴 거리를 찾고 그 개수 찾기