package character;

import monster.Monster;

public abstract class Character {
	private int index;
	private String job;
	private String key;
	private String freeName;
	private int maxHp;
	private int hp;
	
	public Character() {
		//空のコンストラクタ
	}
	
	 public Character(int index, String job, String key, int maxHp, int hp) {
		this.index = index;
		this.job = job;
		this.key = key;
		this.maxHp = maxHp;
		this.hp = hp;
	}
	 
	 public int getIndex() {
		 return this.index;
	 }
	 
	 public void setIndex(int index) {
		 this.index = index;
	 }
	 
	 public String getJob() {
		 return this.job;
	 }
	 
	 public void setJob(String job) {
		 this.job = job;
	 }
	 
	 public String getKey() {
		 return this.key;
	 }
	 
	 public void setKey(String key) {
		 this.key = key;
	 }
	 
	 public int getMaxhp() {
		 return this.maxHp;
	 }
	 
	 public void setMaxhp(int maxHp) {
		 this.maxHp = maxHp;
	 }
	 
	 public int getHp() {
		 return this.hp;
	 }
	 
	 public void setHp(int hp) {
		 this.hp = hp;
	 }
	 
	 public String getFreename() {
		 return this.freeName;
	 }
	 
	 public void setFreename(String freeName) {
		 this.freeName = freeName;
	 }
	
	//逃げる
	public void escape() {
		System.out.println(this.freeName + "は逃げ出した");
	}
	
	//戦う
	public abstract void attack(Monster m);

}
