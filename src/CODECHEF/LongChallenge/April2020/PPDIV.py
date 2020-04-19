MAX = int(1e18)
N = int(1e6 + 5)
MOD = int(1e9 + 7)

squareSet = set()
otherPowers = set()
pw_map = {}
pw_list_A = []
pw_list_B = []

def main():
        T = int(input())
        preComputePowers()
        for i in range(T):
            solve()

def solve():
    elem = int(input())
    if not pw_map.get(elem):
        pw_map[elem] = divSum(elem)
    
    print(pw_map[elem])

def preComputePowers():
    global pw_list_A
    global pw_list_B

    for i in range(1, N+1):
        sq = i*i
        if(sq < MAX):
            squareSet.add(sq)

        if i in squareSet:
            continue
        
        temp = i
        while sq <= (MAX//temp) :
            temp *= sq
            if(temp <= MAX):
                otherPowers.add(temp)

    pw_list_A = [a for a in sorted(squareSet)]
    pw_list_B = [b for b in sorted(otherPowers)]


def divSum(elem):
    sum = 0
    for key in pw_list_A:
        if(key > elem):
            break
        sum += ((elem//key)*key) % MOD

    for key in pw_list_B:
        if(key > elem):
            break
        sum += ((elem//key)*key) % MOD
    
    return int(sum)


main()