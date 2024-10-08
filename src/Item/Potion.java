package Item;

import character.Character;

public class Potion extends Item {
	
	// コンストラクタ
	public Potion(String name, int count) {
		super(name, count);
	}
	
	// 回復メソッド
	// キャラクターのMAxHPの3割回復する
	public void Heal(Character c) {
		//回復量
		int valueOfHeal = 0;
		
		valueOfHeal = (int)Math.ceil(c.getHp() / 3);
		c.setHp(valueOfHeal);
	}
}
