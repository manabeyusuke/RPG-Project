package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import character.Character;
import character.Cleric;
import character.Dancer;
import character.Hero;
import character.Knight;
import character.Thief;
import common.Common;
import monster.DeathBat;
import monster.ElectricRat;
import monster.Goblin;
import monster.Monster;
import monster.PoisonMatango;
import monster.Werewolf;

public class Baselogic {
	
	public static ArrayList<Character> characterMaking(Scanner scan) {
		ArrayList<Character> partyList = new ArrayList<Character>();
		int num = 1;
		
		System.out.println("キャラクターを選択してください(複数選択可。カンマ区切りで半角数字を入力。)");
		System.out.println("【1.勇者／2.騎士／3.魔法使い／4.盗賊／5.ダンサー】");

        String characterNo = scan.nextLine();		

		String[] characterList = characterNo.split(",");
		for (String cl : characterList) {
			switch(cl) {
			case "1":
				Hero h = new Hero(num, "勇者", "hero");
				decideCharacterFreeName(h, scan);
				partyList.add(h);
				break;
			case "2":
				Knight k  = new Knight(num, "騎士", "knight");
				decideCharacterFreeName(k, scan);
				partyList.add(k);
				break;
			case "3":
				Cleric c  = new Cleric(num, "魔法使い", "cleric");
				decideCharacterFreeName(c, scan);
				partyList.add(c);
				break;
			case "4":
				Thief t = new Thief(num, "盗賊", "thief");
				decideCharacterFreeName(t, scan);
				partyList.add(t);
				break;
			case "5":
				Character d = new Dancer(num, "ダンサー", "dancer");
				decideCharacterFreeName(d, scan);
				partyList.add(d);
				break;
			}
			num++;
		}
		
		System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣️");
		System.out.println("                       パーティーを作成しました                      ");
		System.out.println("＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿️");
		
		Common.sleepThread(3000); 
		
		for(Character pl : partyList) {
			System.out.println(pl.getFreename() + " | HP:" + pl.getHp());
		}
		System.out.println("");
		
		return partyList;
	}
	
	// キャラクター名を決めるメソッド
	public static void decideCharacterFreeName(Character c, Scanner scan) {
		System.out.println(c.getJob() + "の名前を決めてください。");
		c.setFreename(scan.nextLine());
	}
	
	/**
	 * モンスターを生成メソッド
	 * ランダムにモンスターを3体生成する
	 * 
	 * @return ArrayList モンスターリスト
	 */
	public static ArrayList<Monster> createMonster() {
		ArrayList<Monster> monsterList = new ArrayList<Monster>();
		
		// モンスターをランダムに3体生成する
		for(int i = 1; i < 4; i++) {
			int num = Common.getRandum(5);
			
			switch(num) {
				case 0:
					Goblin g = new Goblin("ゴブリン");
					monsterList.add(g);
					break;
				case 1:
					PoisonMatango m  = new PoisonMatango("毒キノコ");
					monsterList.add(m);
					break;
				case 2:
					Werewolf w  = new Werewolf("ウルフ");
					monsterList.add(w);
					break;
				case 3:
					DeathBat d = new DeathBat("デスバット");
					monsterList.add(d);
					break;
				case 4:
					ElectricRat e = new ElectricRat("でんきネズミ");
					monsterList.add(e);
					break;
			}
		}
		return monsterList;
	}
	
	/**
	 * 現在のHPを確認するメソッド
	 * デバッグ用
	 * @param partyListMap
	 * @param monsterListMap
	 */
	public static void showCurrentHp(Map<String, Character> partyListMap, Map<String, Monster> monsterListMap) {
		System.out.println("-----------------------キャラクターの現在のHP------------------------");
		Common.sleepThread(2000); 
		for (Map.Entry<String, Character> entry : partyListMap.entrySet()) {
			if (entry.getKey() != null && entry.getValue().getHp() > 0) {
				System.out.print(entry.getValue().getFreename() + " | HP:" + entry.getValue().getHp());
				for (int i = 0; i < entry.getValue().getStatuslistsize(); i++) {
					System.out.print("【" + entry.getValue().getStatuslistOfindex(i) + "】");
				}
				System.out.println();
			}
		}
		System.out.println("==================================================================");
		
		// コンソールが一気に流れないように3秒止める
		Common.sleepThread(3000); 
		System.out.println("------------------------モンスターの現在のHP-------------------------");
		Common.sleepThread(2000); 
		for (Map.Entry<String, Monster> entry : monsterListMap.entrySet()) {
			if (entry.getKey() != null) {
				System.out.println(entry.getValue().getName() + " | HP:" + entry.getValue().getHp());
			}
		}
		System.out.println("------------------------------------------------------------------");
		System.out.println("");
		
		// コンソールが一気に流れないように3秒止める
		Common.sleepThread(3000); 
	}
	
	/** Map内に存在するキーをランダムに返すメソッド
	 * @param list 現在生きているキャラクターとモンスターのkeyのリスト
	 * @return key キャラクターかモンスターのkey
	 */
	public static String getRandumExistMapKey (List<String> list) {
		String key = "";
		int rn = Common.getRandum(list.size());
		key = list.get(rn);
		
		return key;
	}
}
