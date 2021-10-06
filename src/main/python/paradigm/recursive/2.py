def factorial_iterative(n):
    ret = 1
    for i in range(1, n + 1):
        ret *= i
    return ret


def factorial_recursive(n):
    if n == 1:
        return 1
    return n * factorial_recursive(n - 1)


print(factorial_iterative(5))
print(factorial_recursive(5))
