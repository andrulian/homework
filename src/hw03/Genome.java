package hw03;

public class Genome {
    public static void main(String[] args) {
        byte[] data = DataGenerator.dataGenerator(10);

//        for (byte b: data) {
//            System.out.print((char)b);
//        }

        findOverlap(data, 3);
    }

    private static void findOverlap(byte[] data, int piece) {
        int counter = 0;
        int length = data.length - piece;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length+1; j++) {
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
