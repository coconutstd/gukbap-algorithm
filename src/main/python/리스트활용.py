from collections import defaultdict, Counter, OrderedDict

a = dict()

a = {}

a = {'key1': 'value1', 'key2': 'value2'}
a['key3'] = 'value3'
print(a)
print(a['key1'])
try:
    a['key4']
except KeyError:
    a['key4'] = 'value4'
print(a['key4'])

for k,v in a.items():
    print(k, v)

a = defaultdict(int)
a['A'] = 5
a['B'] = 4
print(a)
a['C'] += 1
print(a)

a = [1, 2, 3, 4, 5, 5, 5, 6, 6]
b = Counter(a)
print(type(b))
print(b.most_common(2))