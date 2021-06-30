input = ["INT", "INT", "BOOL", "SHORT", "LONG"]
input2 = ["INT", "SHORT", "FLOAT", "INT", "BOOL"]
input3 = ["FLOAT", "SHORT", "BOOL", "BOOL", "BOOL", "INT"]
input4 = ["BOOL", "LONG", "SHORT", "LONG", "BOOL", "LONG", "BOOL", "LONG", "SHORT", "LONG", "LONG"]

def solution(input):
    ret = []
    prev = ""
    for data in input:
        mem = []
        if data == "FLOAT":
            for i in range(4):
                mem.append("#")
            ret.append(''.join(mem))
        elif data == "INT":
            ret.append("########")
        elif data == "LONG":
            ret.append("########")
            ret.append("########")
        prev = data
    print(ret)

solution(input)