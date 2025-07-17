/**
 * ADT ที่เก็บจำนวนเต็มแบบไม่ซ้ำกันและเรียงลำดับจากน้อยไปมาก
 */
public class IntegerSet {
    private String s; // ตัวแทนภายในของเซต เช่น "1 3 5"

    // Rep Invariant (RI):
    //  - s ไม่มีเลขซ้ำ
    //  - เลขใน s เรียงลำดับจากน้อยไปมาก และคั่นด้วยช่องว่าง
    //
    // Abstraction Function (AF):
    //  - AF(s) = เซตของจำนวนเต็มใน s ที่แปลงจาก String เป็น int แต่ละตัว

    /**
     * Constructor เริ่มต้น สร้างเซตว่าง
     */
    public IntegerSet() {
        s = "";
        checkRep();
    }

    /**
     * ตรวจสอบ RI: ไม่มีเลขซ้ำและเรียงลำดับจากน้อยไปมาก
     */
    private void checkRep() {
        if (s.isEmpty()) return;

        String[] nums = s.split(" ");
        for (int i = 0; i < nums.length - 1; i++) {
            int a = Integer.parseInt(nums[i]);
            int b = Integer.parseInt(nums[i + 1]);
            if (a >= b) {
                throw new RuntimeException("Rep invariant violated: not sorted or duplicate values");
            }
        }
    }

    /**
     * เพิ่มจำนวนเต็มเข้าเซต
     * @param value จำนวนเต็มที่ต้องการเพิ่ม
     */
    public void add(int value) {
        if (contains(value)) return;

        String[] nums = s.isEmpty() ? new String[0] : s.split(" ");
        StringBuilder sb = new StringBuilder();
        boolean inserted = false;

        for (String numStr : nums) {
            int num = Integer.parseInt(numStr);
            if (!inserted && value < num) {
                sb.append(value).append(" ");
                inserted = true;
            }
            sb.append(num).append(" ");
        }

        if (!inserted) {
            sb.append(value).append(" ");
        }

        s = sb.toString().trim();
        checkRep();
    }

    /**
     * ลบจำนวนเต็มออกจากเซต
     * @param value จำนวนเต็มที่ต้องการลบ
     */
    public void remove(int value) {
        String[] nums = s.isEmpty() ? new String[0] : s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String numStr : nums) {
            int num = Integer.parseInt(numStr);
            if (num != value) {
                sb.append(num).append(" ");
            }
        }

        s = sb.toString().trim();
        checkRep();
    }

    /**
     * ตรวจสอบว่าในเซตมีค่าหรือไม่
     * @param value จำนวนเต็มที่ต้องการตรวจสอบ
     * @return true หากมีอยู่, false หากไม่มี
     */
    public boolean contains(int value) {
        String[] nums = s.isEmpty() ? new String[0] : s.split(" ");
        for (String numStr : nums) {
            if (Integer.parseInt(numStr) == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * คืนขนาดของเซต
     * @return จำนวนสมาชิก
     */
    public int size() {
        return s.isEmpty() ? 0 : s.split(" ").length;
    }

    @Override
    public String toString() {
        if (s.isEmpty()) return "{}";

        String[] nums = s.split(" ");
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i < nums.length - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
