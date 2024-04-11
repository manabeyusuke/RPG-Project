package character;

import Constants.characterParameters;
import monster.Monster;

public class Dancer extends Character{
	
	public Dancer(String name) {
		super(name, characterParameters.DANCER_HP, "dancer");
	}
	
	public void Dance() {
		System.out.println(this.getName() + "は情熱的に踊った！");
	}

	@Override
	public void attack(Monster m) {
		System.out.println(this.getName() + "の攻撃！");
		System.out.println("敵に3ポイントのダメージ");
		m.setHp(m.getHp() - 3);
	}

}
