def count_substring(string, sub_string):
    start = 0
    cnt = 0
    result = string.find(sub_string, start)
    while result != -1:
        cnt += 1
        start = result + 1
        result = string.find(sub_string, start)
    return cnt


if __name__ == '__main__':
    string = input().strip()
    sub_string = input().strip()

    count = count_substring(string, sub_string)
    print(count)