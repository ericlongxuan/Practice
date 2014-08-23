"""
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

"""

class Solution:
    # @param tokens, a list of string
    # @return an integer
    def evalRPN(self, tokens):
        operator={
            "+": (lambda x,y : x+y),
            "-": (lambda x,y : x-y),
            "*": (lambda x,y : x*y),
            "/": (lambda x,y : self.devide(x, y))}

        s = []
        while tokens:
            t = tokens.pop(0)
            if t in operator:
                p2 = s.pop()
                p1 = s.pop()
                s.append(operator[t](p1, p2))
            else:
                s.append(int(t))
        return int(round(s[0]))

    def devide(self, p1, p2):
        if p1 >= 0 and p2 > 0 or p1 <= 0 and p2 < 0:
            return p1 / p2
        elif p1 < 0:
            return -(-p1 / p2)
        else:
            return -(p1 / -p2)
