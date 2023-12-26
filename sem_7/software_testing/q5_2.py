# Input dimensions of matrices
m1_rows = int(input("Enter M1 rows: "))
m1_cols = int(input("Enter M1 columns: "))
m2_rows = int(input("Enter M2 rows: "))
m2_cols = int(input("Enter M2 columns: "))

# Check if multiplication is possible
if m1_cols != m2_rows:
    print("Matrix Multiplication is not possible.")
else:
    # Input elements for Matrix A
    A = [[int(input()) for _ in range(m1_cols)] for _ in range(m1_rows)]

    # Input elements for Matrix B
    B = [[int(input()) for _ in range(m2_cols)] for _ in range(m2_rows)]

    # Perform matrix multiplication
    result = [[sum(A[i][k] * B[k][j] for k in range(m1_cols)) for j in range(m2_cols)] for i in range(m1_rows)]

    # Print the result
    print("Matrix Multiplication Result:")
    for row in result:
        print(*row)