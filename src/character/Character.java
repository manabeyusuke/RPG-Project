package character;

import java.util.ArrayList;
import java.util.List;

import monster.Monster;

public abstract class Character {
	private int index;
	private int maxHp;
	private int hp;
	private String job;
	private String key;
	private String freeName;
	private List<String> statusList; // 状態異常【毒、麻痺、催眠、混乱】
	
	public Character() {
		//空のコンストラクタ
	}
	
	 public Character(int index, String job, String key, int maxHp, int hp) {
		this.index = index;
		this.job = job;
		this.key = key;
		this.maxHp = maxHp;
		this.hp = hp;
		this.statusList = new ArrayList<>();
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
	 
	 public Boolean getStatuslist(String value) {
		 return this.statusList.contains(value);
	 }
	 
	 public String getStatuslistOfindex(int index) {
		 return this.statusList.get(index);
	 }
	 
	 public int getStatuslistsize() {
		 return this.statusList.size();
	 }
	 
	 public void setStatuslist(String status) {
		 this.statusList.add(status);
	 }
	 
	 public void removeStatuslist(String value) {
		 this.statusList.remove(this.statusList.indexOf(value));
	 }
	
	//逃げる
	public void escape() {
		System.out.println(this.freeName + "は逃げ出した");
	}
	
	//戦う
	public abstract void attack(Monster m);

}
