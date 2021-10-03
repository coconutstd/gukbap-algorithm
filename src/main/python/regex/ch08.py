import re

# example = """
# This is a block of of text,
# several words here are are
# repeated, and and they
# should not be.
# """
#
# regex = "[ ]+(\w+)[ ]+\1"
# obj = re.compile(regex)
# print(obj.findall(example))

example2 = """
    313-555-1234
    248-555-9999
    810-555-9000
"""

regex2 = "(\d{3})(-)(\d{3})(-)(\d{4)"
obj2 = re.compile(regex2)
print(re.sub(regex2, example2, "($1) $3-$5"))

