package Item;

import character.Character;

//アイテム：フルポーションクラス
public class FullPotion extends Item {
	
	// コンストラクタ
	public FullPotion(String name) {
		super(name, 1);
	}
	
	/** アイテム効果メソッド
	*【フルポーションの効果】
	* 選択したキャラクターを回復させる
	* 回復量：全回復
	*/
	public void effect(Character c) {
		System.out.println(c.getFreename() + "にフルポーションを使った");
		
		c.setHp(c.getMaxhp());
		System.out.println(c.getFreename() + "は全回復した。");
		this.setCount(getCount() - 1);
	}
}
