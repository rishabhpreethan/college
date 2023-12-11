m1_rows = int(input("Enter M1 rows: "))
m1_cols = int(input("Enter M1 columns: "))
m2_rows = int(input("Enter M2 rows: "))
m2_cols = int(input("Enter M2 columns: "))

if m1_cols == m2_rows:
    A = []
    print("Enter elements for Matrix A:")
    for i in range(m1_rows):
        row_A = []
        for j in range(m1_cols):
            k = int(input())
            row_A.append(k)
        A.append(row_A)

    B = []
    print("Enter elements for Matrix B:")
    for i in range(m2_rows):
        row_B = []
        for j in range(m2_cols):
            k = int(input())
            row_B.append(k)
        B.append(row_B)

    result = [[0 for _ in range(m2_cols)] for _ in range(m1_rows)]

    for i in range(len(A)):
        for j in range(len(B[0])):
            for k in range(len(B)):
                result[i][j] += A[i][k] * B[k][j]

    print("Matrix Multiplication Result:")
    for row in result:
        for element in row:
            if element != 0:
                print(element, end=" ")
        print()
else:
    print("Matrix Multiplication is not possible.")
