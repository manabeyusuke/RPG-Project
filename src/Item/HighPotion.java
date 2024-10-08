package Item;

import character.Character;

public class HighPotion extends Item {
	
	// コンストラクタ
	public HighPotion(String name, int count) {
		super(name, count);
	}
	
	// 回復メソッド
	// キャラクターのMaxHPの7割回復する
	public void Heal(Character c) {
		//回復量
		int valueOfHeal = 0;
		
		valueOfHeal = (int)Math.ceil(c.getHp() / 3);
		c.setHp(valueOfHeal);
	}
}
