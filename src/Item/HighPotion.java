package Item;

import character.Character;

public class HighPotion extends Item {
	
	// コンストラクタ
	public HighPotion(String name, int count) {
		super(name, count);
	}
	
	// 回復メソッド
	/** 回復メソッド
	*【ポーションの効果】
	* 選択したキャラクターを回復させる
	* 回復量：最大HPの7割
	*/
	public void effect(Character c) {
		//回復量
		int valueOfHeal = 0;
		
		valueOfHeal = (int)Math.ceil(c.getHp() * 0.7);
		c.setHp(valueOfHeal);
	}
}
