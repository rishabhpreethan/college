def check(day, month):
    if (month == 4 or month == 6 or month == 9 or month == 11) and day == 31:
        return 1
    else:
        return 0


def is_leap(year):
    if (year % 4 == 0 and year % 100 != 0) or year % 400 == 0:
        return 1
    else:
        return 0


def main():
    day, month, year, tomm_day, tomm_month, tomm_year = 0, 0, 0, 0, 0, 0
    flag = 'y'

    while flag == 'y':
        print("\nEnter today's date in the form of dd mm yyyy:")
        day, month, year = map(int, input().split())
        tomm_month, tomm_year = month, year

        if day < 1 or day > 31:
            print("Value of day not in the range 1...31")
            flag = 'n'

        if month < 1 or month > 12:
            print("Value of month not in the range 1...12")
            flag = 'n'
        elif check(day, month):
            print("Value of day not in the range day <= 30")
            flag = 'n'

        if year <= 1812 or year > 2015:
            print("Value of year not in the range 1812...2015")
            flag = 'n'

        if month == 2:
            if is_leap(year) and day > 29:
                print("Invalid date input for leap year")
                flag = 'n'
            elif not is_leap(year) and day > 28:
                print("Invalid date input for non-leap year")
                flag = 'n'

    if month == 12 and day == 31:
        print("The next day is out of the boundary value of year")
        tomm_year += 1
        tomm_month = 1
    else:
        if day < 31:
            tomm_day = day + 1
        else:
            tomm_day = 1
            tomm_month = month + 1

    if month == 2:
        if day < 28:
            tomm_day = day + 1
        elif is_leap(year) and day == 28:
            tomm_day = day + 1
        elif day == 28 or day == 29:
            tomm_day = 1
            tomm_month = 3

    print("Next day is: {} {} {}".format(tomm_day, tomm_month, tomm_year))


if __name__ == "__main__":
    main()
