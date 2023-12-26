def is_leap_year(year):
    return (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0)

def get_next_date(day, month, year):
    days_in_month = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    if is_leap_year(year):
        days_in_month[2] = 29

    if month < 1 or month > 12 or day < 1 or day > days_in_month[month]:
        return "Invalid date"
    day += 1

    if day > days_in_month[month]:
        day = 1
        month += 1

        if month > 12:
            month = 1
            year += 1

    return f"The next date is: {day:02d} {month:02d} {year:04d}"

date_input = input("Enter the date in the format dd mm yyyy: ")
day, month, year = map(int, date_input.split())

result = get_next_date(day, month, year)
print(result)
