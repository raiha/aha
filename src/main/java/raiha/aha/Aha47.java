package raiha.aha;

import java.util.ArrayList;
import java.util.List;

/**
 * 请问1~100000以内有多少对亲和数.
 * <p>
 * 亲和数(Amicable Pair)，又称亲和数、友爱数，指两个正整数中，彼此的全部约数之和（本身除外）与另一方相等.
 * 例如220与284：
 * 220的全部约数(除掉本身)相加是：1+2+4+5+10+11+20+22+44+55+110=284
 * 284的全部约数(除掉284本身)相加的和是：1+2+4+71+142=220
 * </p>
 * @author raiha
 */
public class Aha47 {
	
	//https://zh.wikipedia.org/wiki/%E7%9B%B8%E4%BA%B2%E6%95%B0
	
	public static void main(String[] args) 
    {
        int intMain = 2;
        int intBig = 100000;

        int count = 0;
        do
        {
            List<Integer> listYakuSu1 = findYakuSu(intMain);
            int intSum1 = addYakuSu(listYakuSu1);
            if(intSum1 == intMain)
            {
                System.out.println("self num:" + intSum1);
            }
            else
            {
                List<Integer> listYakuSu2 = findYakuSu(intSum1);
                int intSum2 = addYakuSu(listYakuSu2);
                if(intSum2 == intMain)
                {
                    System.out.println("love num:" + intMain + "--" + intSum1);
                    count++;
                }
            }
            intMain ++;
        } while(intMain <= intBig);
        
        System.out.println(count);
    }
    public static int addYakuSu(List<Integer> listYakuSu)
    {
        int sum = 0;
        for(int i : listYakuSu)
        {
            sum += i;
        }
        return sum;
    }
    public static List<Integer> findYakuSu(int intNum)
    {
        List<Integer> listYakuSu = new ArrayList<Integer>();
        listYakuSu.add (1);
        int intRoot = (int)Math.sqrt(intNum);
        for(int i = 2; i <= intRoot ; i++)
        {
            int intPart = intNum/i;
            if(intPart * i == intNum)
            {
                listYakuSu.add (i);
                if(intPart != i)
                {
                    listYakuSu.add (intPart);
                }
            }
        }
        return listYakuSu;
    }
}
