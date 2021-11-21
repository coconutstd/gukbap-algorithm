import re

Test_String = input()

Regex_Pattern = r'o(?=oo)'

match = re.findall(Regex_Pattern, Test_String)

print("Number of matches :", len(match))