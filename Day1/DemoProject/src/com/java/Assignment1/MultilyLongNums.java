package com.java.Assignment1;

public class MultilyLongNums {
	public void multiply(String num1, String num2) {
        
        int[] productOfSum = new int[num1.length() + num2.length()];

        for(int i = num1.length() - 1; i >= 0; i--) {
            for(int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + productOfSum[p2];

                productOfSum[p1] += sum / 10;
                productOfSum[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : productOfSum) {
            if ((sb.length() == 0 && p == 0) == false) {
                sb.append(p);
            }
        }

                if(sb.length() == 0)
                {
                    System.out.println("0");
                }
                else
                {
                    System.out.println(sb.toString());
                }
    }

    public static void main(String[] args) {
        String num1 = "161";
        String num2 = "187";
        MultilyLongNums m = new MultilyLongNums();
        m  .multiply(num1, num2);
    }

}
