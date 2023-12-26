# Node class contains 2 things -> distance and previous node
class Node:
    def __init__(self, total_nodes) -> None:
        self.dist = [float('inf')] * total_nodes
        self.previousNode = [None] * total_nodes

def bf(total_nodes, cost):
    node = [Node(total_nodes) for _ in range(total_nodes)]
    # fill up adj matrix
    for i in range(total_nodes):
        for j in range(total_nodes):
            node[i].dist[j], node[i].previousNode[j] = cost[i][j], j
    # perform bf
    for _ in range(total_nodes - 1):
        for i in range(total_nodes):
            for j in range(total_nodes):
                for k in range(total_nodes):
                    if node[i].dist[j] > node[i].dist[k] + node[k].dist[j]:
                        node[i].dist[j] = node[i].dist[k] + node[k].dist[j]
                        node[i].previousNode[j] = k
    # print
    for i in range(total_nodes):
        print(f"State value for router {i} is")
        for j in range(total_nodes):
            print(f"Via {node[i].previousNode[j]} Distance {node[i].dist[j]}")


def main():
    total_nodes = int(input("Enter number of nodes : "))
    cost = [list(map(int, input().split())) for _ in range(total_nodes)]
    bf(total_nodes, cost)
main()