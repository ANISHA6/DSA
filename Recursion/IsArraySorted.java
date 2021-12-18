//Method 1
public static boolean isSorted(int[] arr){
  if(arr.length==1){
    return true;
  }
  if(arr[0]>arr[1]){
    return false;
  }
  int[] a=new int[arr.length-1];
  for(int i=1;i<arr.length;i++){
  a[i-1]=arr[i];
  }
  return isSorted(a);
}


//Method 2

//using start index

public static boolean isSorted(int[] arr, int si){
  if(si==arr.length-1){
    return true;
  }
  if(arr[si]>arr[si+1]){
    return false;
  }
  return isSorted(arr,si+1);
}
  
