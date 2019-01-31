package hackerRank.interviewPrep.DynamicProgramming;

public class Abbreviation {
    static String abbreviation2(String a, String b) {
        int i = 0;
        int j = 0;
        if(b.length()>a.length()) return "NO";
        while (i < a.length() && j < b.length()) {
            if (Character.toUpperCase(a.charAt(i)) == b.charAt(j)) {
                // i++ might be wrong , need to try both i and i++
                i++;
                j++;
                if(Character.isLowerCase(a.charAt(i-1))){
                    if(abbreviation2(a.substring(i),b.substring(j-1)).equals("YES")){
                        return "YES";
                    }
                }
            } else if (Character.isLowerCase(a.charAt(i))) {
                i++;
            } else {
                return "NO";
            }
        }
        while (i < a.length()) {
            if (Character.isLowerCase(a.charAt(i))) {
                i++;
            } else {
                return "NO";
            }
        }
        if (j < b.length()) {
            return "NO";
        }
        return "YES";
    }

    static String abbreviation(String a, String b) {
        boolean[][] isValid = new boolean[a.length()+1][b.length()+1];
        isValid[0][0] = true;
        boolean containsUppercase = false;
        for (int k = 0; k < a.length(); k++) {
            if (Character.isUpperCase(a.charAt(k))) {
                containsUppercase = true;
            }
            isValid[k+1][0] = !containsUppercase;
        }
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                boolean next = isValid[i][j + 1];
                if (a.charAt(i) == b.charAt(j)) {
                    next = isValid[i][j];
                }
                else if (Character.toUpperCase(a.charAt(i)) == b.charAt(j)) {
                    next = isValid[i][j] || isValid[i][j+1];
                }
                else if (Character.isUpperCase(a.charAt(i))) {
                    next = false;
                }
                isValid[i+1][j+1] = next;
            }
        }
        return isValid[a.length()][b.length()]? "YES" : "NO";
    }

    public static void main(String[] s) {
        System.out.println(abbreviation("daBcd"
                ,"ABC"));
        /*
        System.out.println(abbreviation("RDWPJPAMKGRIWAPBZSYWALDBLDOFLWIQPMPLEMCJXKAENTLVYMSJNRJAQQPWAGVcGOHEWQYZDJRAXZOYDMNZJVUSJGKKKSYNCSFWKVNHOGVYULALKEBUNZHERDDOFCYWBUCJGbvqlddfazmmohcewjg"
        ,"RDPJPAMKGRIWAPBZSYWALDBLOFWIQPMPLEMCJXKAENTLVYMJNRJAQQPWAGVGOHEWQYZDJRAXZOYDMNZJVUSJGKKKSYNCSFWKVNHOGVYULALKEBUNZHERDOFCYWBUCJG"));
        System.out.println(abbreviation("MBQEVZPBjcbswirgrmkkfvfvcpiukuxlnxkkenqp"
                ,"MBQEVZP"));
        System.out.println(abbreviation("DINVMKSOfsVQByBnCWNKPRFRKMhFRSkNQRBVNTIKNBXRSXdADOSeNDcLWFCERZOLQjEZCEPKXPCYKCVKALNxBADQBFDQUpdqunpelxauyyrwtjpkwoxlrrqbjtxlkvkcajhpqhqeitafcsjxwtttzyhzvh"
                ,"DINVMKSOVQBBCWNKPRFRKMFRSNQRBVNTIKNBXRSXADOSNDLWFCERZOLQEZCEPKXPCYKCVKALNBADQBFDQU"));
        */
        System.out.println(abbreviation("BFZZVHdQYHQEMNEFFRFJTQmNWHFVXRXlGTFNBqWQmyOWYWSTDSTMJRYHjBNTEWADLgHVgGIRGKFQSeCXNFNaIFAXOiQORUDROaNoJPXWZXIAABZKSZYFTDDTRGZXVZZNWNRHMvSTGEQCYAJSFvbqivjuqvuzafvwwifnrlcxgbjmigkms"
                ,"BFZZVHQYHQEMNEFFRFJTQNWHFVXRXGTFNBWQOWYWSTDSTMJRYHBNTEWADLHVGIRGKFQSCXNFNIFAXOQORUDRONJPXWZXIAABZKSZYFTDDTRGZXVZZNWNRHMSTGEQCYAJSF"));
        System.out.println(abbreviation("AQIUQVIPJDKYNEBPXFGVHCMFGvURORPRSTYQYJZCYJDNFRPRYTMZIsNDOJAOAGAEFRCDKUJBhdkedalbwoxxnoyowoxpdlelovibyiwat"
                ,"AQIUQVIPJDKYNEBPXFGVHCMFGURORPRSTYQYJZCYJDNFRPRYTMZINDOJAOAGAEFRCDKUJB"));
    }
}
