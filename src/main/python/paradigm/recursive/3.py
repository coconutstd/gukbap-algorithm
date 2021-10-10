# n = 7
#
# for i in range(n):
#     for j in range(i + 1, n):
#         for k in range(j + 1, n):
#             for l in range(k + 1, n):
#                 print(str(i) + " " + str(j) + " " + str(k) + " " + str(l))


def pick(n, picked, to_pick):
    if to_pick == 0:
        for p in picked:
            print(p, end=" ")
        print()
        return

    smallest = 0 if not picked else picked[len(picked) - 1] + 1
    for next in range(smallest, n):
        picked.append(next)
        pick(n, picked, to_pick - 1)
        picked.pop()

pick(7, [], 4)