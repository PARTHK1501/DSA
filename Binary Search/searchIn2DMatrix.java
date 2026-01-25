//1st-Method with extra array

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m * n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[count++] = matrix[i][j];
            }
        }

        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == target)
                return true;
            else if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return false;
    }
}



//2nd-Method without using extra array


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0,high=(m*n)-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            int row=mid/n;
            int col=mid%n;
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return false;
    }
}