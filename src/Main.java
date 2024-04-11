import java.util.ArrayList;
import java.util.Scanner;

import character.Character;
import character.Cleric;
import character.Dancer;
import character.Hero;
import character.Knight;
import character.Thief;

public class Main { 

	public static void main(String[] args) {
		System.out.println("◆◇◆◇◆◇◆◇◆◇Java Questへようこそ◆◇◆◇◆◇◆◇◆◇");
		Scanner scan = new Scanner(System.in);
		
		// 1.キャラクターメイキング
		ArrayList<Character> partyList = characterMaking(scan);
		
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
		System.out.println("◆◇◆◇◆◇◆◇◆◇Java Quest 完◆◇◆◇◆◇◆◇◆◇");
	}
	
	public static ArrayList<Character>  characterMaking(Scanner scan) {
		ArrayList<Character> partyList = new ArrayList<Character>();
		
		System.out.println("キャラクターを選択してください(複数選択可。カンマ区切りで数字を入力。)");
		System.out.println("【1.勇者／2.騎士／3.魔法使い／4.盗賊／5.ダンサー】");
//		Scanner scan = new Scanner(System.in);
        String characterNo = scan.nextLine();		
//		scan.close();

		String[] characterList = characterNo.split(",");
		for (String cl : characterList) {
			switch(cl) {
			case "1":
				Character h = new Hero("勇者");
				partyList.add(h);
				break;
			case "2":
				Character k  = new Knight("騎士");
				partyList.add(k);
				break;
			case "3":
				Character c  = new Cleric("魔法使い");
				partyList.add(c);
				break;
			case "4":
				Character t = new Thief("盗賊");
				partyList.add(t);
				break;
			case "5":
				Character d = new Dancer("ダンサー");
				partyList.add(d);
				break;
			}
		}
		System.out.println("パーティーを作成しました。");
		for(Character pl : partyList) {
			System.out.println(pl.getName() + " | HP:" + pl.getHp());
		}
		System.out.println("");
		
		return partyList;
	}

}
