N = 100

cnt = 0
for rock in range(0, N + 1):
    for scissors in range(0, N - rock + 1):
        paper = N - rock - scissors
        all = [rock, scissors, paper]
        if all.count(max(all)) == 1:
            cnt += 1
print(cnt)