package Item;

import character.Character;

// アイテム：解毒薬クラス
public class Antidote extends Item {
	
	// コンストラクタ
	public Antidote(String name) {
		super(name,1);
	}
		
	/** アイテム効果メソッド
	*【解毒薬の効果】
	* 選択したキャラクターの毒状態を治癒する
	*/
	public void effect(Character c) {
		System.out.println(c.getFreename() + "に解毒薬を使った。");
		
		// statusリストから毒を削除
		c.removeStatuslist("毒");
		this.setCount(getCount() - 1);
	}
}
