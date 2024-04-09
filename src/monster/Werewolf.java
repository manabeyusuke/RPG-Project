package monster;

import character.Hero;

public class Werewolf extends WalkingMonster {
	
//	コンストラクタ
	public Werewolf(String name) {
		this.name = name;
		this.hp = 5;
	}
	
//	攻撃するメソッド
	public void attack(Hero h) {
		System.out.println(this.name + "は噛み付いた！");
		System.out.println(h.name + "に3ポイントダメージ");
		h.hp -= 2;
	};

}
