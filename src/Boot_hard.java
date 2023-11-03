import java.util.Map;

public class Boot_hard extends Alter_base{
    Boot_hard(String name, int pv, double offence, double defence, Map<String, Integer[]> attack_list){
        super(name,pv, offence, defence, attack_list);
        actions.add("get information");
        actions.add("attack");
    }
    private void turn_in(Alter enemi){
        if ((this.pv<(this.life*0.25))){
            this.heal();
        }
        switch (this.actions.get(rand.nextInt(0,this.actions.size()))){
            case "get information":
                enemi.get_info();
                turn_in(enemi);
                break;
            case "attack":
                this.hit(enemi,this.attack_keys.get(rand.nextInt(0, this.attack_keys.size())));
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
