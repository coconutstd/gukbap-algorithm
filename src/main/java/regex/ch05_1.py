import re

example = "The URL is http://www.forta.com/, to connect" \
          "securely use https://www.forta.com/ instead."

regex = "https?:\/\/[\w\/]+"

obj = re.compile(regex)
print(obj.findall(example))