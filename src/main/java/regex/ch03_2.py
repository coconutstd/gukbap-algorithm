import re

example = "The Phrase \"regular expression\" is often" \
          "abbreviated as RegEx or regex"
regex = "[Rr]eg[Ee]x"
obj = re.compile(regex)
print(obj.findall(example))
