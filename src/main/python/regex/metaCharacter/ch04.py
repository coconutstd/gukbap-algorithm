import re

# example = '\home\\ben\\sales\\'
#
# regex = '\\'
#
# obj = re.compile(regex)
# print(obj.findall(example))

example2 = "  db. d edd sa"
print(re.sub(r"\s", '.', example2))
