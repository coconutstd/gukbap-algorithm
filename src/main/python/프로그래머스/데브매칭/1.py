def solution(drum):
    answer = 0
    length = len(drum)
    for start in range(length):
        i = 0
        j = start
        cnt = 0
        while 0 <= j < length and 0 <= i < length:
            if drum[i][j] == '#':
                i += 1
            elif drum[i][j] == '>':
                j += 1
            elif drum[i][j] == '<':
                j -= 1
            elif drum[i][j] == '*':
                cnt += 1
                i += 1
                if cnt == 2:
                    break
            if i == length:
                answer += 1
    return answer


print(solution(["######",">#*###","####*#","#<#>>#",">#*#*<","######"]))