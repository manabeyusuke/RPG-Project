package common;

import java.util.Random;

public class Common {
	//ランダムな数値を1つ返すメソッド
	public static int getRandum(int num) {
		Random rand = new Random();
		int rn = rand.nextInt(num);
		
		return rn;
	}

}
