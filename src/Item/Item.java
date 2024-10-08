package Item;

import java.util.Map;

public class Item {
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
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	
	// getter
	public String getName() {
		return this.name;
	}
	
	public int getCount() {
		return this.count;
	}
	
	
	// アイテムボックス内のアイテムを表示するメソッド
	public void openItemBox(Map<String, Item> ib) {
		for (Map.Entry<String, Item> entry : ib.entrySet()) {
			System.out.print(entry.getValue().getName() + " : " + entry.getValue().getCount() + " | ");
			
			// アイテム3つ毎に改行する
			System.out.println(); 
		}
		
	}

}
