import java.util.*;

public class BinarySearchImplementation{
    public static int binarySearch(int[] arr,int target){
        if(arr==null||arr.length==0){
            System.out.println("Error: The array is empty or null.");
            return -1;
        }
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        try{
            System.out.print("Enter the number of elements: ");
            int n=sc.nextInt();
            int[] arr=new int[n];

            System.out.println("Enter "+n+" sorted integers: ");
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            System.out.print("Enter the target elements: ");
            if(!sc.hasNextInt()){
                System.out.println("Error: Target element must be an integer.");
                return;
            }
            int target=sc.nextInt();
            int result=binarySearch(arr, target);
            if(result == -1){
                System.out.println("Target element not found in the array.");
            }
            else{
                System.out.println("Target element found at index: "+result);
            }
        }
        catch(Exception e){
            System.out.println("Error: Invalid input. Please enter valid integers.");
        }
        finally{
            sc.close();
        }
    }
}