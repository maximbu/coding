package P10;

/**
 * Created by max on 12/29/2016.
 */
public class q10_3 {
    public static int rotatedArraySearch(int[] a,int x){
        if(a.length == 0){
            return -1;
        }
        if(a.length == 1)
        {
            return a[0]==x?0:-1;
        }
        return rotatedArraySearch(a,x,0,a.length-1);
    }

    private static int rotatedArraySearch(int[] a,int x,int left,int right){
        int mid=(left+right)/2;
        if(a[mid] == x) return mid;
        if(a[left] == x) return left;
        if(a[right] == x) return right;
        if(left >= right) return -1;
        if(a[left]<a[mid]){
            if(a[left]>x){
                return rotatedArraySearch(a,x,mid,right);
            }
            return rotatedArraySearch(a,x,left,mid-1);
        }
        else if(a[left] == a[mid]){
            if(a[right]!=a[mid]){
                return rotatedArraySearch(a,x,mid,right);
            }
            else{
                int f= rotatedArraySearch(a,x,left,mid-1);
                if(f != -1) return f;
                return rotatedArraySearch(a,x,mid+1,right);
            }

        }
        else if(a[left]>a[mid]){	//a[left]>a[mid]
            if(a[left]<x){
                return rotatedArraySearch(a,x,left,mid-1);
            }
            return rotatedArraySearch(a,x,mid,right);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = { 2, 3, 1, 2, 2, 2, 2, 2 , 2 , 2 };
        int[] b = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        System.out.println(rotatedArraySearch(a, 2));
        System.out.println(rotatedArraySearch(a, 3));
        System.out.println(rotatedArraySearch(a, 4));
        System.out.println(rotatedArraySearch(a, 1));
        System.out.println(rotatedArraySearch(a, 8));
        System.out.println(rotatedArraySearch(b, 15));
        System.out.println(rotatedArraySearch(b, 5));
    }

}
