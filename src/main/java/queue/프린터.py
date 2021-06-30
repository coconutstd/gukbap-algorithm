def solution(priorities, location):
    answer = 0
    priorities_location = []
    for i in range(len(priorities)):
        priorities_location.append((i, priorities[i]))
    priorities_info = sorted(priorities, reverse = True)

    cnt = 1
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