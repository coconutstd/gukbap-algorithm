input = ["INT", "INT", "BOOL", "SHORT", "LONG"]
input2 = ["INT", "SHORT", "FLOAT", "INT", "BOOL"]
input3 = ["FLOAT", "SHORT", "BOOL", "BOOL", "BOOL", "INT"]
input4 = ["BOOL", "LONG", "SHORT", "LONG", "BOOL", "LONG", "BOOL", "LONG", "SHORT", "LONG", "LONG"]

def solution(input):
    ret = []
    for data in input:
        mem = []
        if data == "INT":
            for i in range(4):
                mem.append("#")
        ret.append(''.join(mem))

    print(ret)

solution(input)