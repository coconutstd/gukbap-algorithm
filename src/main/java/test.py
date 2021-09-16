import sys
class Solution:
    def reverse(self, x: int) -> int:
        if x == 0:
            return 0
        y = str(x)
        answer = []
        isZero = False
        if y[len(y) - 1] == '0':
            isZero = True
        for i in range(len(y) - 1, -1, -1):
            if y[i] == '0' and isZero == True:
                continue
            elif y[i] == '-':
                answer.insert(0, '-')
            else:
                isZero = False
                answer.append(y[i])

        result = int(''.join(answer))
        if -2147483648 <= result <= 2147483647:
            return result
        else:
            return 0

