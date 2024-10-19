package logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Item.Antidote;
import Item.FullPotion;
import Item.HighPotion;
import Item.Item;
import Item.Potion;
import character.Character;
import common.Common;

public class Itemlogic {
	/** 
	 * ランダムに3つのアイテムを落として、アイテムボックスを更新するメソッド
	 * @param index アイテムボックス用インデックス
	 * @param itb アイテムボックス
	 * @return Map アイテムリスト
	 */
	public static void itemDropAndUpdateItembox(Map<String,Item>itb) {
		// 3つ落とす
		for (int i = 0; i < 3; i++) {
			int num = Common.getRandum(4);
			
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
					// 解毒薬をドロップ
				case 3:
					Item antidote = new Antidote("解毒薬");
					System.out.println("解毒薬を手に入れた。");
					addItemBox(itb,antidote);
					break;
			}
		}
	}
	
	/** 
	 * ドロップしたアイテムをアイテムボックスに追加するメソッド
	 * @param itb アイテムボックスMap
	 * @param i ドロップしたアイテム
	 * 
	 * @return itb 最新のアイテムボックス
	 */
	public static void addItemBox(Map<String,Item>itb, Item i) {		
		if (itb.containsKey(i.getName())){
			// 既に持っているアイテムの場合は個数を1つ増やす
			itb.get(i.getName()).setCount(itb.get(i.getName()).getCount() + 1);
		} else {
			// 持っていないアイテムの場合は新規に追加する
			i.setIndex(itb.size() + 1);
			itb.put(i.getName(), i);
		}
	}
	
	/**
	 * アイテム使用メソッド
	 * @param scan
	 * @param ibMap アイテムボックスMap
	 * @param partyListMap パーティーメンバーMap
	 */
	public static void itemEffect(Scanner scan, Map<String,Item> ibMap, Map<String,Character> partyListMap) {
		Map<Integer,Character>partyListMapOfIndex = new HashMap<>();
		Map<Integer,Item>ibMapOfIndex = new HashMap<>();
		int itemIndex = 1;
		boolean isUseItem = false;
		boolean isExistNum = false;
		
		// indexをキーにしてMapに詰め替える（キャラクターMap）
		for (Map.Entry<String,Character> entry : partyListMap.entrySet()) {
			partyListMapOfIndex.put(entry.getValue().getIndex(), entry.getValue());
		}
		// アイテムを持っていたらindexをキーにしてMapに詰め替える（アイテムMap）
		if (ibMap != null) {
			for (Map.Entry<String,Item> entry : ibMap.entrySet()) {
				ibMapOfIndex.put(entry.getValue().getIndex(), entry.getValue());
			}
		}
		
		// 1つ以上持っているアイテム、もしくは存在する番号を選ぶまでループ
		while(!isUseItem && !isExistNum) {
			System.out.println("【使用するアイテムを選択】");
			for (Map.Entry<Integer,Item> entry : ibMapOfIndex.entrySet()) {
				System.out.println(entry.getValue().getIndex() + "." + entry.getValue().getName()
						+ "（所持数：" + entry.getValue().getCount() + "）");
			}
			itemIndex = scan.nextInt();
			if (ibMapOfIndex.get(itemIndex) != null) {
				isExistNum = true;
			} else if (!isExistNum) {
				System.out.println("※存在する番号を選択してください。");
				continue;
			}
			if (ibMapOfIndex.get(itemIndex).getCount() > 0) {
				isUseItem = true;
			} else if (!isUseItem) {
				System.out.println("※1つ以上持っているアイテムを選択してください。");
				isExistNum = false;
				continue;
			}
		}
		
		System.out.println("【誰に使用しますか？】");
		for (Integer key : partyListMapOfIndex.keySet()) {
			System.out.print(partyListMapOfIndex.get(key).getIndex() + "." 
					+ partyListMapOfIndex.get(key).getFreename() + " | " + "HP:" + partyListMapOfIndex.get(key).getHp());
			for (int i = 0; i < partyListMapOfIndex.get(key).getStatuslistsize(); i++) {
				System.out.print("【" + partyListMapOfIndex.get(key).getStatuslistOfindex(i) + "】");
			} System.out.println();
		}
		int charIndex = scan.nextInt();
		
		// 選択したアイテムの効果メソッドを呼び出す
		ibMapOfIndex.get(itemIndex).effect(partyListMapOfIndex.get(charIndex));
	}
	
	/**
	 * 回復後にキャラクターの最大HPを超えていないかチェックするメソッド
	 * @param c 回復したキャラクター
	 */
	public static void checkLimitHp(Character c) {
		if (c.getHp() > c.getMaxhp()) {
			c.setHp(c.getMaxhp());
		}
	}
}
