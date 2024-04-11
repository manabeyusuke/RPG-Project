package monster;

public abstract class WalkingMonster extends Monster {
	
	public WalkingMonster(String name, int hp, String keyName) {
		super(name, hp, keyName);
	}
	
//	逃げるメソッド
	public void run() {
		System.out.println("トコトコ走って逃げた...");
	}
	
}
