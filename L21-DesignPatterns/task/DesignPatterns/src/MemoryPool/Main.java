package MemoryPool;

public class Main {
    public static void main(String[] args) {
        Gun gun = new Gun();
        System.out.println("Start");
//        gun.fire();
        gun.fireInPool();
        System.out.println("Game Over");
        System.out.println("Total bullet created: " + Bullet.count);;
    }
}
