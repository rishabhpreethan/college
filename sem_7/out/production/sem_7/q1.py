check = True
while check:
    a, b, c = map(int, input().split())
    c1 = (a >= 1) and (a <= 10)
    c2 = (b >= 1) and (b <= 10)
    c3 = (c >= 1) and (c <= 10)

    if not c1:
        print("a is not in range")
    if not c2:
        print("b is not in range")
    if not c3:
        print("c is not in range")

    check = (not c1) or (not c2) or (not c3)

    if (a < b + c) and (b < a + c) and (c < a + b):
        if a == b == c:
            print("Equilateral triangle")
        elif a != b and b != c and c != a:
            print("Scalene triangle")
        else:
            print("Isosceles triangle")
    else:
        print("Triangle cannot be formed")
