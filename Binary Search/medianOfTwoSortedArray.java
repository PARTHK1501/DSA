class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[] merge=new int[m+n];
        int count = 0;

        int i=0,j=0;

        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                merge[count++] = nums1[i];
                i++;
            }else{
                merge[count++] = nums2[j];
                j++;
            }
        }

        if(i < m){
            while(i<m){
                merge[count++]=nums1[i++];
            }
        }else{
            while(j<n){
                merge[count++]=nums2[j++];
            }
        }

        int mid = merge.length / 2;
        if(merge.length % 2 == 0){
            return (double) (merge[mid-1]+merge[mid])/2;
        }

        return (double) (merge[mid]);
    }
}