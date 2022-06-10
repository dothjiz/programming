package com.doth;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //checkDetailsAreValid("018-7654321", "AB11");
        checkDetailsAreValid("12-7654321", "AB11");
    }

    private static int sum(String s){
        final int[] WEIGHT = new int[]{ 7,3,1,5,2,4,8,6,1,6,5};
        final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int sum=0;
        for (int i = 0; i < s.length(); i++) {
            char xter = s.charAt(i);
            if(isDigit(xter)){
                sum += Character.getNumericValue(xter) * WEIGHT[i];
            }else {
                int index = ALPHABET.indexOf(xter);
                index = (index) + 10;
                sum += WEIGHT[i] * index;
            }
        }

        return sum;
    }

    private static int computeChecksum(int value){
        if(value % 2 == 0){
            return value % 89;
        }else {
            //int rem = value / 89;
            return 89 - (value % 89);
        }
    }

    private static boolean isDigit(char c){
        return Character.isDigit(c);
    }

    private static String[] explodeStr(String value, String delim){
        return value.split(delim);
    }

    public static String checkDetailsAreValid(String accountNumber, String bankCode) {
        String transDetails = null;
        String tmpAccountNumber = accountNumber.replaceAll("\\s", "");
        String tmpBankCode = bankCode.replaceAll("\\s", "");

        transDetails = tmpAccountNumber + tmpBankCode;

        if(!validateAccNumber(tmpAccountNumber)){
            return  "";
        }

        if(!validateBankCode(bankCode)){
            return  "";
        }

        String exldchecksum = explodeStr(transDetails, "-")[1];
        int sum = sum(exldchecksum);
        int checksum = computeChecksum(sum);
        System.out.println(checksum);
        return String.valueOf(checksum);
    }

    private static boolean validateAccNumber(String acc){
        if(acc != null && !acc.isEmpty()) {

            if(acc.startsWith(String.valueOf(0))){
                acc = acc.substring(1);
            }

            String[] xplode = explodeStr(acc, "-");
            if(xplode[0].length() != 2 && xplode[1].length() != 7){
                return false;
            }

            if(acc.charAt(2) == '-'){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    private static boolean validateBankCode(String acc){
        if(!Character.isDigit(acc.charAt(0)) && !Character.isDigit(acc.charAt(1)) && Character.isDigit(acc.charAt(2)) && Character.isDigit(acc.charAt(3)) ) {
           return  true;
        }
        return false;
    }



    private static int solution(int[] ranks){

        int[] weighing = new int[]{ 7,3,1,5,2,4,8,6,1,6,5};

                // write your code in Java SE 8
                Map<Integer, Integer> map = new HashMap<>();

                for (int i = 0; i < ranks.length; i++) {

                    if(map.containsKey(ranks[i])){
                        map.put(ranks[i], map.get(ranks[i])+1);
                    }else{
                        map.put(ranks[i], 1);
                    }
                }
                boolean[] r = new boolean[ranks.length];
                int sum=0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if(map.containsKey(entry.getKey() +1)){
                        System.out.println(entry.getKey() +1 + " " + map.get(entry.getKey() +1));
                        sum+=map.get(entry.getKey() +1);
                    }
                }

                return sum;





    }


    private static void fizz(int n){
        if(n > 0 && n < (2*(int) Math.pow(10, 5))) {
            for (int i = 1; i <= n; i++) {
                System.out.println((i % 3 == 0 && i % 5 == 0) ? "FizzBuzz" : (i % 3 == 0) ? "Fizz" : (i % 5 == 0) ? "Buzz" : i);
            }
        }
    }















}
