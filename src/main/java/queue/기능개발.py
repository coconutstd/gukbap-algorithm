# 각 기능의 개발속도는 모두 다르다
# 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발 될 수 있다. 이 때 뒤에 있는 기능은 앞에 있는 배포될 때 함께

# 1. 큐를 순회하며 작업을 진행시킨다
# 2. 큐의 가장 앞에 있는 작업이 100이 넘어가면 뺀다. 이후의 작업도 빠질 수 있는지 확인한다.
# 3. 뺀 만큼 카운트 한 다음에 정답 배열에 추가한다.
progresses = [93, 30, 55]
speeds = [1, 30, 5]
q = progresses.copy()
answer = []
while q:
    # 작업이 남아있으면, 남은 작업들을 진행시킨다
    for i in range(0, len(q)):
        q[i] = q[i] + speeds[i]
    # 완료된 작업들을 확인한다
    while q and q[0] >= 100:
            # 100이 넘은 작업이 있으면 배포한다
            pop_cnt = 1
            q.pop(0)
            speeds.pop(0)
            # 바로 다음 작업도 100이 넘으면 배포한다, 있다면 완료된 작업이 나오지 않을 때 까지 배포한다
            while q and q[0] >= 100:
                q.pop(0)
                speeds.pop(0)
                pop_cnt += 1
            if pop_cnt > 0:
                answer.append(pop_cnt)

print(answer)





