from collections import Counter

X = int(input())
show_sizes = list(map(int, input().split(' ')))
show_counter = Counter(show_sizes)
N = int(input())
answer = 0
for _ in range(N):
    size, price = map(int, input().split(' '))
    if show_counter[size] != 0:
        show_counter[size] -= 1
        answer += price

print(answer)