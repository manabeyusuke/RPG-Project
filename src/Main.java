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
		
		//1.キャラクター選択
		System.out.println("キャラクターを選択してください(複数選択可。カンマ区切りで数字を入力。)");
		System.out.println("【1.勇者／2.騎士／3.魔法使い／4.盗賊】");
		Scanner scan = new Scanner(System.in);
        String characterNo = scan.nextLine();		
		scan.close();
		
		//2.ゲームスタート
		//選択したキャラクター番号を渡す
		Quest q = new Quest();
		ArrayList<Character> partyList = characterMaking(characterNo);
		
		int result = q.startQuest(partyList);
		
		//3. クリア or ゲームオーバーを表示(0：クリア／1：ゲームオーバー)
		if (result == 0) {
			System.out.println("★☆★☆★☆★☆★☆★☆GAME CLEAR★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			System.out.println("★☆★☆★☆★☆★☆Congratulations!!!!!!!★☆★☆★☆★☆★☆");
		} else {
			System.out.println("GAME OVER.....");
		}
	}
	
	public static ArrayList<Character>  characterMaking(String character) {
		ArrayList<Character> partyList = new ArrayList<Character>();

		String[] characterList = character.split(",");
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
			System.out.println(pl.name + " | HP:" + pl.hp);
		}
		return partyList;
	}

}
