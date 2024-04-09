package character;

import Constants.characterParameters;
import monster.Monster;

public class Hero extends Character {
	
	//コンストラクタ
	public Hero(String name) {
		super(name, characterParameters.HERO_HP);
//		System.out.println(this.name + "(ジョブ：勇者)が誕生した。");
	}
	
	//スーパーヒーロー用コンストラクター
	public Hero(String name, int hp) {
		super(name, hp);
//		System.out.println(this.name + "(ジョブ：勇者)が誕生した。");
	}
	
	public void attack(Monster m) {
		System.out.println(this.name + "の攻撃！");
		m.hp -= 5;
		System.out.println("5ポイントのダメージを与えた");
	}
	
	public void sleep() {
		this.hp = 100;
		System.out.println(this.name + "は、眠って回復した！");
	};
	
	public void sit(int sec) {
		this.hp += sec;
		System.out.println(this.name + "は、" + sec + "秒座った！");
		System.out.println("HPが" + sec + "ポイント回復した！");
	};
	
	public void slip() {
		this.hp -= 5;
		System.out.println(this.name + "は転んだ！");
		System.out.println("5のダメージ！");
	};
	
	public void run() {
		System.out.println(this.name + "は逃げ出した！");
	};

}