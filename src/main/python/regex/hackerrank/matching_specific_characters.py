# Task
#
# You have a test string .
# Your task is to write a regex that will match  with following conditions:
#
#  must be of length: 6
# First character: 1, 2 or 3
# Second character: 1, 2 or 0
# Third character: x, s or 0
# Fourth character: 3, 0 , A or a
# Fifth character: x, s or u
# Sixth character: . or ,

import re

regex = r"^[1-3][0-2][xs0][03aA][xsu][.,]$"

test_cases = [
    '12s3s,',
    'asdvcvx',
]

for test in test_cases:
    print(bool(re.search(regex, test)))
