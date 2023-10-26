// C++ program to print largest contiguous array sum using Kadane's algorithm
#include <bits/stdc++.h>
using namespace std;
 //function implementing kadane's algorithm
int maxSum(int arr[], int size)
{
    int max_till_now = INT_MIN, max_ending_here = 0;
 
    for (int i = 0; i < size; i++) {
        max_ending_here = max_ending_here + arr[i];
        if (max_till_now < max_ending_here)
            max_till_now = max_ending_here;
 
        if (max_ending_here < 0)
            max_ending_here = 0;
    }
    return max_till_now;
}
 
// Driver Code
int main()
{
    //n=size of array
    int n;
    //Taking input of array size
    cin>>n;
    
    int arr[n];
    //Taking input of array from user
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int answer= maxSum(arr, n);
    cout << "Maximum contiguous sum is " << answer;
    return 0;
}