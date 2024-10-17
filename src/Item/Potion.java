package Item;

import character.Character;

public class Potion extends Item {
	
	// コンストラクタ
	public Potion(String name, int count) {
		super(name, count);
	}
	
	/** 回復メソッド
	*【ポーションの効果】
	* 選択したキャラクターを回復させる
	* 回復量：最大HPの3割
	*/
	public static void effect(Character c) {
		//回復量
		int valueOfHeal = 0;
		valueOfHeal = (int)Math.ceil(c.getMaxhp() / 3);
		
		c.setHp(c.getHp() + valueOfHeal);
	}
}
