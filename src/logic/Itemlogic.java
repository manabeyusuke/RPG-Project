package logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Item.Item;
import character.Character;

public class Itemlogic {
	
	/**
	 * アイテム使用メソッド
	 * @param scan
	 * @param ibMap アイテムボックスMap
	 * @param partyListMap パーティーメンバーMap
	 */
	
	public static void itemEffect(Scanner scan, Map<String, Item> ibMap, Map<String, Character> partyListMap) {
		Map<Integer,Character>partyListMapOfIndex = new HashMap<>();
		Map<Integer,Item>ibMapOfIndex = new HashMap<>();
		int itemIndex = 1;
		boolean isUseItem = false;
		boolean isExistNum = false;
		String selectItemName = "";
		
		// indexをキーにしてMapに詰め替える（キャラクターMap）
		for (Map.Entry<String, Character> entry : partyListMap.entrySet()) {
			partyListMapOfIndex.put(entry.getValue().getIndex(), entry.getValue());
		}
		// indexをキーにしてMapに詰め替える（アイテムMap）
		for (Map.Entry<String,Item> entry : ibMap.entrySet()) {
			ibMapOfIndex.put(entry.getValue().getIndex(), entry.getValue());
		}
		
		while(!isUseItem && !isExistNum) {
			System.out.println("【使用するアイテムを選択】");
			for (Map.Entry<Integer, Item> entry : ibMapOfIndex.entrySet()) {
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
			if (isUseItem && isExistNum) {
				// 1個以上持っているアイテム且つ、アイテムボックス内に存在する番号の場合、アイテム名を取得する
				selectItemName = ibMapOfIndex.get(itemIndex).getName();
			}
		}
		
		System.out.println("【誰に使用しますか？】");
		for (Integer key : partyListMapOfIndex.keySet()) {
			System.out.println(partyListMapOfIndex.get(key).getIndex() + "." 
					+ partyListMapOfIndex.get(key).getFreename() + " | " + "HP:" + partyListMapOfIndex.get(key).getHp());
		}
		int charIndex = scan.nextInt();
		
		int valueOfHeal = 0;
		switch(selectItemName) {
			case "ポーション":
				// キャラクターの最大HPの1/3を回復する
				valueOfHeal = (int)Math.ceil(partyListMapOfIndex.get(charIndex).getMaxhp() / 3);
				System.out.println(partyListMapOfIndex.get(charIndex).getFreename() + "にポーションを使った。");
				partyListMapOfIndex.get(charIndex).setHp(partyListMapOfIndex.get(charIndex).getHp() + valueOfHeal);
				// 所持数を1つ減らす
				ibMapOfIndex.get(itemIndex).setCount(ibMapOfIndex.get(itemIndex).getCount() - 1);
				checkLimitHp(partyListMapOfIndex.get(charIndex));
				break;
			case "ハイポーション":
				// キャラクターの最大HPの7割を回復する
				valueOfHeal = (int)Math.ceil(partyListMapOfIndex.get(charIndex).getMaxhp() * 0.7);
				System.out.println(partyListMapOfIndex.get(charIndex).getFreename() + "にハイポーションを使った。");
				partyListMapOfIndex.get(charIndex).setHp(partyListMapOfIndex.get(charIndex).getHp() + valueOfHeal);
				// 所持数を1つ減らす
				ibMapOfIndex.get(itemIndex).setCount(ibMapOfIndex.get(itemIndex).getCount() - 1);
				checkLimitHp(partyListMapOfIndex.get(charIndex));
				break;
			case "フルポーション":
				// キャラクターを全回復する
				System.out.println(partyListMapOfIndex.get(charIndex).getFreename() + "にフルポーションを使った。");
				partyListMapOfIndex.get(charIndex).setHp(partyListMapOfIndex.get(charIndex).getMaxhp());
				// 所持数を1つ減らす
				ibMapOfIndex.get(itemIndex).setCount(ibMapOfIndex.get(itemIndex).getCount() - 1);
				checkLimitHp(partyListMapOfIndex.get(charIndex));
				break;
			}
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
