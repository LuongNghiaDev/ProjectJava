package Thuattoan;

public class SearchNhiPhan {
    //O(n)= 1, logn, trường hợp xấu: n
    public static int Search(int[] arr,int l,int r,int x){
        if(r >= l){
            int mid = l+(r-l)/2;

            if(arr[mid]==x){
                return mid;
            }
            if(arr[mid] > x){
                return Search(arr,l,mid-1,x);
            }
            return Search(arr,mid+1,r,x);
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,7,9};
        int n = arr.length;
        int x = 5;
        System.out.println(Search(arr,0,n-1,x));
    }
}
