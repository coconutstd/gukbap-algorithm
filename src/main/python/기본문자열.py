s = "hAcKeRaNk"
answer = ""
for ch in s:
    if ch.islower():
        answer += ch.upper()
    elif ch.isupper():
        answer += ch.lower()
    else:
        answer += ch

print(answer)

