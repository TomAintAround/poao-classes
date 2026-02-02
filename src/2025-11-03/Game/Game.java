// Folha 4.2.2
// Exercício 5

import java.util.ArrayList;

abstract class Character {
	private String name;
	private int exp;
	private double strength;
	private double intel;
	private double speed;

	public Character(String name) {
		this.name = name;
		exp = (int) (Math.random() * 24) + 1;
	}

	public abstract String getInfo();

	public abstract void setAttributes();

	public void setStrength(double strength) {
		this.strength = strength;
	}

	public void setIntel(double intel) {
		this.intel = intel;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getName() {
		return name;
	}

	public int getExp() {
		return exp;
	}

	public double getStrength() {
		return strength;
	}

	public double getIntel() {
		return intel;
	}

	public double getSpeed() {
		return speed;
	}

	public void levelUp() {
		exp++;
	};
}

class Warrior extends Character {
	enum Weapon {
		Knife, Axe, Sword
	}

	private boolean hasArmor;
	private Weapon weapon;

	public Warrior(String name, boolean hasArmor, Weapon weapon) {
		super(name);
		this.hasArmor = hasArmor;
		this.weapon = weapon;
		setStrength(10);
		setSpeed(5);
		setIntel(3);
		for (int i = 0; i < getExp() - 1; i++) {
			setAttributes();
		}
	}

	@Override
	public String getInfo() {
		String result = "[Gerreiro: " + getName() + ", " + weapon + ", " + getExp() + ", " + getStrength() + ", "
				+ getSpeed() + ", " + getIntel() + "] ";
		return hasArmor ? result : "";
	}

	@Override
	public void levelUp() {
		super.levelUp();
		setAttributes();
	}

	@Override
	public void setAttributes() {
		setStrength(getStrength() * 1.20);
		setSpeed(getSpeed() * 1.10);
		setIntel(getIntel() * 1.05);
	}
}

class Mage extends Character {
	enum SeedType {
		Pumpkin, Watermelon, Apple
	}

	private SeedType seedType;
	private int seedsNum;

	public Mage(String name, SeedType seedType, int seedsNum) {
		super(name);
		this.seedType = seedType;
		this.seedsNum = seedsNum;
		setStrength(2);
		setSpeed(4);
		setIntel(9);
		for (int i = 0; i < getExp() - 1; i++) {
			setAttributes();
		}
	}

	@Override
	public String getInfo() {
		String result = "[Mago: " + getName() + ", " + seedsNum + ", " + getExp() + ", " + getStrength() + ", "
				+ getSpeed() + ", " + getIntel() + "] ";
		return seedType.equals(SeedType.Pumpkin) ? result : "";
	}

	@Override
	public void levelUp() {
		super.levelUp();
		setAttributes();
	}

	public void setAttributes() {
		setStrength(getStrength() * 1.05);
		setSpeed(getSpeed() * 1.10);
		setIntel(getIntel() * 1.20);
	}
}

class Mercenary extends Character {
	enum Weapon {
		Rocks, Bow, Pistol
	}

	private Weapon weapon;
	private int ammo;

	public Mercenary(String name, Weapon weapon, int ammo) {
		super(name);
		this.weapon = weapon;
		this.ammo = ammo;
		setStrength(4);
		setSpeed(10);
		setIntel(4);
		for (int i = 0; i < getExp() - 1; i++) {
			setAttributes();
		}
	}

	@Override
	public String getInfo() {
		String result = "[Mercenário: " + getName() + ", " + ammo + ", " + getExp() + ", " + getStrength() + ", "
				+ getSpeed() + ", " + getIntel() + "] ";
		return weapon.equals(Weapon.Bow) ? result : "";
	}

	@Override
	public void levelUp() {
		super.levelUp();
		setAttributes();
	}

	public void setAttributes() {
		setStrength(getStrength() * 1.08);
		setSpeed(getSpeed() * 1.20);
		setIntel(getIntel() * 1.08);
	}
}

class PoW {
	private ArrayList<Character> characterList;

	public PoW() {
		characterList = new ArrayList<>();
	}

	public void addCharacter(Character character) {
		characterList.add(character);
	}

	public void printImportant() {
		String result = "[\n";
		for (Character character : characterList) {
			result += character.getInfo();
		}
		result += "\n]";
		System.out.println(result);
	}

	public void levelUp() {
		for (Character character : characterList) {
			character.levelUp();
		}
	}
}

public class Game {
	public static void main(String[] args) {
		PoW game = new PoW();
		game.addCharacter(new Warrior("Gustav", true, Warrior.Weapon.Axe));
		game.addCharacter(new Warrior("Roger", false, Warrior.Weapon.Sword));
		game.addCharacter(new Mage("Gandalf", Mage.SeedType.Pumpkin, 10));
		game.addCharacter(new Mage("Christopher", Mage.SeedType.Watermelon, 5));
		game.addCharacter(new Mercenary("Shadow", Mercenary.Weapon.Pistol, 200));
		game.addCharacter(new Mercenary("Bullseye", Mercenary.Weapon.Bow, 50));
		game.printImportant();
		game.levelUp();
		game.printImportant();
	}
}
