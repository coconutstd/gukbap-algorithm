import re

# example = "The URL is http://www.forta.com/, to connect" \
#           "securely use https://www.forta.com/ instead."
#
# regex = "https?:\/\/[\w\/]+"
#
# obj = re.compile(regex)
# print(obj.findall(example))

# example2 = """
#             body {
#                 background-color: #fefbd8;
#             }
#             h1 {
#                 background-color: #0000ff;
#             }
#             div {
#                 background-color: #d0f4e6;
#             }
#             span {
#                 background-color: #f08970;
#             }
#            """
# regex2 = "#[a-z0-9A-Z]{6}"
# obj = re.compile(regex2)
# print(obj.findall(example2))

example3 = """
            This offer is not available to customers
            living in <b>AK</b> and <b>HI</b>.
            """

regex3 = "<[Bb].*?<\/[Bb]>"

obj = re.compile(regex3)
print(obj.findall(example3))
