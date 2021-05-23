package kg.geektech.les8.players;

public class Berserk extends Hero {
    public Berserk(int health, int damage)   {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

    }
}
