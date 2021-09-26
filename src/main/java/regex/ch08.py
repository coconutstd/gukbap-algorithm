import re

example = """
This is a block of of text,
several words here are are
repeated, and and they
should not be.
"""

regex = "[ ]+(\w+)[ ]+\1"
obj = re.compile(regex)
print(obj.findall(example))