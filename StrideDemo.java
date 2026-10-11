public class StrideDemo {
    public static void main(String[] args) {
        String[] names = {"Catastrophizing", "Overgeneralization", "Mind reading"};
        int[] tickets = {3, 2, 1};
        int[] stride = new int[3];
        int[] pass = new int[3];
        int[] turns = new int[3];
        int big = 600;

        for (int i = 0; i < 3; i++) {
            stride[i] = big / tickets[i];
            pass[i] = stride[i];
        }

        for (int day = 1; day <= 12; day++) {
            int pick = 0;
            for (int i = 1; i < 3; i++) {
                if (pass[i] < pass[pick]) {
                    pick = i;
                }
            }
            System.out.println("Day " + day + ": " + names[pick]);
            turns[pick]++;
            pass[pick] += stride[pick];
        }

        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(names[i] + " (" + tickets[i] + " tickets): " + turns[i] + " turns");
        }
    }
}
