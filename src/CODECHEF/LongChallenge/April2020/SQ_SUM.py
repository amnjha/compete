def main():
    T = int(input())
    for _ in range(T):
        solve()


def solve():
    N = int(input())
    if sumSquare(N):
        print("Yes")
    else:
        print("No")

def sumSquare(n): 
    s = dict() 
    for i in range(n): 
        if i * i > n: 
            break
        s[i * i] = 1
        if (n - i * i) in s.keys():
            return True
    return False

main()