from itertools import permutations

input_str, number = input().split(' ')
answer = []
for perm in permutations(input_str, int(number)):
    blank = ''
    for temp in perm:
        blank += temp
    answer.append(blank)

answer.sort()
for a in answer:
    print(a)
