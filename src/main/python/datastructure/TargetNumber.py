def solution(numbers, target):
    for i in range(len(numbers)):
        for j in range(len(numbers)):
            if numbers[i] + numbers[j] == target and i != j:
                return (i, j)
    return None

def solution2(numbers, target):
    numbers_dict = dict()

    for idx, number in enumerate(numbers):
        numbers_dict[number] = idx

    for idx, number in enumerate(numbers):
        if target - number in numbers_dict.keys() and numbers_dict[target - number] != idx:
            return (idx, numbers_dict[target - number])

    return None

print(solution2([2,3,4,7], 9))

