public class IntegerSetTest {
    public static void main(String[] args) {
        IntegerSet set = new IntegerSet();

        set.add(5);
        set.add(3);
        set.add(1);
        set.add(3); // ซ้ำ จะไม่เพิ่ม

        System.out.println("Set: " + set); // {1, 3, 5}
        System.out.println("Size: " + set.size()); // 3

        set.remove(3);
        System.out.println("After remove 3: " + set); // {1, 5}
        System.out.println("Contains 1? " + set.contains(1)); // true
        System.out.println("Contains 3? " + set.contains(3)); // false
    }
}