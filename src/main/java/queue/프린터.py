def solution(priorities, location):
    answer = 0
    priorities_location = []
    for i in range(len(priorities)):
        priorities_location.append((i, priorities[i]))
    # 정렬을 왜 했지?
    priorities_info = sorted(priorities, reverse = True)

    cnt = 1
    # 데이터 중복 처리인듯
    while priorities_location:
        if priorities_location[0][1] == priorities_info[0]:
            if location == priorities_location[0][0]:
                answer = cnt
            priorities_info.pop(0)
            priorities_location.pop(0)
            cnt += 1
        else:
            temp = priorities_location.pop(0)
            priorities_location.append(temp)
    return answer


def solution(priorities, location):
    answer = 0
    queue = []
    for p in enumerate(priorities):
        queue.append(p)

    cnt = 0

    while queue:
        cur = queue[0]
        isOk = True
        for i in range(1, len(queue)):
            if cur[1] < queue[i][1]:
                queue.pop(0)
                queue.append(cur)
                isOk = False
                break
        if isOk:
            document = queue.pop(0)
            cnt += 1
            if document[0] == location:
                answer = cnt
                break

    return answer