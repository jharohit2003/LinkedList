package Array;
public class ZigZack {
    public static void main(String[] args) {
       int [] arr = zigZag(new int[]{4, 3 ,7 ,8, 6, 2, 1});
       for (int i : arr) {
        System.out.print(i+" ");
       }
    }
    public static int [] zigZag(int[] arr) {
        // code here
        int n = arr.length;
        if(n<=2){
            return  arr;
        }
        
        for(int i =0; i<n-2;i++){
            int j =i+1;
        int k = j+1;
            if(arr[i]>=arr[j]){
                int t = arr[i];
                arr[i]= arr[j];
                arr[j]=t;
            } 
            if(arr[j]>=arr[k]){
                int t = arr[k];
                arr[k]= arr[j];
                arr[j]=t;
            }
            
        }
        return arr;
    }
}
