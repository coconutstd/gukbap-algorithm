def solution(record):

    logs = [r.split(' ') for r in record]
    uid_current_nickname = {}
    temp = []

    for r in record:
        commands = r.split(' ')

        if commands[0] == 'Enter':
            uid_current_nickname[commands[1]] = commands[2]
            temp.append(commands[1] + '님이 들어왔습니다.')
        elif commands[0] == 'Leave':
            temp.append(commands[1] + '님이 나갔습니다.')
        else:
            uid_current_nickname[commands[1]] = commands[2]

    return [uid_current_nickname[log[1]]+'님이 들어왔습니다.' if log[0] == 'Enter' else uid_current_nickname[log[1]]+'님이 나갔습니다.' for log in logs if log[0] != 'Change']


data = ["Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"]
print(solution(data))
