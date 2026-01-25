class Solution {

    public int binarySearch(int[] arr,int target){
        int n=arr.length;
        int l=0,r=n-1;
        
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return -1;
    }
}
