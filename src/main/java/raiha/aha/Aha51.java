package raiha.aha;


/**
 * 请问1~99999999之间有多少个合数只能被写成两个质数相乘的形式.
 * @author raiha
 */
public class Aha51 {

	/**
	 * 是否质数.
	 */
	private static boolean isPrime(long num) {
		if( num==2 ){
			return true;
		}
		if( num<2 || num%2==0 ){
			return false;
		}
	    for (int i=3; i*i<=num; i+=2){  
	        if (num%i==0){  
	            return false;
	        }
	    }
	    return true;  
	}  
	  
	/**
	 * 获取给定数字的上一个质数.
	 */
	private static long getPrePrime(long n){
		for (long i = n; i >2 ; i--) {
			if( isPrime(i) ){
				return i;
			}
		}
		throw new RuntimeException(""+n);
	}

	/**
	 * 计算给定范围的质数个数.
	 */
	private static int primeCount(int end) {
		boolean[] isPrime = new boolean[end + 1];
		for (int i = 3; i <= end; i += 2)
			isPrime[i] = true;
		
		isPrime[2] = true;
		
		for (int i = 3; i <= Math.sqrt(end); i += 2) {
			if (isPrime[i] == true) {
				for (int j = i * i; j <= end; j += 2 * i)
					isPrime[j] = false;
			}
		}
		
		int primeNum = 0;
		for (int i = 1; i <= end; i++) {
			if (isPrime[i] == true)
				primeNum++;
		}
		return primeNum;
	}
	
	private static void main(long max){
		
		//例如max是400, 那么其实就是找1-20之间的乘法值
		int calcCount = 0;//减去之前算过的质数
		
		int totalCount = 0;//最终有多少个质数相乘的合数
		
		for (long i = 2; i < Math.sqrt(max); i++) {
			if( isPrime(i) ){
				//找出对应的最大相乘质数
				long maxPrime = getPrePrime(max/i);
				int count = primeCount((int) maxPrime);//从2到xx的质数个数
				count -= calcCount;

				totalCount += (count);
				calcCount++;
				
				System.out.println(i + " * " + maxPrime + " = " + (i*maxPrime) + ", count:" + count);
			}
		}
		
		System.out.println(totalCount);
	}
	
	public static void main(String[] args) {
		long t = System.currentTimeMillis();
		
		main(99999999);
		
		System.out.println("cost " + (System.currentTimeMillis() - t) + "ms");//23783
	}
}
