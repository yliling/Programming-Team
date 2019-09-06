a, b, c, t = map(int, input().split())

x1 = 0
x2 = 0
x3 = 0

rest = 0

if t % a == 0:
    x1 = (int)(t / a)
    rest = t
elif t % b == 0:
    x2 = (int)(t / b)
    rest = t
elif t % c == 0:
    x3 = (int)(t / c)
    rest = t

while rest < t:
    temp = t - rest
    while temp > a and temp % a != 0:
        x2 = x2 + 1
        temp = temp - b
    if temp > a and temp % a == 0:
        x1 = (int)(temp / a)
        break
    x2 = 0
    x3 = x3 + 1
    rest = rest + c
    
if rest > t:
    print("IMPOSSIBLE")
else:
    print(str(x1) + " " + str(x2) + " " + str(x3))
    
