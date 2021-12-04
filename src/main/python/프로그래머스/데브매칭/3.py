def solution(s):
    answer = []
    keyboard = {
        'q' : (0, 0),
        'w' : (0, 1),
        'e' : (0, 2),
        'r' : (0, 3),
        't' : (0, 4),
        'y' : (0, 5),
        'u' : (0, 6),
        'i' : (0, 7),
        'o' : (0, 8),
        'p' : (1, 0),
        'a' : (1, 1),
        's' : (1, 2),
        'd' : (1, 3),
        'f' : (1, 4),
        'g' : (1, 5),
        'h' : (1, 6),
        'j' : (1, 7),
        'k' : (1, 8),
        'l' : (2, 0),
        'z' : (2, 1),
        'x' : (2, 2),
        'c' : (2, 3),
        'v' : (2, 4),
        'b' : (2, 5),
        'n' : (2, 6),
        'm' : (2, 7)
    }
    MOD = int(10e9) + 7
    for i in range(len(s) - 1):
        distance = abs(keyboard[s[i]][0] - keyboard[s[i + 1]][0]) + abs(keyboard[s[i]][1] - keyboard[s[i + 1]][1])
        answer.append(distance)

    print(answer)

    return answer

solution("tooth")