import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class Alter_base implements Alter{
    int pv;
    int soin = 1;
    final int life;
    final Random rand = new Random();
    public Map<String, Integer[]> attack_list;
    final ArrayList<String> attack_keys = new ArrayList<>(4);
    final ArrayList<String> actions = new ArrayList<>(4);
    public String name;
    final double offence;
    final double defence;
    Alter_base(String name, int pv, double offence, double defence, Map<String, Integer[]> attack_list){
        if ((offence>=1) && (offence<=2)){
            this.offence = offence;

        }else{
            System.out.println("error, la valeur d'offence doit être entre 1 et 2");
            this.offence = 1;
        }
        if ((defence<=1) && (defence>=0)){
            this.defence = defence;

        }else{
            System.out.println("error, la valeur de defence doit être entre 0 et 1");
            this.defence = 1;
        }
        this.name = name;
        this.pv = pv;
        this.life = pv;
        this.attack_list = attack_list;
        this.attack_keys.addAll(Arrays.asList(attack_list.keySet().toArray(new String[0])));
    }

    @Override
    public boolean alive() {
        return(this.pv>0);
    }

    @Override
    public void get_info() {
        System.out.println(this.name + " have " + this.pv + " pv");
    }

    void heal(){
        if (this.soin>0){
            this.pv += 10;
            System.out.println(this.name+" used his potion, he now have " + this.pv + " pv");
            this.soin -= 1;
            this.actions.remove("heal");
        }else{
            System.out.println("no potion left");
        }
    }
    @Override
    public void turn(Alter enemi) {
        System.out.println(this.name + "'s turn");
        System.out.println(this.name + "'s turn done");

    }

    @Override
    public void hit(Alter target, String attack) {
        System.out.println(this.name + " used " + attack + " on " + target.get_name());
        int i1 = rand.nextInt(1,11);
        if (i1<this.attack_list.get(attack)[1]){
            System.out.println("echec critique");
        }else if(i1 == 10){
            System.out.println("coup critique");
            System.out.println(target.get_name() + " have now only " + target.aie(this.attack_list.get(attack)[0]*this.offence*2) + " pv");

        }else{
            System.out.println("touche");
            System.out.println(target.get_name() + " have now only " + target.aie(this.attack_list.get(attack)[0]*this.offence) + " pv");
        }
    }

    @Override
    public int aie(double damage) {
        this.pv -= (int)(damage * this.defence);
        return(this.pv);
    }

    @Override
    public String get_name() {
        return this.name;
    }
}
