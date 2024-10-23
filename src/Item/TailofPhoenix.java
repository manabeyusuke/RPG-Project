package Item;

import character.Character;

// アイテム：解毒薬クラス
public class TailofPhoenix extends Item {
	
	// コンストラクタ
	public TailofPhoenix(String name) {
		super(name,1);
	}
		
	/** アイテム効果メソッド
	*【フェニックスの尾の効果】
	* 選択したキャラクターを生き返らせる
	*/
	public void effect(Character c) {
		
		System.out.println(c.getFreename() + "にフェニックスの尾を使った。");
		System.out.println(c.getFreename() + "が生き返った。");
		
		// キャラクターをHPに最大HPの半分をセットする
		c.setHp((int)Math.ceil(c.getMaxhp() / 2));
		this.setCount(getCount() - 1);
	}
}
