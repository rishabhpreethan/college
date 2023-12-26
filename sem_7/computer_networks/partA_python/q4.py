# Leaky Bucket

def main():
    drop, bucket_level = 0, 0
    cap = int(input("Enter capacity : "))
    process = int(input("Enter processing rate : "))
    seconds = int(input("Enter number of seconds : "))

    inp = []
    for i in range(seconds):
        size = int(input(f"Enter size of packet at {i+1} second"))
        inp.append(size)
    print("\n Second | Packet Recieved | Packet Sent | Packet Left | Packet Dropped |")

    # process packets for each second
    for i in range(seconds):
        bucket_level += inp[i]
        if bucket_level > cap:
            drop = bucket_level - cap
            bucket_level = cap
            
        packet_sent = min(bucket_level, process)
        bucket_level -= packet_sent
        print(f"{i + 1} \t {inp[i]} \t\t {packet_sent} \t\t {bucket_level} \t\t {drop}")
        drop = 0
        
    # remaining packets
    while bucket_level:
        if bucket_level > cap:
            drop = bucket_level - cap
            bucket_level = cap
        packet_sent = min(bucket_level, process)
        bucket_level -= packet_sent
        print(f"{i + 1} \t 0 \t\t {packet_sent} \t\t {bucket_level} \t\t {drop}")
main()