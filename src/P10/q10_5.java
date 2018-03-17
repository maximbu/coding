package P10;

/**
 * Created by max on 12/29/2016.
 */
public class q10_5 {

    public static int sparseSearch(String[] s,String x){
        if(s == null || x == null || s.length == 0) return -1;
        return sparseSearch(s,x,0,s.length-1);
    }

    public static int sparseSearch(String[] s,String x,int start,int end) {
        if(end < start){
            return -1;
        }

        int mid = (start+end)/2;
        if(s[mid].equals(x)){
            return mid;
        }
        int origMid=mid;
        while(mid >= start && s[mid].isEmpty()){
            mid--;
        }
        if(mid<start){
            return sparseSearch(s,x,origMid+1,end);
        }

        if(s[mid].equals(x)) return mid;
        if(s[mid].compareTo(x)>0){
            return sparseSearch(s,x,start,mid-1);
        }
        return sparseSearch(s,x,mid+1,end);
    }




    public static void main(String[] st){
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(sparseSearch(stringList, "banana"));

    }

}
