class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans=0;
        for(int i=0;i<arr1.length;i++){
            int l=0,h=arr2.length-1;
            int a=1;
            while(l<=h){
                int m=l+(h-l)/2;
                if(Math.abs(arr2[m]-arr1[i])<=d){
                    a=0;
                    break;
                }
                else if(arr2[m]>arr1[i])h=m-1;
                else l=m+1;
            }
            ans+=a;
        }
        return ans;
    }
}
