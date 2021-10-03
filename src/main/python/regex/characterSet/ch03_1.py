import re

example = "abcderererdfs"
regex = "[\w]"
ret = re.compile(regex)
print(ret.search(example))

