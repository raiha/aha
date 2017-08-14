package raiha.aha;

/**
 * 拆分勾股数.
 * @author raiha
 */
public class Aha38 {
	
	/**
	 * 将给定的数字穷举拆分为3组,判断每组是否是勾股数.
	 */
	private static boolean check(int value){

		for (int a = 3; a <= value/3; a++) {
			int partB = value-a;
			for (int b = a+1; b <= partB/2; b++) {
				int c = partB - b;
				if( isGouGu(a, b, c) ){//是勾股数
					System.out.println(value + ":" + a + "," + b + "," + c);
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * 判断是否是勾股数.
	 */
	private static boolean isGouGu(int a, int b, int c){
		return a*a + b*b == c*c;
	}

	public static void main(String[] args) {
		
		long t = System.currentTimeMillis();
		
		int count = 0;
		
		for (int i = 0; i <=1000; i++) {
			if( check(i) ){
				count++;
			}
		}
		
		System.out.println(count);
		System.out.println("cost time:" + (System.currentTimeMillis()-t) + "ms");
	}
}
