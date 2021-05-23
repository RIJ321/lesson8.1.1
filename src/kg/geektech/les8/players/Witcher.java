package kg.geektech.les8.players;

import kg.geektech.les8.game.RPG_Game;

public class Witcher extends Hero {
    public Witcher(int health, int damage) {
        super(health, damage, SuperAbility.SACRIFICE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (this != heroes[i] && heroes[i].getHealth() == 0) {
                heroes[i].setHealth(this.getHealth());
                System.out.println("Witcher sacrificed "
                        + heroes[i].getClass().getSimpleName()
                        + " by " + this.getHealth());
                this.setHealth(0);
                break;
            }
        }
    }
}
