import java.util.*;
import java.lang.Math;

public class SmithNumber {
	
	public static int[] primefactors(int n) {
		int parr[] = new int[20];
		int m = 0;
		while(n%2 == 0) {
			//System.out.println(2 + " ");
			parr[m] = 2;
			n /= 2;
			m += 1;
		}
		for(int i = 3; i < Math.sqrt(n); i += 2) {
			while(n%i == 0) {
				//System.out.println(i + " ");
				parr[m] = i;
				n /= i;
				m += 1;
			}
		}
		if(n > 2) {
			//System.out.println(n);
			parr[m] = n;
		}
		
		/*for(int i = 0; i < 20; i++) {
			if(parr[i] == 0) {
				break;
			}
			System.out.println("This is the prime numbers");
			System.out.println(parr[i]);
		}*/
		return parr;
	}
	
	public static int SumOfDigits(int n) {
		int sum = 0;
		while(n > 0) {
			int temp = n%10;
			sum += temp;
			n /= 10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		//Find the sum of the digits first
		int sum = 0;
		//SumOfDigits(n);
		sum = SumOfDigits(n);
		System.out.println("Sum of the digit is: "+ sum);
		
		//Now find the prime factors of the number
		int prime[] = new int[20];
		prime = primefactors(n);
		
		for(int i = 0; i < 20; i++) {
			if(prime[i] == 0) {
			break;
			}
			//System.out.println("This is the prime numbers");
			//System.out.println(prime[i]);
		}
		
		//Now find the prime number greater than 9 and find the sum of the digits
		for(int i = 0; i < 20; i++) {
			if(prime[i] != 0 && prime[i] > 9) {
				prime[i] = SumOfDigits(prime[i]);
			}
		}
		int psum = 0;
		for(int i = 0; i < 20; i++) {
			if(prime[i] != 0) {
				psum += prime[i];
			}
		}
		System.out.println("The sum of the digits of the prime numbers is: "+ psum);
		
		//Finally check if the sum of the digits and sum of the digits of prime numbers are equal
		if(psum == sum) {
			System.out.println("The number given is a Smith number");
		}
		else {
			System.out.println("The given number is not a prime number");
		}
	}

}
