package kg.geektech.les8.players;

import kg.geektech.les8.game.RPG_Game;

public class Thor extends Hero {
    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.STUN);
    }


    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        boss.setStun(RPG_Game.random.nextBoolean());

        if(boss.isStun()){
            System.out.println("Boss STUN!!!");
        }
    }
}
