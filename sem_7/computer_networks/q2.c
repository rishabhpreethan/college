#include <stdio.h>
#include <string.h>
struct node {
  int dist[20];
  int from[20];
} rt[10];

int main() {
  int dmat[20][20];
  int n, i, j, k, count = 0;
  printf("Enter The Number Of Nodes\n");
  scanf("%d", &n);
  printf("Enter The Cost Matrix\n");
  for (i = 0; i < n; i++)
    for (j = 0; j < n; j++) {
      scanf("%d", &dmat[i][j]);
      dmat[i][i] = 0;
      rt[i].dist[j] = dmat[i][j];
      rt[i].from[j] = j;
    }

  do {
    count = 0;
    for (i = 0; i < n; i++)
      for (j = 0; j < n; j++)
        for (k = 0; k < n; k++)
          if (rt[i].dist[j] > dmat[i][k] + rt[k].dist[j]) {
            rt[i].dist[j] = rt[i].dist[k] + rt[k].dist[j];
            rt[i].from[j] = k;
            count++;
          }
  } while (count != 0);
  for (i = 0; i < n; i++) {
    printf("\nState Value For Router %d Is\n", i);
    for (j = 0; j < n; j++) {
      printf("\t\tVia %d Distance %d\n", rt[i].from[j], rt[i].dist[j]);
    }
  }
}
