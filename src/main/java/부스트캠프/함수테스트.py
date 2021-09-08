
dic = {10: 'A', 11: 'B', 12: 'C', 13: 'D', 14: 'E', 15: 'F'}
a = 0
temp = []
while a % 16 != 0:
    mod = a % 16
    if mod >= 10:
        temp.append(dic[mod])
    else:
        temp.append(mod)
    a = a // 16

if len(temp) == 1:
    temp.append(0)
elif len(temp) == 0:
    temp += [0, 0]
temp.reverse()
print(temp)