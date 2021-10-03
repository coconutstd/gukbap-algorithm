import re

example = "Hello, my name is Ben&nbsp;Forta. and I am" \
          "the author of multiple books on SQL (including" \
          "MySQL, Oracle PL/SQL, and SQL Server T-SQL)" \
          ",Regular&nbsp;&nbsp;Expressions, and other subjects."
regex = "&nbsp;{2,}"
obj = re.compile(regex)
print(obj.findall(example))

regex2 = "(&nbsp;){2,}"
obj2 = re.compile(regex2)
print(obj2.findall(example))