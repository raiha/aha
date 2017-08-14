package raiha.aha;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出所有能写成Pandigital数字乘积的数字之和.
 * @author raiha
 */
public class Aha62 {
	
	/**
	 * 递归全排列.
	 */
	public static void permutation1(String str, String result, int len, Set<Integer> nums) {

		// 结果 开始传入"" 空字符进入 len 是这个数的长度
		if (result.length() == len) { // 表示遍历完了一个全排列结果
			// System.out.println(result);
			int n = checkExpression(result);
			if( n!=-1 ){
				nums.add(n);
			}
		} else {
			for (int i = 0; i < str.length(); i++) {
				if (result.indexOf(str.charAt(i)) < 0) { // 返回指定字符在此字符串中第一次出现处的索引。
					// System.out.println("字母："+str.charAt(i));
					permutation1(str, result + str.charAt(i), len, nums);
				}
			}
		}
		
	}
	
	/**
	 * 判断是否符合 a * aaaa = aaaa 或者 aa * aaa = aaaa
	 * @param 9位的数字
	 */
	private static int checkExpression(String s){
		int n1 = Integer.parseInt(s.substring(0,1));
		int n2 = Integer.parseInt(s.substring(1,5));
		int n3 = Integer.parseInt(s.substring(5,9));
		
		if( n1*n2==n3 ){
			System.out.println(n1 + " * " + n2 + " = " + n3);
			return n3;
		}
		
		n1 = Integer.parseInt(s.substring(0,2));
		n2 = Integer.parseInt(s.substring(2,5));
		n3 = Integer.parseInt(s.substring(5,9));
		
		if( n1*n2==n3 ){
			System.out.println(n1 + " * " + n2 + " = " + n3);
			return n3;
		}
		
		return -1;
	}

	public static void main() {

		String s = "123456789";
		String result = "";

		Set<Integer> set = new HashSet<Integer>();

		permutation1(s, result, s.length(), set);
		
		int total = 0;

		for (Integer n : set) {
			total += n;
		}
		
		System.out.println(total);
	}
	
	public static void main(String[] args) {
		long t = System.currentTimeMillis();
		
		main();
		
		System.out.println("cost " + (System.currentTimeMillis() - t) + "ms");//23783
	}
}
