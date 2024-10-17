package character;

import Constants.characterParameters;
import monster.Monster;

public class Hero extends Character {
	
	//コンストラクタ
	public Hero(int index, String job, String key) {
		super(index, job, key, characterParameters.HERO_MAX_HP, characterParameters.HERO_HP);
	}
	
	//スーパーヒーロー用コンストラクター
//	public Hero(int index, String name) {
//		super(index, name, characterParameters.SUPER_HERO_MAX_HP, characterParameters.SUPER_HERO_HP);
//	}
	
	public void attack(Monster m) {
		System.out.println(this.getFreename() + "の攻撃！");
		m.setHp(m.getHp() - 5);
		System.out.println(m.getName() + "に5ポイントのダメージを与えた");
	}
	
	public void sleep() {
		this.setHp(100);
		System.out.println(this.getFreename() + "は、眠って回復した！");
	}
	
	public void sit(int sec) {
		this.setHp(this.getHp() + sec);
		System.out.println(this.getFreename() + "は、" + sec + "秒座った！");
		System.out.println("HPが" + sec + "ポイント回復した！");
	}
	
	public void slip() {
		this.setHp(this.getHp() - 5);
		System.out.println(this.getFreename() + "は転んだ！");
		System.out.println("5のダメージ！");
	}
	
	public void run() {
		System.out.println(this.getFreename() + "は逃げ出した！");
	}

}
