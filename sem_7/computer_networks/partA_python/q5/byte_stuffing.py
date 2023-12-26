def char_stuffing():
    og_data = input("Enter the characters: ")

    print("Original data:")
    print(og_data)

    t_data = "dlestx"

    i = 0
    j = 6
    while i < len(og_data):
        if og_data[i:i+3] == "dle":
            t_data += "dle"
            i += 3
        t_data += og_data[i]
        i += 1

    og_length = len(t_data)
    og_length += 6  # dle-etx done
    t_data += "dleetx"

    print("\nTransmitted data:")
    print(t_data)

    recieve_data = ""

    i = 6
    while i < og_length - 6:
        if t_data[i:i+6] == "dledle":
            i += 3
        recieve_data += t_data[i]
        i += 1

    print("\nReceived data:")
    print(recieve_data)

if __name__ == "__main__":
    while True:
        print("\n 1. Character stuffing")
        print(" 2. Exit")
        choice = int(input("Enter choice: "))

        if choice == 1:
            char_stuffing()
        elif choice == 2:
            break
        else:
            print("\nInvalid option. Please re-enter.")
