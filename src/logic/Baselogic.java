package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Item.FullPotion;
import Item.HighPotion;
import Item.Item;
import Item.Potion;
import character.Character;
import character.Cleric;
import character.Dancer;
import character.Hero;
import character.Knight;
import character.Thief;
import common.Common;
import monster.DeathBat;
import monster.Goblin;
import monster.Matango;
import monster.Monster;
import monster.Werewolf;

public class Baselogic {
	
	public static ArrayList<Character> characterMaking(Scanner scan) {
		ArrayList<Character> partyList = new ArrayList<Character>();
		int num = 1;
		
		System.out.println("キャラクターを選択してください(複数選択可。カンマ区切りで数字を入力。)");
		System.out.println("【1.勇者／2.騎士／3.魔法使い／4.盗賊／5.ダンサー】");

        String characterNo = scan.nextLine();		

		String[] characterList = characterNo.split(",");
		for (String cl : characterList) {
			switch(cl) {
			case "1":
				Character h = new Hero(num, "勇者", "hero");
				decideCharacterFreeName(h, scan);
				partyList.add(h);
				break;
			case "2":
				Character k  = new Knight(num, "騎士", "knight");
				decideCharacterFreeName(k, scan);
				partyList.add(k);
				break;
			case "3":
				Character c  = new Cleric(num, "魔法使い", "cleric");
				decideCharacterFreeName(c, scan);
				partyList.add(c);
				break;
			case "4":
				Character t = new Thief(num, "盗賊", "thief");
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
		
		System.out.println("パーティーを作成しました。");
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
			int num = Common.getRandum(4);
			
			switch(num) {
				case 0:
					Monster g = new Goblin("ゴブリン");
					monsterList.add(g);
					break;
				case 1:
					Monster m  = new Matango("毒キノコ");
					monsterList.add(m);
					break;
				case 2:
					Monster w  = new Werewolf("ウルフ");
					monsterList.add(w);
					break;
				case 3:
					Monster d = new DeathBat("デスバット");
					monsterList.add(d);
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
		System.out.println("------------------キャラクターの現在のHP------------------");
		for (Map.Entry<String, Character> entry : partyListMap.entrySet()) {
			if (entry.getKey() != null) {
				System.out.println(entry.getValue().getFreename() + " | HP:" + entry.getValue().getHp());
			}
		}
		System.out.println("=======================================================");
		System.out.println("------------------モンスターの現在のHP--------------------");
		for (Map.Entry<String, Monster> entry : monsterListMap.entrySet()) {
			if (entry.getKey() != null) {
				System.out.println(entry.getValue().getName() + " | HP:" + entry.getValue().getHp());
			}
		}
		System.out.println("");
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
	
	/** 
	 * ランダムに3つのアイテムを落として、最新のアイテムボックスを返すメソッド
	 * @param index アイテムボックス用インデックス
	 * @param itb アイテムボックス
	 * @return Map アイテムリスト
	 */
	public static void itemDropAndUpdateItembox(Map<String,Item>itb) {
		// 3つ落とす
		for (int i = 0; i < 3; i++) {
			int num = Common.getRandum(3);
			
			switch(num) {
				// ポーションをドロップ
				case 0:
					Item p = new Potion("ポーション", 1);
					System.out.println("ポーションを手に入れた。");
					addItemBox(itb,p);
					break;
				// ハイポーションをドロップ
				case 1:
					Item highP = new HighPotion("ハイポーション", 1);
					System.out.println("ハイポーションを手に入れた。");
					addItemBox(itb,highP);
					break;
				// フルポーションをドロップ
				case 2:
					Item fullP = new FullPotion("フルポーション", 1);
					System.out.println("フルポーションを手に入れた。");
					addItemBox(itb,fullP);
					break;
			}
		}
//		return itb;
	}
	
	/** ドロップしたアイテムをアイテムボックスに追加するメソッド
	 * @param itb アイテムボックスMap
	 * @param i ドロップしたアイテム
	 * 
	 * @return itb 最新のアイテムボックス
	 */
	public static void addItemBox(Map<String,Item>itb, Item i) {		
		if (itb.containsKey(i.getName())){
			// 既に持っているアイテムの場合は個数を1つ増やす
			int currentCount = itb.get(i.getName()).getCount();
			itb.get(i.getName()).setCount(currentCount + 1);
		} else {
			// 持っていないアイテムの場合は新規に追加する
			int idx = itb.size();
			i.setIndex(idx + 1);
			itb.put(i.getName(), i);
		}
	}
}
