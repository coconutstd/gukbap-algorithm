import re

example = "Hello, my name is Ben. Please visit\nmy website Ben at http://www.forta.com/."
regex = re.compile('Ben')
print(regex.findall(example))