import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Item.Item;
import character.Character;
import logic.Baselogic;
import monster.Monster;

public class Quest {
	public int startQuest(ArrayList<Character> partyList, Scanner scan) {
		System.out.println("*――――――――――――――――――――――――――*");
		System.out.println("|                                                    |");
		System.out.println("|                     START QUEST                    |");
		System.out.println("|                                                    |");
		System.out.println("*――――――――――――――――――――――――――*");
		System.out.println("");
			
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
//		boolean isExitStage = false;
		String existMapKey = "";
		int monsterNo = 1;
		Item itm = new Item();
		
		// アイテムボックス用マップを作成
		Map<String, Item> itemBox = new HashMap<>();
		
		// キャラクター用マップを作成
		Map<String, Character> partyListMap = new HashMap<>();
		for (int i = 0; i < partyList.size(); i++) {
			partyListMap.put(partyList.get(i).getKeyname(), partyList.get(i));
		}
		
		// モンスター用マップを作成
		Map<String, Monster> monsterListMap = new HashMap<>();
		
		// TODO:ボス戦も実装予定
		// 全3ステージ
		while(stage < 4) {
			isEndBattle = false;
			System.out.println("---------------------ステージ" + stage + "----------------------");
			// モンスターを生成
			ArrayList<Monster> monsterList = Baselogic.createMonster();
			System.out.println("【モンスターが現れた！】");
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
				System.out.println("【 バ ト ル " + count + " 回 目 】");
				
				//行動するキャラクターをランダムに決める
				Character c = null;
				Monster m = null;
				
				// 誰に行動させるかを決めるため、存在するキーの中でランダムに1つ受け取る
				List<String> allMapKeyList = new ArrayList<>(partyListMap.keySet());
				allMapKeyList.addAll(monsterListMap.keySet());
				existMapKey = Baselogic.getRandumExistMapKey(allMapKeyList);
				
				// 誰に行動させるかを決める処理
				if (partyListMap.containsKey(existMapKey)) {
					// キャラクターMapのキーであればキャラクターの行動分岐に移る 
					c = partyListMap.get(existMapKey);
					// バトルの結果、死んだモンスターがいるかもしれないため、最新のマップ情報に洗い替え
					monsterListMap.putAll(characterAction(scan, c, monsterListMap, itm, itemBox));
					System.out.println("");
					System.out.println("======バ ト ル 終 了=======");
					System.out.println("");
					Baselogic.showCurrentHp(partyListMap, monsterListMap);
				} else {
					// モンスターの行動分岐に移る
					m = monsterListMap.get(existMapKey);
					// バトルの結果、死んだキャラクターがいるかもしれないため、最新のマップ情報に洗い替え
					partyListMap.putAll(monsterAction(partyListMap, m));
					System.out.println("");
					System.out.println("======バ ト ル 終 了=======");
					System.out.println("");
					Baselogic.showCurrentHp(partyListMap, monsterListMap);
				}
				if (partyListMap.isEmpty()) {
					// パーティーが全滅したらバトルもステージも終了してゲームオーバーにする
					return Constants.Massage.RTN_GAMEOVER;
				} else if (monsterListMap.isEmpty()) {
					isEndBattle = true;
					System.out.println("敵を全滅させた！");
					System.out.println("");
					// アイテムドロップ
					itemBox = new HashMap<>(Baselogic.itemDropAndUpdateItembox(itemBox));
				}
			}
		stage++;
		}
		if (partyListMap.isEmpty()) {
			// パーティーが全滅していたらゲームオーバー
			return Constants.Massage.RTN_GAMEOVER;
		} 
		return Constants.Massage.RTN_CLEAR;
	}
	
	/**
	 * キャラクター用の行動分岐メソッド
	 * @param scan
	 * @param c　キャラクター情報
	 * @param monsterListMap　モンスターのリスト
	 * @param keyList 
	 * @return モンスターマップ　最新のモンスターの数を返す
	 */
	public static Map<String, Monster> characterAction(Scanner scan, Character c, Map<String, Monster> monsterListMap, Item itm, Map<String, Item> ib) {		
		String targetMonsterKey = "";
		List<String> monsterMapKeyList = new ArrayList<>(monsterListMap.keySet());
		
		System.out.println(c.getFreeName() + "のターン");
	    System.out.println("【1：戦う／2：アイテム／3：逃げる】");
        String actionNo = scan.nextLine();

		switch(actionNo) {
		case "1":
			// TODO:キャラクター固有の技を選択できるようにする
			targetMonsterKey = Baselogic.getRandumExistMapKey(monsterMapKeyList);
			Monster targetMonster = monsterListMap.get(targetMonsterKey);
			c.attack(targetMonster);
			if (targetMonster.getHp() <= 0) {
				monsterListMap.remove(targetMonsterKey);
			}
			break;
		case "2":
			// TODO:アイテムを使えるようにする
			Baselogic.openItemBox(ib);
//			c.run();
			break;
		case "3":
			c.escape();
			break;
		}
		return monsterListMap;
	}
	
	/**
	 * モンスター用の行動分岐メソッド
	 * @param partyListMap パーティーメンバー
	 * @param m　行動するモンスター
	 */
	public static Map<String, Character> monsterAction(Map<String, Character> partyListMap, Monster m) {
		String targetCharacterKey = "";
		List<String> partyMapKeyList = new ArrayList<>(partyListMap.keySet());

		System.out.println(m.getName() + "のターン");
		targetCharacterKey = Baselogic.getRandumExistMapKey(partyMapKeyList);
		Character targetCharacter = partyListMap.get(targetCharacterKey);
		m.attack(targetCharacter);
		if (targetCharacter.getHp() <= 0) {
			partyListMap.remove(targetCharacterKey);
		}
		return partyListMap;
	}
}
