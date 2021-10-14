def accumulated_sum(array):
    for i in range(len(array) - 1):
        array[i + 1] += array[i]

def recur_accumulated_sum(array, index):
    if index + 1 == len(array):
        return
    array[index + 1] += array[index]
    recur_accumulated_sum(array, index + 1)


arr1 = [1, 2, 3, 4, 5, 6]
print(arr1)
accumulated_sum(arr1)
print(arr1)
arr1 = [1, 2, 3, 4, 5, 6]
recur_accumulated_sum(arr1, 0)
print(arr1)