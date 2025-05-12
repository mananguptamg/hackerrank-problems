class ParkingSystem {
    private int[] space;

    public ParkingSystem(int big, int medium, int small) {
        space = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if (space[carType - 1] > 0) {
            space[carType - 1]--;
            return true;
        }
        else  return false;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        ParkingSystem ps = new ParkingSystem(1, 1, 0);
        System.out.println("null");
        System.out.println(ps.addCar(1));
        System.out.println(ps.addCar(2));
        System.out.println(ps.addCar(3));
        System.out.println(ps.addCar(1));
    }
}
