package Algo;

import java.math.BigInteger;

public class ComplexCalculation {
    public static void main(String[] args) {
        ComplexCalculation c = new ComplexCalculation();
        System.out.println(c.calculateResult(BigInteger.TEN,BigInteger.TWO,BigInteger.TEN,BigInteger.TWO));
    }

    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result;
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
            Math.pow(2, 53
        */
        PowerCalculatingThread a = new PowerCalculatingThread(base1,power1);
        PowerCalculatingThread b = new PowerCalculatingThread(base2,power2);
        a.start();
        b.start();
        try {
            a.join(6000);
            b.join(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result = a.getResult().add(b.getResult());
        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
           /*
           Implement the calculation of result = base ^ power
           */
            for (int i = 0; i < power.intValue(); i++) {
                result = result.multiply(base);
            }
        }

        public BigInteger getResult() { return result; }
    }
}