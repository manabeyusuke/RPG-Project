package monster;

import character.Character;

public class Werewolf extends WalkingMonster {
	
//	コンストラクタ
	public Werewolf(String name) {
		super(name, constants.monsterParameters.MATANGO_HP, "monster");
	}
	
//	攻撃するメソッド
	public void attack(Character c) {
		System.out.println(this.getName() + "は噛み付いた！");
		System.out.println(c.getFreename() + "に3ポイントダメージ");
		c.setHp(c.getHp() - 3);
	};

}
