import java.util.Map;

public class Player extends Alter_base {
    Player(String name, int pv, double offence, double defence, Map<String, Integer[]> attack_list){
        super(name, pv, offence, defence, attack_list);
        actions.add("get information");
        actions.add("attack");
        actions.add("heal");
        actions.add("run away");
    }

    private void turn_in(Alter enemi){
        switch (Main.choose(this.actions)){
            case "get information":
                enemi.get_info();
                turn_in(enemi);
                break;
            case "attack":
                this.hit(enemi, Main.choose(this.attack_keys));
                break;
            case "run away":
                System.out.println(this.name + " ran away");
                Main.c = false;
                break;
            case "heal":
                this.heal();
                turn_in(enemi);
                break;
            default:
                System.out.println("bad input, retry");
                turn_in(enemi);
        }
    }

    @Override
    public void turn(Alter enemi) {
        System.out.println(this.name + "'s turn");
        this.turn_in(enemi);

    }

}
