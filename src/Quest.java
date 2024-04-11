import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	public int startQuest(ArrayList<Character> partyList, Scanner scan) {
		System.out.println("*************************************");
		System.out.println("*------------Start Quest------------*");
		System.out.println("*************************************");
		System.out.println("");
			
		//バトル開始
		int result = startBattle(partyList, scan);

		return result;
	}
	
	/**
	 * 戦闘メソッド
	 * @param partyList
	 */
	public static int startBattle(ArrayList<Character> partyList, Scanner scan) {
		int result = Constants.Massage.RTN_CLEAR;
		boolean isEndBattle = false;
		boolean isExitStage = false;
		String existMapKey = "";
		int monsterNo = 1;
		
		//キャラクター用マップを作成
		Map<String, Character> partyListMap = new HashMap<>();
		for (int i = 0; i < partyList.size(); i++) {
			partyListMap.put(partyList.get(i).getKeyname(), partyList.get(i));
		}
		
		//モンスター用マップを作成
		Map<String, Monster> monsterListMap = new HashMap<>();
		
		//TODO:ボス戦も実装予定
		while(!isExitStage) {
			for (int stage = 1; stage < 4; stage++) {
				isEndBattle = false;
				System.out.println("---------------------ステージ" + stage + "----------------------");
				//モンスターを生成
				ArrayList<Monster> monsterList = createMonster();
				System.out.println("<<<モンスターが現れた！>>>");
				for (Monster ml : monsterList) {
					System.out.println(ml.getName() + " | HP:" + ml.getHp());
				}
				System.out.println("--------------------------------------------------");
				System.out.println("");
				
				for (int i = 0; i < monsterList.size(); i++) {
					monsterListMap.put(monsterList.get(i).getKeyname() + monsterNo, monsterList.get(i));
					monsterNo++;
				}
				// パーティーもしくはモンスターが全滅するまでバトルを繰り返す
				int count = 0;
				while(!isEndBattle) {
					// バトル回数をカウント
					count++;
					System.out.println("バトル" + count + "回目");
					
					//行動するキャラクターをランダムに決める
					Character c = null;
					Monster m = null;
					
					// 行動するキャラクターを決めるため、存在するキーの中でランダムに1つ受け取る
					List<String> partyMapKeyList = new ArrayList<>(partyListMap.keySet());
					List<String> monsterMapKeyList = new ArrayList<>(monsterListMap.keySet());
					List<String> allMapKeyList = new ArrayList<>();
					allMapKeyList.addAll(partyMapKeyList);
					allMapKeyList.addAll(monsterMapKeyList);
					//System.out.println("allMapKeyList:" + allMapKeyList);
					existMapKey = getRandumExistMapKey(allMapKeyList);
					//System.out.println("existMapKey:" + existMapKey);
					
					// 誰に行動させるかを決める処理
					if (partyListMap.containsKey(existMapKey)) {
						// キャラクターMapのキーであればキャラクターの行動分岐に移る 
						c = partyListMap.get(existMapKey);
						monsterListMap.putAll(characterAction(scan, c, monsterListMap, monsterMapKeyList));
						System.out.println("");
						System.out.println("======バトル終了=======");
						System.out.println("");
						showCurrentHp(partyListMap, monsterListMap);
					} else {
						// モンスターの行動分岐に移る
						m = monsterListMap.get(existMapKey);
		
						partyListMap.putAll(monsterAction(partyListMap, m, partyMapKeyList));
						System.out.println("");
						System.out.println("======バトル終了=======");
						System.out.println("");
						showCurrentHp(partyListMap, monsterListMap);
					}
					if (partyListMap.isEmpty()) {
						// パーティーが全滅したらバトルもステージも終了してゲームオーバーにする
						isEndBattle = true;
						isExitStage = true;
						result = Constants.Massage.RTN_GAMEOVER;
					} else if (monsterListMap.isEmpty()) {
						isEndBattle = true;
						System.out.println("敵を全滅させた！");
						System.out.println("");
					}
				}
				// 全ステージが終わったらクリア判定を実施
				if (stage == 3) {
					if (partyListMap.isEmpty()) {
						// パーティーが全滅していたらゲームオーバー
						isEndBattle = true;
						isExitStage = true;
						result = Constants.Massage.RTN_GAMEOVER;
					} else {
						isExitStage = true;
					}
				}
			}
		}
		return result;
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
	
	/**
	 * キャラクター用の行動分岐メソッド
	 * @param c　キャラクター情報
	 * @param monsterListMap　モンスターのリスト
	 * @param num モンスターMapのインデックスはキャラクターの数分ずらしている
	 * @return モンスターマップ　最新のモンスターの数を返す
	 */
	public static Map<String, Monster> characterAction(Scanner scan, Character c, Map<String, Monster> monsterListMap, List<String> keyList) {		
		String targetMonsterKey = "";
		
		System.out.println(c.getName() + "のターン");
	    System.out.println("【1：戦う／2：道具／3：逃げる】");
        String actionNo = scan.nextLine();

		switch(actionNo) {
		case "1":
			targetMonsterKey = getRandumExistMapKey(keyList);
			Monster targetMonster = monsterListMap.get(targetMonsterKey);
			c.attack(targetMonster);
			if (targetMonster.getHp() <= 0) {
				monsterListMap.remove(targetMonsterKey);
			}
			break;
		case "2":
			//TODO:アイテムを使えるようにする
			c.run();
			break;
		case "3":
			c.run();
			break;
		}
		return monsterListMap;
	}
	
	/**
	 * モンスター用の行動分岐メソッド
	 * @param partyListMap
	 * @param m
	 */
	public static Map<String, Character> monsterAction(Map<String, Character> partyListMap, Monster m, List<String> keyList) {
		String targetCharacterKey = "";

		System.out.println(m.getName() + "のターン");
		targetCharacterKey = getRandumExistMapKey(keyList);
		Character targetCharacter = partyListMap.get(targetCharacterKey);
		m.attack(targetCharacter);
		if (targetCharacter.getHp() <= 0) {
			partyListMap.remove(targetCharacterKey);
		}
		return partyListMap;
	}
	
	public static int checkResult(Map<String, Character> partyListMap, Map<String, Monster> monsterListMap) {
		if (partyListMap == null) {
			// パーティーが全滅したらゲームオーバー
			return Constants.Massage.RTN_GAMEOVER;
		} else {
			// モンスターが全滅したらゲームクリア
			return Constants.Massage.RTN_CLEAR;
		}
	}
	
	/**
	 * 現在のHPを確認するメソッド
	 * デバッグ用
	 * @param partyListMap
	 * @param monsterListMap
	 */
	public static void showCurrentHp(Map<String, Character> partyListMap, Map<String, Monster> monsterListMap) {
		System.out.println("----キャラクターの現在のHP----");
		for (Map.Entry<String, Character> entry : partyListMap.entrySet()) {
			if (entry.getKey() != null) {
				System.out.println(entry.getValue().getName() + " | HP:" + entry.getValue().getHp());
			}
		}
		System.out.println("==========================");
		System.out.println("-----モンスターの現在のHP-----");
		for (Map.Entry<String, Monster> entry : monsterListMap.entrySet()) {
			if (entry.getKey() != null) {
				System.out.println(entry.getValue().getName() + " | HP:" + entry.getValue().getHp());
			}
		}
		System.out.println("");
	}
	
	// Map内に存在するキーをランダムに返すメソッド
	public static String getRandumExistMapKey (List<String> list) {
		String key = "";
		int size = list.size();
		int rn = Common.getRandum(size);
		key = list.get(rn);
		
		return key;
	}
}
