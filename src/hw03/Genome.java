package hw03;

public class Genome {
    public static void main(String[] args) {
        byte[] data = DataGenerator.generator(10);

        findOverlap(data, 3);
    }

    private static void findOverlap(byte[] data, int piece) {
        int counter = 0;
        int len = data.length - piece;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len+1; j++) {
                boolean overlap = true;
                for (int k = 0; k < piece ; k++) {
                    if(data[i] != data[j]) {
                        overlap = false;
                        break;
                    }
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
