def reverse(message):
    reversedMessage = [0 for _ in range(len(message))]
    for i in range(len(message) - 1, -1, -1):
        reversedMessage[len(message) - 1 - i] = message[i]

    print(reversedMessage)

msg = "Hello"
reverse(msg)