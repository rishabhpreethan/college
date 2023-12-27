def char_stuffing():
    og_data = input("Enter the characters: ")
    print("Original data:\n", og_data)

    t_data = "dlestx" + "".join(["dle" + og_data[i] if og_data[i:i+3] == "dle" else og_data[i] for i in range(len(og_data))]) + "dleetx"

    print("\nTransmitted data:\n", t_data)

    recieve_data = "".join([t_data[i] if t_data[i:i+6] != "dledle" else t_data[i+3] for i in range(6, len(t_data)-6)])

    print("\nReceived data:\n", recieve_data)

if __name__ == "__main__":
    while True:
        print("\n 1. Character stuffing\n 2. Exit")
        choice = int(input("Enter choice: "))

        if choice == 1:
            char_stuffing()
        elif choice == 2:
            break
        else:
            print("\nInvalid option. Please re-enter.")
