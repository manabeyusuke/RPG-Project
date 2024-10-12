package Item;

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
}
