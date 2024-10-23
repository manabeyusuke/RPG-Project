package common;

import java.util.Random;

public class Common {
	//ランダムな数値を1つ返すメソッド
	public static int getRandum(int num) {
		Random rand = new Random();
		int rn = rand.nextInt(num);
		
		return rn;
	}
	
	// 処理を一時的に止めるメソッド
	// モンスターの行動が連続で続くとコンソールが一気に流れて見づらいためその対策
	public static void sleepThread(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e){
	        e.printStackTrace();
	    }
	}

}
