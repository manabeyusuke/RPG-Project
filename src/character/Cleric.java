package character;

import Constants.characterParameters;
import monster.Monster;

public class Cleric extends Character{
	int mp;
	int maxHp = characterParameters.CLERIC_MAXHP;
	int maxMp = characterParameters.CLERIC_MAXMP;
	
//	コンストラクタ
	public Cleric(String name) {
		super(name, characterParameters.CLERIC_HP);
		this.mp = characterParameters.CLERIC_MP;
//		System.out.println(this.name + "(ジョブ：魔法使い)が誕生した。");
	}
	
//	戦う
	public void attack(Monster m) {
		System.out.println(this.name + "は杖で叩いた！");
		System.out.println("1ポイントのダメージ");
		m.hp -= 1;
	}
	
	/**
	 * スキル：セルフエイド
	 * 効果：指定したキャラクターを全回復させる
	 */
	public void selfAid() {
		System.out.println(this.name + "はセルフエイドを唱えた！");
		this.mp -= 5;
		this.hp += maxHp;
		System.out.println("HPが最大まで回復した！");
	}
	
	/**
	 * スキル：祈る
	 * 効果：魔法使い自身のMPを回復する
	 */
	public void pray() {
		System.out.println(this.name + "は天に祈った！");
		
		this.mp += 5;
		System.out.println("MPが5回復した");
	}

}
