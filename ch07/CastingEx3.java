package ch07;

class Animal {
	String name;
	void move() {
		System.out.println("동물아 움직어~");
	}
}

class Bird extends Animal {
	@Override
	void move() {
		name = "새";
		System.out.println(name + " 날아라");
	}
}

class Fish extends Animal {
	@Override
	void move() {
		name = "물고기";
		System.out.println(name + " 헤엄쳐라");
	}
}

class Cheetah extends Animal {
	@Override
	void move() {
		name = "치타";
		System.out.println(name + " 뛰어라");
	}
}




public class CastingEx3 {
	
	public static void main(String[] args) {
		Animal ani[] = new Animal[3];
		ani[0] = new Bird();
		ani[1] = new Fish();
		ani[2] = new Cheetah();
	
		// 공통적으로 가지고있는 메소드 move
		for(int i = 0; i < ani.length; i++) {
			ani[i].move();
		}
	}
}
