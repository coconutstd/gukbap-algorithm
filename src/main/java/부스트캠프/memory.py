input = ["INT", "INT", "BOOL", "SHORT", "LONG"]
input2 = ["INT", "SHORT", "FLOAT", "INT", "BOOL"]
input3 = ["FLOAT", "SHORT", "BOOL", "BOOL", "BOOL", "INT"]
input4 = ["BOOL", "LONG", "SHORT", "LONG", "BOOL", "LONG", "BOOL", "LONG", "SHORT", "LONG", "LONG"]

def solution(input):
    ret = []
    memory_type = {"BOOL": 1, "SHORT": 2, "FLOAT": 4, "INT": 8, "LONG": 16}

    prev = ""
    temp_memory = "........"
    start_index = 0
    for data in input:
        if memory_type[data] < memory_type[prev]:
            pass
        prev = data
    print(ret)

solution(input)