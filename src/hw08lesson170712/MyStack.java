package hw08lesson170712;

public class MyStack {
    private static final int DEFAULT_MAX_SIZE = 3;
    private String[] stackContainer;
    private int size;

    public MyStack() {
        this(DEFAULT_MAX_SIZE);
    }

    public MyStack(int maxSize) {
        stackContainer = new String[maxSize];
    }

    public boolean push(String string) {
        if (size >= stackContainer.length) {
            return false;
        }

        stackContainer[size++] = string;
        return true;
    }

    public String pop() {
        if (size <= 0) {
            return null;
        }

        String result = stackContainer[--size];
        stackContainer[size] = null;
        return result;
    }

    public int size() { return size; }

    public String tos() { return size <= 0 ? null : stackContainer[size - 1]; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(stackContainer[0]);

        for (int i = 1; i < stackContainer.length; i++) {
            sb.append(", ");
            sb.append(stackContainer[i]);
        }

        sb.append("]");

        return sb.toString();
//        return Arrays.toString(Arrays.copyOfRange(elements, 0, size));
    }
}
