package Item;

import character.Character;

// アイテム：まひ消しクラス
public class Removalnumb extends Item {
		
	// コンストラクタ
	public Removalnumb(String name) {
		super(name, 1);
	}
	
	/** 
	* アイテム効果メソッド
	*【まひ消しの効果】
	* 選択したキャラクターのまひ状態を治す
	*/
	public void effect(Character c) {
		System.out.println(c.getFreename() + "にまひ消しを使った");
		
		// statusリストからまひを削除
		c.removeStatuslist("まひ");
		this.setCount(getCount() - 1);
	}

}
