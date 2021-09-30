import re

example = "sales1.xls" \
          "orders3.xls" \
          "sales2.xls" \
          "sales3.xls" \
          "apac1.xls" \
          "europe2.xls" \
          "sam.xls" \
          "na1.xls" \
          "na2.xls" \
          "sa1.xls" \
          "ca1.xls"

# regex = "[ns]a.\.xls"
regex = "[ns]a[^0-9]\.xls"

obj = re.compile(regex)
print(obj.findall(example))
