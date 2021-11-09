import re

Regex_Pattern = r"^(\d\d)(-?)\1\2\1\2\1$"

print(str(bool(re.search(Regex_Pattern, input()))).lower())

# 1-234-56-78 false
# 12-45-7810 false
# 12-34-45-13 true
