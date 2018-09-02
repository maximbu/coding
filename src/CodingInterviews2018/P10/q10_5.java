package CodingInterviews2018.P10;

public class q10_5 {
    private static int sparseSearch(String[] s , String x){
        if(s == null || x==null || s.length == 0 || x.length() ==0) return -1;
        return sparseSearch(s,x,0,s.length-1);
    }

    private static int sparseSearch(String[] s , String x , int from , int to){
        if(from>to)  return -1;
        int mid = (from+to)/2;
        if(s[mid].equals(x)) return mid;
        int r = mid+1;
        int l = mid-1;
        while(r <= to){
            if(s[r].equals(x)) return r;
            if(s[r].length() == 0) r++;
            else break;
        }

        if (r==to || s[r].compareTo(x) >= 0) {
            return sparseSearch(s,x,from,l);
        } else {
            return sparseSearch(s,x,r,to);
        }
    }

    public static void main(String[] st){
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(sparseSearch(stringList, "flower"));

    }

}
