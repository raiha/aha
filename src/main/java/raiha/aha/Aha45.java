package raiha.aha;

/**
 * 代码来源:http://blog.csdn.net/liuhaotian0520/article/details/7838430
 */
public class Aha45 {
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
	  
	  
	private static boolean prime(int k)  //判断质数  
	{  
	    int i;  
	    for (i=3; i*i<=k; i+=2)  
	        if (k%i==0)  
	            return false;  
	    return true;  
	}  
	  
	  
	private static int extend(int k)  //计算10的k次方，用于优化  
	{  
	    int i,s=1;  
	    for (i=0; i<k; i++)  
	        s*=10;  
	    return s;  
	}  
	  
	  
	private static int main(int a, int b)  {  
		int count = 0;
	    int i;  
	    for (i=a; i<=b; i++)  
	    {  
	        if (i%2==0&&i!=2)  
	            continue;  
	        if (i%5==0&&i!=5)  
	            continue;  
	        if (!huiwen(i))  
	            continue;  
	        if (hwlength(i)%2==0&&i!=11)  
	        {  
	            i=extend(hwlength(i));  
	            continue;  
	        }  
	        if (prime(i)){  
	        	System.out.println(i);
	        	count++;
	        }
	    }  
	    return count;  
	}  
	
	public static void main(String[] args) {
		long t = System.currentTimeMillis();
		
		System.out.println(main(2, 1000000));
		
		System.out.println("cost " + (System.currentTimeMillis() - t) + "ms");//23783
	}
}
