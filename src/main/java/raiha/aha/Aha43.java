package raiha.aha;

/**
 * 挑战 43 ： □3＊6528=3□＊8256.
 * @author raiha
 */
public class Aha43 {
	
	public static void main(String[] args) {
		
		//□3＊6528=3□＊8256
		for (int i = 1; i <= 9; i++) {
			if( (i*10+3)*6528 == (30+i)*8256 ){
				System.out.println(i);
				break;
			} 
		}
		
	}
}
