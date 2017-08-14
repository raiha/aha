package raiha.aha;

/**
 * 请问1~100000000以内有多少个守形数.
 * @author raiha
 */
public class Aha48 {
	
	private static boolean check(long num){
		long num2 = num * num;
		
		long d = 10;
		while(true){
			long rem = num2 % d;
			if( rem==num2 ){
				break;
			}
			if( rem==num ){
				return true;
			}
			d *= 10;
		}
		return false;
	}
	
	private static void main(){
		
		int count = 0;
		for (long i = 1; i <= 100000000; i++) {
			if( check(i) ){
				count++;
				System.out.println(i + "*" + i + "=" + (i*i));
			}
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) {

		long t = System.currentTimeMillis();
		
		main();
		
		System.out.println(System.currentTimeMillis() - t);//23783
	}
}
