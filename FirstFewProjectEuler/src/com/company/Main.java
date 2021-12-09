package com.company;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Double u = 600851475143.0;
        int root = (int) Math.sqrt(u);
        ArrayList<Integer> sieve = sieve(root);
        Collections.reverse(sieve);

        for (Integer i : sieve ) {
            if (u % i == 0) {
                System.out.println(i);
                break;
            }
        }
        ArrayList<Integer> sieve2 = sieve(1000000);
    }

    public static ArrayList<Integer> sieve(int n)    {
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++)   {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true)   {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        ArrayList<Integer> sieve = new ArrayList<>();

        // Print all prime numbers
        for (int i = 2; i <= n; i++)  {
            if (prime[i] == true) {
                sieve.add(i);
                if (sieve.size() == 10001) {
                    System.out.println(sieve.get(10000));
                }
            }
        }
        return sieve;
    }
}
