package Item;

import character.Character;

// アイテム：ハイポーションクラス
public class HighPotion extends Item {
	
	// コンストラクタ
	public HighPotion(String name) {
		super(name, 1);
	}
	
	/** 
	* アイテム効果メソッド
	*【ハイポーションの効果】
	* 選択したキャラクターを回復させる
	* 回復量：最大HPの7割
	*/
	public void effect(Character c) {
		System.out.println(c.getFreename() + "にハイポーションを使った");
		
		int valueOfHeal = 0;
		valueOfHeal = (int)Math.ceil(c.getHp() * 0.7);
		c.setHp(valueOfHeal);
		this.setCount(getCount() - 1);
	}
}
