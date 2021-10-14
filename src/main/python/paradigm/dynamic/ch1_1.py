import unittest

def fact(n):
    sum = 1
    for i in range(1, n + 1):
        sum *= i
    return sum


def recur_fact(n):
    if n == 1:
        return 1
    return n * recur_fact(n - 1)

print(fact(5))
print(recur_fact(5))


