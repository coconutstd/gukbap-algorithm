import re

# example = "The cat scattered his food all over the room"
# regex = "cat"
# obj = re.compile(regex)
#
# print(obj.findall(example))

example2 = "The cat scattered his food all over the room"
regex2 = "\bcat\b"
obj2 = re.compile(regex2)
print(obj2.match(example2))