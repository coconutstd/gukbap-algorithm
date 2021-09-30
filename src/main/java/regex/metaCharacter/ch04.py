import re

example = '\home\\ben\\sales\\'

regex = '\\'

obj = re.compile(regex)
print(obj.findall(example))

