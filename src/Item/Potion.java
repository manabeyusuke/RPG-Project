package Item;

import character.Character;

public class Potion extends Item {
	
	// コンストラクタ
	public Potion(String name, int count) {
		super(name, count);
	}
	
	/** 
	* アイテム効果メソッド
	*【ポーションの効果】
	* 選択したキャラクターを回復させる
	* 回復量：最大HPの3割
	*/
	public void effect(Character c) {
		System.out.println(c.getFreename() + "にポーションを使った");
		
		int valueOfHeal = 0;
		valueOfHeal = (int)Math.ceil(c.getMaxhp() / 3);
		c.setHp(c.getHp() + valueOfHeal);
		this.setCount(getCount() - 1);
	}
}
