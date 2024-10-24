import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Item.Item;
import character.Character;
import common.Common;
import logic.Baselogic;
import logic.Itemlogic;
import monster.Monster;

public class Quest {
	public int startQuest(ArrayList<Character> partyList, Scanner scan) {
		System.out.println("*――――――――――――――――――――――――――*");
		System.out.println("|                                                    |");
		System.out.println("|                     START QUEST                    |");
		System.out.println("|                                                    |");
		System.out.println("*――――――――――――――――――――――――――*");
		System.out.println("");
		
		Common.sleepThread(2000); 
			
		//バトル開始
		int result = startBattle(partyList, scan);

		return result;
	}
	
	/**
	 * 戦闘メソッド
	 * @param partyList
	 * @param scan
	 * @return result バトル結果【0:クリア/1:ゲームオーバー】
	 */
	public static int startBattle(ArrayList<Character> partyList, Scanner scan) {
		int stage = 1;
		boolean isEndBattle = false;
		String existMapKey = "";
		
		// アイテムボックス用マップを作成
		Map<String,Item> itemBoxMap = new HashMap<>();
		
		// キャラクター用マップを作成
		Map<String,Character> partyListMap = new HashMap<>();
		for (int i = 0; i < partyList.size(); i++) {
			partyListMap.put(partyList.get(i).getKey(), partyList.get(i));
		}
		
		// モンスター用マップを作成
		Map<String,Monster> monsterListMap = new HashMap<>();
		
		// TODO:ボス戦も実装予定
		// 全3ステージ
		while(stage < 4) {
			int monsterNo = 1;
			isEndBattle = false;
			
			System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣️");
			System.out.println("                         ステージ" + stage                         );
			System.out.println("＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿️");
			
			Common.sleepThread(2000); 
			
			// モンスターを生成
			ArrayList<Monster> monsterList = Baselogic.createMonster();
			
			System.out.println("【モンスターが現れた！】");
			Common.sleepThread(2000); 
			
			for (Monster ml : monsterList) {
				System.out.println(ml.getName() + " | HP:" + ml.getHp());
			}
			System.out.println("-----------------------------------------------------------------");
			System.out.println("");
			Common.sleepThread(2000); 
			
			for (int i = 0; i < monsterList.size(); i++) {
				monsterListMap.put(monsterList.get(i).getKeyname() + monsterNo, monsterList.get(i));
				monsterNo++;
			}
			// パーティーもしくはモンスターが全滅するまでバトルを繰り返す
			int count = 0;
			while(!isEndBattle) {
				// バトル回数をカウント
				count++;
				System.out.println("【 バ ト ル " + count + " 回 目 】");
				
				// 行動するキャラクターをランダムに決める
				Character c = null;
				Monster m = null;
				
				// 誰に行動させるかを決めるため、存在するキーの中でランダムに1つ受け取る
				List<String> allMapKeyList = new ArrayList<>();
				for (Map.Entry<String,Character> entry : partyListMap.entrySet()) {
					if (entry.getValue().getHp() > 0) {
						allMapKeyList.add(entry.getValue().getKey());
					}
				}
				allMapKeyList.addAll(monsterListMap.keySet());
				existMapKey = Baselogic.getRandumExistMapKey(allMapKeyList);
				
				// 誰に行動させるかを決める処理
				if (partyListMap.containsKey(existMapKey)) {
					// キャラクターMapのキーであればキャラクターの行動分岐に移る 
					c = partyListMap.get(existMapKey);
					characterAction(scan, c, partyListMap, monsterListMap, itemBoxMap);
					System.out.println("");
					System.out.println("-----------------------------バトル終了----------------------------");
					System.out.println("");
					Common.sleepThread(3000); 
					Baselogic.showCurrentHp(partyListMap, monsterListMap);
				} else {
	            	// モンスターの行動分岐に移る
					m = monsterListMap.get(existMapKey);
					monsterAction(partyListMap, m);   
					System.out.println("");
					System.out.println("-----------------------------バトル終了----------------------------");
					System.out.println("");
					Common.sleepThread(3000); 
					Baselogic.showCurrentHp(partyListMap, monsterListMap);
				}
				if (partyListMap.isEmpty()) {
					// パーティーが全滅したらバトルもステージも終了してゲームオーバーにする
					return constants.Massage.RTN_GAMEOVER;
				} else if (monsterListMap.isEmpty()) {
					isEndBattle = true;
					System.out.println("敵を全滅させた！");
					System.out.println("");
					if (stage != 3) {
						// アイテムドロップ
						Itemlogic.itemDropAndUpdateItembox(itemBoxMap);
					}
				}
			}
		stage++;
		}
		if (partyListMap.isEmpty()) {
			// パーティーが全滅していたらゲームオーバー
			return constants.Massage.RTN_GAMEOVER;
		} 
		return constants.Massage.RTN_CLEAR;
	}
	
	/**
	 * キャラクター用の行動分岐メソッド
	 * @param scan
	 * @param c　キャラクター情報
	 * @param monsterListMap　モンスターのリスト
	 * @param itm 選択したアイテム
	 * @param ib アイテムボックス
	 * @return モンスターマップ　最新のモンスターの数を返す
	 */
	public static Map<String,Monster> characterAction(Scanner scan, Character c, Map<String,Character> partyListMap, Map<String,Monster> monsterListMap, Map<String,Item> ib) {		
		String targetMonsterKey = "";
		String actionNo = "";
		boolean isSelectAction = false;
		List<String> monsterMapKeyList = new ArrayList<>(monsterListMap.keySet());
		
		System.out.println(c.getFreename() + "のターン");
		while (!isSelectAction) {
			System.out.println("【1：戦う／2：アイテム／3：逃げる】");
	        actionNo = scan.nextLine();
	        if (actionNo.equals("1")) {
	        	if (c.getStatuslist("まひ")) {
	        		// まひ状態の場合は攻撃ができないため、行動選択を終了する
	        		System.out.println(c.getFreename() + "は痺れて動けない。");
	        		return monsterListMap;
	        	}
	        }
	        if (actionNo.equals("2")) {
	        	 // アイテムボックスが空の場合は行動を選び直す
	        	if (ib.isEmpty()) {
	        		System.out.println("アイテムを何も持っていません。");
	        		continue;
	        	} else {
	        		isSelectAction = true;
	        	}
	        } else {
	        	isSelectAction = true;
	        }
	     }
		
		switch(actionNo) {
			case "1":
				// TODO:キャラクター固有の技を選択できるようにする
				targetMonsterKey = Baselogic.getRandumExistMapKey(monsterMapKeyList);
				Monster targetMonster = monsterListMap.get(targetMonsterKey);
				c.attack(targetMonster);
				if (targetMonster.getHp() <= 0) {
					monsterListMap.remove(targetMonsterKey);
				}
				for (Map.Entry<String,Character> entry : partyListMap.entrySet()) {
					if (entry.getValue().getHp() > 0 && entry.getValue().getStatuslist("毒")) {
						// 毒状態のキャラクターのHPを-5する
						System.out.println(entry.getValue().getFreename() + "は毒のダメージを食らった。【HP-5】");
						entry.getValue().setHp(entry.getValue().getHp() - 5);
					}
				}	
				break;
			case "2":
				Itemlogic.useItem(scan, ib, partyListMap);
				break;
			case "3":
				c.escape();
				break;
			}
		Common.sleepThread(2000); 
		
		return monsterListMap;
	}
	
	/**
	 * モンスター用の行動分岐メソッド
	 * @param partyListMap パーティーメンバー
	 * @param m　行動するモンスター
	 */
	public static void monsterAction(Map<String,Character> partyListMap, Monster m) {
		String targetCharacterKey = "";
		List<String> partyMapKeyList = new ArrayList<>();
		// HPが0以上のキャラクターのkeyのみをセットする
		for (Map.Entry<String, Character> entry : partyListMap.entrySet()) {
			if (entry.getValue().getHp() > 0) {
				partyMapKeyList.add(entry.getKey());
			}
		}

		System.out.println(m.getName() + "のターン");
		
		// コンソールが一気に流れないように5秒止める
		Common.sleepThread(5000); 
		
		targetCharacterKey = Baselogic.getRandumExistMapKey(partyMapKeyList);
		Character targetCharacter = partyListMap.get(targetCharacterKey);
		m.attack(targetCharacter);
		if (targetCharacter.getHp() < 0) {
			System.out.println(targetCharacter.getFreename() + "は息絶えた....");
			partyListMap.get(targetCharacterKey).setHp(0);
		}
		
		// コンソールが一気に流れないように5秒止める
		Common.sleepThread(3000); 
	}
}
