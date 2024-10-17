package Item;

import character.Character;

public class FullPotion extends Item {
	
	// コンストラクタ
	public FullPotion(String name, int count) {
		super(name, count);
	}
	
	/** 回復メソッド
	*【フルポーションの効果】
	* 選択したキャラクターを回復させる
	* 回復量：全回復
	*/
	public static void effect(Character c) {
		//回復量
		c.setHp(c.getMaxhp());
	}
}
