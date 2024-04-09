package monster;

import character.Hero;

public class Matango extends WalkingMonster{
	
	public Matango(String name) {
		this.name = name;
		this.hp = 5;
	}
	
	public void attack(Hero h) {
		System.out.println(this.name + "の攻撃！");
		System.out.println("10のダメージ");
		h.hp -= 10;
//		System.out.println("現在の" + h.name + "のHP：" + h.hp);
	}
}
