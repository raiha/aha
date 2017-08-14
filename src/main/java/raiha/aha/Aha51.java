package raiha.aha;

import java.util.ArrayList;
import java.util.List;

/**
 * 请问1~99999999之间有多少个合数只能被写成两个质数相乘的形式.
 * @author raiha
 */
public class Aha51 {
	private static boolean huiwen(int k)  //判断回文数  
	{  
	    int[] a = new int[10];
	    int i=0,j;  
	    while (k>0)  
	    {  
	        a[i]=k%10;  
	        k/=10;  
	        i++;  
	    }  
	    for (j=0; j<i; j++)  
	        if (a[j]!=a[i-j-1])  
	            return false;  
	    return true;  
	}  
	  
	  
	private static int hwlength(int k)  //计算回文数的长度  
	{  
		int[] a = new int[10];
	    int i=0;  
	    while (k>0)  
	    {  
	        a[i]=k%10;  
	        k/=10;  
	        i++;  
	    }  
	    return (i);  
	}  
	  
	  
	private static boolean isPrime(int k)  //判断质数  
	{  
	    int i;  
	    for (i=3; i*i<=k; i+=2)  
	        if (k%i==0)  
	            return false;  
	    return true;  
	}  
	  
	  
    /** 
     * 求 n 以内的所有素数 
     * 
     * @param n 范围 
     * 
     * @return n 以内的所有素数 
     */  
    private static List<Integer> getPrimes(int n) {  
        List<Integer> result = new ArrayList<Integer>();  
        result.add(2);  
   
        for (int i = 3; i <= n; i += 2) {  
            if (!divisible(i, result)) {  
                result.add(i);  
            }  
        }  
   
        return result;  
    }  
   
    /** 
     * 判断 n 是否能被整除 
     * 
     * @param n      要判断的数字 
     * @param primes 包含素数的列表 
     * 
     * @return 如果 n 能被 primes 中任何一个整除，则返回 true。 
     */  
    private static boolean divisible(int n, List<Integer> primes) {  
        for (Integer prime : primes) {  
            if (n % prime == 0) {  
                return true;  
            }  
        }  
        return false;  
    }  
	  
    /**
     * 约数个数
     * @param n
     * @return
     */
	private static int size(int n){  
		int N,i,r;  
		
        int s = 1;  
        for (i = 2; i * i <= n; i++) {  
            r = 0;  
            while (n % i == 0) {  
                r++;  
                n /= i;  
            }  
            if (r > 0) {  
                r++;  
                s *= r;  
            }  
        }  
        if (n > 1)  
            s *= 2;  
        
        return s;
	}  
	
	private static int getPrePrime(int n){
		for (int i = n; i >2 ; i--) {
			if( isPrime(i) ){
				return i;
			}
		}
		throw new RuntimeException(""+n);
	}
	
	private static void main(){
		
//		List<Integer> primes = getPrimes(99999999/2+1);
//		System.out.println(primes.size());
		
//		System.out.println(getPrePrime(99999999/2));
		System.out.println(size(49999996));
		/*
		int c = 0;
		for (int i = 1; i <= 99999999; i++) {
			int s = size(i);
			if( s<=4 ){
				c++;
			}
		}
		System.out.println(c);*/
	}
	
	public static void main(String[] args) {
		long t = System.currentTimeMillis();
		
		main();
		
		System.out.println("cost " + (System.currentTimeMillis() - t) + "ms");//23783
	}
}
