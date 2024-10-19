package character;

import constants.characterParameters;
import monster.Monster;

public class Cleric extends Character{
	int mp;
	
//	コンストラクタ
	public Cleric(int index, String job, String key) {
		super(index, job, key, characterParameters.CLERIC_MAX_HP, characterParameters.CLERIC_HP);
		this.mp = characterParameters.CLERIC_MAX_MP;
	}
	
//	戦う
	public void attack(Monster m) {
		System.out.println(this.getFreename() + "は杖で叩いた！");
		System.out.println(m.getName() + "に1ポイントのダメージ");
		m.setHp(m.getHp() - 1);
	}
	
	/**
	 * スキル：セルフエイド
	 * 効果：指定したキャラクターを全回復させる
	 */
	public void selfAid() {
		System.out.println(this.getFreename() + "はセルフエイドを唱えた！");
		this.mp -= 5;
		this.setHp(this.getMaxhp());
		System.out.println("HPが最大まで回復した！");
	}
	
	/**
	 * スキル：祈る
	 * 効果：魔法使い自身のMPを回復する
	 */
	public void pray() {
		System.out.println(this.getFreename() + "は天に祈った！");
		
		this.mp += 5;
		System.out.println("MPが5回復した");
	}

}
