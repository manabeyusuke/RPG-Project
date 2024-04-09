import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import character.Character;
import common.Common;
import monster.DeathBat;
import monster.Goblin;
import monster.Matango;
import monster.Monster;
import monster.Werewolf;

public class Quest {
	public int startQuest(ArrayList<Character> partyList) {
		System.out.println("*************************************");
		System.out.println("*------------Start Quest------------*");
		System.out.println("*************************************");
		System.out.println("");
			
		//バトル開始
		startBattle(partyList);

		//TODO:クリア条件を追加
		//クエストクリア
		return Constants.Massage.CLEAR;
			
		//ゲームオーバー
		//return GAMEOVER;
	}
	
	public static void startBattle(ArrayList<Character> partyList) {
		//モンスターマップの開始インデックス
		int lastNumber = 0;
		
		//TODO:ボス戦も実装予定
		//TODO:全3ステージにする
//		for (int stage = 1; stage < 4; stage++) {
//			System.out.println("------ステージ" + stage + "-------");
		System.out.println("------ステージ1-------");
			//モンスターを生成
			ArrayList<Monster> monsterList = createMonster();
			System.out.println("<<<モンスターが現れた！>>>");
			for(Monster ml : monsterList) {
				System.out.println(ml.name + " | HP:" + ml.hp);
			}
			System.out.println("");
			
			//*******行動するキャラクターを決める処理*********
			//キャラクター用マップを作成
			Map<String, Character> partyListMap = new HashMap<>();
			for (int i = 0; i < partyList.size(); i++) {
				partyListMap.put(String.valueOf(i), partyList.get(i));
				lastNumber = i;
			}
			//モンスター用マップを作成
			Map<String, Monster> monsterListMap = new HashMap<>();
			for (int i = 0; i < monsterList.size(); i++) {
				monsterListMap.put(String.valueOf(lastNumber + i + 1), monsterList.get(i));
			}
			
			//ランダム数値を作成する範囲を決めるため、キャラクターとモンスターと数の合計を出す
//			int mapSize = partyListMap.size() + monsterListMap.size();
			
			//行動するキャラクターをランダムに決める
			Character c = null;
			Monster m = null;
			
//			Random rand = new Random();
//			int Index = rand.nextInt(mapSize);
			int Index = 0;
			 System.out.println(Index);
			
			if (Index <= lastNumber) {
				c = partyListMap.get(String.valueOf(Index));
			} else {
				m = monsterListMap.get(String.valueOf(Index));
			}
		    System.out.println(c != null ? c.name + "のターン" : m.name + "のターン");
		    System.out.println("【1：戦う／2：道具／3：逃げる】");
		    Scanner scan = new Scanner(System.in);
		    String actionNo = "";
	        if (scan.hasNextLine()) {
                // 入力した内容を取得する
                actionNo = scan.nextLine();
	        }
			scan.close();
			
			switch(actionNo) {
			case "1":
				c.attack(monsterListMap.get(String.valueOf(0)));
			case "2":
				c.run();
			case "3":
				c.run();
			}
		    
//		}
	}
	
	/**
	 * モンスターを生成メソッド
	 * ランダムにモンスターを3体生成する
	 */
	public static ArrayList<Monster> createMonster() {
		ArrayList<Monster> monsterList = new ArrayList<Monster>();
		
//		モンスターをランダムに3体生成する
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
}
