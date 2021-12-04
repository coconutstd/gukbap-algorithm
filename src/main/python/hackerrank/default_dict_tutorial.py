from collections import defaultdict
n, m = map(int, input().split(' '))

d = defaultdict(list)
for i in range(1, n + 1):
    k = input()
    d[k].append(i)

for _ in range(m):
    k = input()
    if not d[k]:
        print(-1)
    else:
        for item in d[k]:
            print(item, end=' ')
        print()