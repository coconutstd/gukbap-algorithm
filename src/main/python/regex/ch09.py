import re

example = """
http://www.forta.com/
https://mail.forta.com/
ftp://ftp.forta.com/
"""

print(re.findall(r".+(?=:)", example))

example2 = "ABC01: $23.45" \
           "HGG42: $5.31" \
           "CFMX1: $899.00" \
           "XTC99: $69.96" \
           "Total items found: 4"

print(re.findall(r"(?<=\$)[0-9.]+", example2))
