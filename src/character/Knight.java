package character;

import Constants.characterParameters;
import monster.Monster;

public class Knight extends Character{
	
	public Knight(int index, String job, String key) {
		super(index, job, key, characterParameters.KNIGHT_MAX_HP, characterParameters.KNIGHT_HP);
//		System.out.println(this.name + "(ジョブ：騎士)が誕生した。");
	}
	
	//戦う
	public void attack(Monster m) {
		System.out.println(this.getFreename() + "は剣を振り下ろした！");
		System.out.println(m.getName() + "に5ポイントのダメージ");
		m.setHp(m.getHp() - 5);
	}


}
