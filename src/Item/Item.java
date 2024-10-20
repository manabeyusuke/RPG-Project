package Item;

import character.Character;

public abstract class Item {
	private int index;
	private String name;
	private int count;
	
	public Item() {
		// 空のコンストラクタ
	}
	
	// コンストラクタ
	public Item(String name, int count) {
		this.name = name;
		this.count = count;
	}
	
	// setter
	public void setIndex(int index) {
		this.index = index;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	// getter
	public int getIndex() {
		return this.index;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCount() {
		return this.count;
	}
	
	/** 
	 *  抽象メソッド
	 *  アイテム効果メソッド
	 *  アイテム毎に実装する
	 */
	public abstract void effect(Character c);
}
