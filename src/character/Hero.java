package character;

import Constants.characterParameters;
import monster.Monster;

public class Hero extends Character {
	
	//コンストラクタ
	public Hero(String name) {
		super(name, characterParameters.HERO_HP, "hero");
//		System.out.println(this.name + "(ジョブ：勇者)が誕生した。");
	}
	
	//スーパーヒーロー用コンストラクター
	public Hero(String name, int hp) {
		super(name, hp, "superHero");
//		System.out.println(this.name + "(ジョブ：勇者)が誕生した。");
	}
	
	public void attack(Monster m) {
		System.out.println(this.getName() + "の攻撃！");
		m.setHp(m.getHp() - 5);
		System.out.println(m.getName() + "に5ポイントのダメージを与えた");
	}
	
	public void sleep() {
		this.setHp(100);
		System.out.println(this.getName() + "は、眠って回復した！");
	}
	
	public void sit(int sec) {
		this.setHp(this.getHp() + sec);
		System.out.println(this.getName() + "は、" + sec + "秒座った！");
		System.out.println("HPが" + sec + "ポイント回復した！");
	}
	
	public void slip() {
		this.setHp(this.getHp() - 5);
		System.out.println(this.getName() + "は転んだ！");
		System.out.println("5のダメージ！");
	}
	
	public void run() {
		System.out.println(this.getName() + "は逃げ出した！");
	}

}
