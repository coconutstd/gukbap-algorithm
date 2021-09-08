from collections import defaultdict

def solution(param0):
    answer = []
    dic = defaultdict(int)
    for file in param0:
        dic[file.split('/')[-1][0] + file.split('/')[-1][-2:]] += 1
    for item in dic.items():
        if item[1] > 1:
            answer.append(item[0])
            answer.append(str(item[1]))
    return answer