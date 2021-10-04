from collections import deque


class Stack:
    def __init__(self):
        self.q = deque()

    def push(self, val):
        self.q.append(val)
        for _ in range(len(self.q)):
            self.q.appendleft(self.q.pop())

    def top(self):
        return self.q[len(self.q) - 1]

    def pop(self):
        return self.q.pop()

    def empty(self):
        return 0 == len(self.q)

st = Stack()
st.push(1)
st.push(2)
st.push(3)
st.push(4)

print(st.top())
print(st.empty())
print(st.pop())
print(st.pop())
print(st.pop())
print(st.pop())
print(st.empty())
