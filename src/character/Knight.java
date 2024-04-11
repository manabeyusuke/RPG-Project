package character;

import Constants.characterParameters;
import monster.Monster;

public class Knight extends Character{
	
	public Knight(String name) {
		super(name,characterParameters.KNIGHT_HP, "knight");
//		System.out.println(this.name + "(ジョブ：騎士)が誕生した。");
	}
	
	//戦う
	public void attack(Monster m) {
		System.out.println(this.getName() + "は剣を振り下ろした！");
		System.out.println(m.getName() + "に5ポイントのダメージ");
		m.setHp(m.getHp() - 5);
	}


}
