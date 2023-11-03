import java.util.*;
public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static boolean c = true;
    public static void main(String[] args) {
        Map<String, Integer[]> attack = new HashMap<>();
        Integer[] ul = {15,5};
        attack.put("Ultralaser", ul);
        Integer[] pae = {1,1};
        attack.put("pistolet à eau", pae);
        Integer[] d = {1000,9};
        attack.put("Die", d);
        Alter perso1 = new Player("player", 25, 1, 1, attack);
        Alter perso2 = new Boot_hard("boot", 25,1.2,0.5, attack);
        while (c){
            perso1.turn(perso2);
            c = c & perso2.alive( );
            if (c){
                perso2.turn(perso1);
                c = c & perso1.alive();
            }
        }
    }

    public static String choose(ArrayList<String> choice){
        System.out.println("what do you want?");
        for(int i = 0; i < choice.size(); ++i) {
            System.out.println(i + " => " + choice.get(i));
        }
        System.out.println("> ");
        int m = scan.nextInt();
        if (m>=choice.size()) {
            return(choose(choice));
        }else{
            return(choice.get(m));
        }
    }
}