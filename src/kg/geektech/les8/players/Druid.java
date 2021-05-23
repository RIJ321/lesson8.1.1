package kg.geektech.les8.players;

import kg.geektech.les8.game.RPG_Game;

public class Druid extends Hero {
    private int randomHelper;
    private boolean isHelpUsed;

    public Druid(int health, int damage) {
        super(health, damage, SuperAbility.HELPER);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (!isHelpUsed) {
            switch (randomHelper) {
                case 0:
                    randomHelper = RPG_Game.random.nextInt(3);
                    break;
                case 1:
                    System.out.println("Angel is came");
                    for (int i = 0; i < heroes.length; i++) {
                        if (heroes[i].getHealth() > 0 &&
                                heroes[i] instanceof Medic) {
                            ((Medic) heroes[i]).setHealPoints(
                                    ((Medic) heroes[i]).getHealPoints() * 2);
                        }
                    }
                    isHelpUsed = true;
                    break;
                case 2:
                    System.out.println("Crow is came");
                    if (boss.getOriginalHealth() / 2 > boss.getHealth()
                            && !boss.isStun()) {
                        boss.setDamage(boss.getDamage() * 2);
                        isHelpUsed = true;
                    }
                    break;
            }
        } else {
            switch (randomHelper) {
                case 1:
                    System.out.println("Angel thank you!");
                    for (int i = 0; i < heroes.length; i++) {
                        if (heroes[i].getHealth() > 0 &&
                                heroes[i] instanceof Medic) {
                            if (((Medic) heroes[i]).getHealPoints() !=
                                    ((Medic) heroes[i]).getOriginalHealPoints()) {
                                ((Medic) heroes[i]).setHealPoints(
                                        ((Medic) heroes[i]).getOriginalHealPoints());
                            }
                        }
                    }
                    isHelpUsed = true;
                    break;
                case 2:
                    System.out.println("Crow thank you!");
                    isHelpUsed = true;
                    if (boss.getDamage() != boss.getOriginalDamage()) {
                        boss.setDamage(boss.getOriginalDamage());
                    }
                    break;
            }
        }
    }
}
