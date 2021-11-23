def reverse(message):
    reversedMessage = [0 for _ in range(len(message))]
    for i in range(len(message) - 1, -1, -1):
        reversedMessage[len(message) - 1 - i] = message[i]

    print(reversedMessage)

def reverse2(message):
    arr = list(message)
    for i in range(int(len(message) / 2)):
        temp = arr[i]
        arr[i] = arr[len(message) - 1 - i]
        arr[len(arr) - 1 - i] = temp
    print(arr)

msg = "Hello"
reverse2(msg)
