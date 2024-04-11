package monster;

import character.Character;

public abstract class Monster {
	private String name;
	private int hp;
	private String keyName;
	
	public Monster() {
		// デフォルトコンストラクター
	}
	
	public Monster (String name, int hp, String keyName) {
		this.name = name;
		this.hp = hp;
		this.keyName = keyName;
	}
	
	public String getName() {
		 return this.name;
	 }
	 
	 public void setName(String name) {
		 this.name = name;
	 }
	 
	 public int getHp() {
		 return this.hp;
	 }
	 
	 public void setHp(int hp) {
		 this.hp = hp;
	 }
	 
	 public String getKeyname() {
		 return this.keyName;
	 }
	 
	 public void setKeyname(String keyName) {
		 this.keyName = keyName;
	 }
	
	//逃げるメソッド
	public abstract void run();
	
	//攻撃するメソッド
	public abstract void attack(Character c);

}
