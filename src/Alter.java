public interface Alter {
    boolean alive();
    void get_info();
    void turn(Alter enemi);
    void hit(Alter target, String attack);
    int aie(double damage);
    String get_name();
}
