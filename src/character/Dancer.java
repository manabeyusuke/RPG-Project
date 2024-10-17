package character;

import Constants.characterParameters;
import monster.Monster;

public class Dancer extends Character{
	
	public Dancer(int index, String job, String key) {
		super(index, job, key, characterParameters.DANCER_MAX_HP, characterParameters.DANCER_HP);
	}
	
	public void Dance() {
		System.out.println(this.getFreename() + "は情熱的に踊った！");
	}

	@Override
	public void attack(Monster m) {
		System.out.println(this.getFreename() + "の攻撃！");
		System.out.println(m.getName() + "に3ポイントのダメージ");
		m.setHp(m.getHp() - 3);
	}

}
