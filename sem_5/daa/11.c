// SUM OF SUBSET

#include <stdio.h>
#include <stdlib.h>
// SubsetSum(arr, size, sum) = SubsetSum(arr, size-1, sum) || SubsetSum(arr, size-1, sum-arr[size-1])
// Base Cases:
// SubsetSum(arr, size, sum) = false, if sum > 0 and size == 0
// SubsetSum(arr, size, sum) = true, if sum == 0 

#define TRUE 1
#define FALSE 0
int include[50], arr[50], target, n;

int promising(int i, int currSum, int sum) {
    // if current_val + cummulative_sum >= target : possible answer
    // if wt == target (ans found) OR wt + next element <= target (possible answer found)
    return ((currSum + sum) >= target) && ((currSum == target) || (currSum + arr[i + 1] <= target));
}

void subset(int i, int currSum, int sum) {
    if (promising(i, currSum, sum)) {
        if (currSum == target) { // ans found
            printf("\n { \t");
            for (int j = 0; j <= i; j++) { // loop tricky
                if (include[j]) {
                    printf("%d \t", arr[j]);
                }
            }
            printf("} \n");
        } else {
            // include next
            include[i + 1] = TRUE;
            subset(i + 1, currSum + arr[i + 1], sum - arr[i + 1]);
            // not include
            include[i + 1] = FALSE;
            subset(i + 1, currSum, sum - arr[i + 1]);
        }
    }
}

int main() {
    int n, temp;
    int sum = 0;
    printf("Enter numbers : ");
    scanf("%d", &n);
    printf("Enter numbers to the set : ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
        sum += arr[i];
    }
    printf("Enter target : ");
    scanf("%d", &target);
    // sort
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= n; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    // actual calculation
    if (sum < target) printf("\n Not possible"); // cant happen
    else
    {
        // set include arr to 0 (init)
        for (int i = 0; i < n; i++) {
            include[i] = 0;
        }
        printf("Solution : \n");
        subset(-1, 0, sum);
    }
    return 0;
}