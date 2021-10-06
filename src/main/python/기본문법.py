a = 1000
print(a)

a = -1
print(-7)

a = 0
print(a)

a = 157.93
print(a)

a = -1847.34
print(a)

a = 1e9
print(a)

a = 0.3 + 0.6
print(a)
if a == 0.9:
    print(True)
else:
    print(False)

a = 0.3 + 0.6
print(round(a))
if a == 0.9:
    print(True)
else:
    print(False)

a = 7
b = 3

print(a / b)

print(a % b)
print(a // b)
a = 5
b = 3
print(a ** b)

a = [1, 2, 3, 4, 5, 6, 7, 8, 9]
print(a[4])

a = list()
print(a)

a = []
print(a)

n = 10
a = [0] * n
print(a)

a = [1, 2, 3, 4, 5, 6, 7, 8, 9]
print(a[-1])

print(a[-3])

a[3] = 7
print(a)

array = [1, 2, 3, 4, 5, 6, 7, 8, 9]
print(a[:4])

# 홀수
array = [i for i in range(20) if i % 2 == 1]
print(array)

n = 3
m = 4
array = [[i for i in range(1, m + 1)] for _ in range(n)]
print(array)

a = [1, 4, 3]
print("기본 리스트:", a)

a.append(2)
print("삽입: ", a)

a.sort()
print("오름차순 정렬: ", a)

a.sort(reverse = True)
print("내림차순 정렬: ", a)

a.reverse()
print("원소 뒤집기: ", a)

a.insert(2, 3)
print("인덱스 2에 3추가: ", a)

print("값이 3인 데이터 개수: ", a.count(3))

a.remove(1)
print("값이 1인 데이터 삭제: ", a)

a.remove(3)
print("값이 2인 데이터 삭제: ", a)

a = [1, 2, 3, 4, 5, 5, 5]
remove_set = {3, 5}

result = [i for i in a if i not in remove_set]
print(result)

data = 'Hello World'
print(data)

data = 'Hello World'
print(data)

data = "Don't you know \"Python\"?"
print(data)

a = "Hello"
b = "World"
print(a + " " + b)

a = "String"
print(a * 3)
a = "ABCDEF"
print(a[2:4])

