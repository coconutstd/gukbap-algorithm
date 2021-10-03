import re

example = """
    http://www.forta.com/
    https://mail.forta.com/
    ftp://ftp.forta.com/
"""

regex = "\w+(?=:)"
print(re.findall(regex, example))