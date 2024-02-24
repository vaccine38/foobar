# https://stackoverflow.com/a/74259249

def solution2(n):
    n = int(n)
    count = 0
    while n > 1:
        if n & 1 == 0:
            n >>= 1
        elif n & 2 and n != 3:
            n += 1
        else:
            n -= 1 # can also be: n &= -2
        count += 1
    return count

print(solution2("4"))
print(solution2("15"))
print(solution2("492148"))
print(solution2(str(10**309 - 1)))


