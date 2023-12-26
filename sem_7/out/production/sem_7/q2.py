lock_price = 45.0
stock_price = 30.0
barrel_price = 25.0

total_locks = 0
total_stocks = 0
total_barrels = 0

locks = int(input("Enter the number of locks, and to exit press -1:\n"))

while locks != -1:
    c1 = (locks <= 0 or locks > 70)
    print("\nEnter the number of stocks and barrels:")
    stocks, barrels = map(int, input().split())
    c2 = (stocks <= 0 or stocks > 80)
    c3 = (barrels <= 0 or barrels > 90)

    if c1:
        print("\nValue of locks is not in the range of 1 to 70.")
    else:
        temp = total_locks + locks
        if temp > 70:
            print("New total locks = {} not in the range of 1 to 70.".format(temp))
        else:
            total_locks = temp
    print("Total locks =", total_locks)

    if c2:
        print("\nValue of stocks is not in the range of 1 to 80.")
    else:
        temp = total_stocks + stocks
        if temp > 80:
            print("New total stocks = {} not in the range of 1 to 80.".format(temp))
        else:
            total_stocks = temp
    print("Total stocks =", total_stocks)

    if c3:
        print("\nValue of barrels is not in the range of 1 to 90.")
    else:
        temp = total_barrels + barrels
        if temp > 90:
            print("New total barrels = {} not in the range of 1 to 90.".format(temp))
        else:
            total_barrels = temp
    print("Total barrels =", total_barrels)

    locks = int(input("\nEnter the number of locks, and to exit press -1:\n"))

print("\nTotal locks =", total_locks)
print("Total stocks =", total_stocks)
print("Total barrels =", total_barrels)

lock_sales = total_locks * lock_price
stock_sales = total_stocks * stock_price
barrel_sales = total_barrels * barrel_price
sales = lock_sales + stock_sales + barrel_sales
print("\nTotal sales =", sales)

if sales > 1800:
    com = 0.10 * 1000 + 0.15 * 800 + 0.20 * (sales - 1800)
elif sales > 1000:
    com = 0.10 * 1000 + 0.15 * (sales - 1000)
else:
    com = 0.10 * sales

print("Commission =", com)
