from sys import stdin, stdout
mod = 998244353
c0 = c1 = ca = cA = 1
cHash = 0

def main():
        T = int(input());
        for i in range(T):
            initForTest()
            solve()

def initForTest():
    global c0
    global c1
    global cA
    global ca
    global cHash
    c0 = c1 = ca = cA = 1
    cHash = 0

def solve():
    global c0
    global c1
    global cA
    global ca
    global cHash
    st = stdin.readline()
    findValue(st)
    res =  modInverse(power(4, cHash))
    c0 = (c0 * res ) % mod
    c1 = (c1 * res ) % mod
    ca = (ca * res ) % mod
    cA = (cA * res ) % mod
    print(f"{c0} {c1} {ca} {cA}")


def findValue(st = None):
    global c0
    global c1
    global cA
    global ca
    global cHash
    if(len(st) == 1):
        cHash+=1
        return

    stack = []
    for i in st:
        if i == '#':
            cHash+=1
        stack.append(i)
        if i == ')':
            stack.pop()
            ch1 = stack.pop()
            op = stack.pop()
            ch2 = stack.pop()
            stack.pop()
            calculate(ch1, op, ch2)
            stack.append('#')

def calculate(ch1, op, ch2):
    global c0
    global c1
    global cA
    global ca
    if op == '&':
        c0 = c1 + (4*c0) + (2*ca) + (2*cA)
        c1 = c1
        ca = c1 + (2*ca)
        cA = c1 + (2*cA)

    elif op == '|':
        c0 = c0
        c1 = 4*c1 + c0 + 2*ca + 2*cA
        ca = c0 + (2*ca)
        cA = c0 + (2*cA)

    elif op == '^':
        c0 = c0 + c1 + ca + cA
        c1 = c0
        ca = c0
        cA = c0

def power(x, y): 
  
    if(y == 0): return 1
    temp = power(x, int(y / 2))  
      
    if (y % 2 == 0): 
        return temp * temp 
    else: 
        if(y > 0): return x * temp * temp 
        else: return (temp * temp) / x 

def modInverse(a, m = mod) : 
    m0 = m 
    y = 0
    x = 1
  
    if (m == 1) : 
        return 0
  
    while (a > 1) : 
  
        # q is quotient 
        q = a // m 
  
        t = m 
  
        # m is remainder now, process 
        # same as Euclid's algo 
        m = a % m 
        a = t 
        t = y 
  
        # Update x and y 
        y = x - q * y 
        x = t 
  
  
    # Make x positive 
    if (x < 0) : 
        x = x + m0 
  
    return x

if __name__ == "__main__":
    main()