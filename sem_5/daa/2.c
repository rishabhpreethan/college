#include<stdio.h>

void merge(int arr[], int s, int m, int e) {
  int temp[e - s + 1];
  int i = s, j = m + 1, k = 0; 
  while (i <= m && j <= e) {
    if (arr[i] <= arr[j]) {
      temp[k++] = arr[i++];
    } else {
      temp[k++] = arr[j++];
    }
  }

  while (i <= m) {
      temp[k++] = arr[i++];
  }
  
  while (j <= e) {
      temp[k++] = arr[j++];
  }

  for (int i = s; i <= e; i++) {
    arr[i] = temp[i-s];
  }
}

void ms(int arr[], int s, int e) {
  if (s < e) {
    int m = (s + e) / 2;
    ms(arr, s, m);
    ms(arr, m + 1, e);
    merge(arr, s, m, e);
  }
}


int main() {
  int arr[] = {4,0,3,1};
  int size = 4;
  ms(arr, 0, size - 1);
  for (int i = 0; i < size; i++) {
    printf("%d ", arr[i]);
  }
  return 0;
}