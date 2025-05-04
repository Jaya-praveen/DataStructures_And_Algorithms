package algorithms.searchalgo;

public class linearSearch {
    public static void main(String[] args){
        System.out.println(" Array :");
        int[] arr = {10,7, 8, 1,9, 5};
        int n = arr.length;
        //region linearsearch
//        System.out.println(linearSearch(arr,n,5));
        //endregion

        //region bilinearsearch
        System.out.println(bilinearSearch(arr,n,8));
        //endregion
    }
    public static int linearSearch(int[] arr,int n,int target){
        if(arr[n-1]==target){
            return n-1;
        }
        for(int i=0;i<n;i++){
            if(arr[i]==target){
                return i;
            }

        }
        return -1;
    }
  public static int bilinearSearch(int[] arr,int n,int target){
      if(arr[n-1]==target){
          return n-1;
      }
      int left =0,right=n-1;
      while(left<right){
          if(arr[left]==target){
              return left;
          }
          else if (arr[right]==target){
              return right;
              }
          else{
              left ++;
              right--;
          }
      }
      return -1;
  }

}
