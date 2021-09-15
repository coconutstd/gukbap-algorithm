N = 100

cnt = 0
for l in range(0, N + 1):
    for r in range(l, N + 1):
        all = [l, r - l, N - r]
        if all.count(max(all)) == 1:
            cnt += 1

print(cnt)