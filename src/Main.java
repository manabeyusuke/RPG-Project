import java.util.ArrayList;
import java.util.Scanner;

import character.Character;
import logic.Baselogic;

public class Main { 

	public static void main(String[] args) {
		System.out.println("*――――――――――――――――――――――――――*");
		System.out.println("|                                                    |");
		System.out.println("|              ◇◆◇JAVA　QUEST◇◆◇               |");
		System.out.println("|                                                    |");
		System.out.println("*――――――――――――――――――――――――――*");
		System.out.println("");
		Scanner scan = new Scanner(System.in);
		
		// 1.キャラクターメイキング
		ArrayList<Character> partyList = Baselogic.characterMaking(scan);
		
		// 2.ゲームスタート
		Quest q = new Quest();
		int result = q.startQuest(partyList, scan);
		
		// 3.クリア or ゲームオーバーを表示
		if (result == Constants.Massage.RTN_CLEAR) {
			System.out.println(Constants.Massage.CLEAR_MESSAGE);
		} else {
			System.out.println(Constants.Massage.GAMEOVER_MESSAGE);
		}
		System.out.println("");
		System.out.println("*――――――――――――――――――――――――――*");
		System.out.println("|                                                    |");
		System.out.println("|              ◇◆◇JAVA　QUEST 完◇◆◇            |");
		System.out.println("|                                                    |");
		System.out.println("*――――――――――――――――――――――――――*");
	}
}
