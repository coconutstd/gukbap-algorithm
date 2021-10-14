# 현재 위치에서 연산을 이용하여 이동을 계산한다
# 2가지 이동 방법은 상하좌우 고려했을때 총 8가지 방법이므로 모든 방법을 테스트한다
# 편리한 계산을 위해 현재 위치에서 튜플을 이용하여 이동을 편리하게 계산 할 수 있게 한다
# 열은 a-h 행은 1-8까지이고 입력 값은 열행 순으로 들어온다

moves = [(2, 1), (2, -1), (-2, 1), (-2, -1), (1, 2), (1, -2), (-1, 2), (-1, -2)]
dict = {'a': 0, 'b': 1, 'c': 2, 'd': 3, 'e': 4, 'f': 5, 'g': 6, 'h': 7}

def solution(input):
    x = dict[input[0]]
    y = int(input[1])
    cnt = 0
    for move in moves:
        nx = x + move[0]
        ny = y + move[1]
        if 0 <= nx <= 7 and 0 <= ny <= 7:
            print(str(nx) + ' ' + str(ny))
            cnt += 1
    return cnt

print(solution('a1'))
