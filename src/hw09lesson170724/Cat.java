package hw09lesson170724;

public class Cat implements Pet{

    private Brain brain = new Hungry();
//    private Pet brain = new Hungry();

    private class Hungry implements Brain{

        @Override
        public void feed() {
            makePrimarySound();
            makeSecondarySound();
            brain = new Fed();
        }

        @Override
        public void play() {
            makePrimarySound();
            makePrimarySound();
            brain = new Hungry();
        }

        @Override
        public void wash() {
            hiss();
            biteNscratch();
            runOf();
        }

        @Override
        public void stroke() {
            makeSecondarySound();
            makePrimarySound();
        }
    }

    private class Fed implements Brain{

        @Override
        public void feed() {
            runOf();
            makeSecondarySound();
        }

        @Override
        public void play() {
            hunting();
            biteNscratch();
            brain = new Hungry();
        }

        @Override
        public void wash() {
            hiss();
            biteNscratch();
            runOf();
        }

        @Override
        public void stroke() {
            hiss();
            runOf();
        }
    }

    private void biteNscratch() {
        System.out.println("The cat bites and scratches you!");
    }

    private void makePrimarySound() {
        System.out.println("'Meow'");
    }

    private void hiss() {
        System.out.println("Kitty is unhappy");
    }

    private void hunting() {
        System.out.println("You have to beware!");
    }

    private void runOf() {
        System.out.println("The cat runs away from you");
    }

    private void makeSecondarySound() {
        System.out.println("'Purr'");
    }

    @Override
    public void feed() {
        brain.feed();
    }

    @Override
    public void play() {
        brain.play();
    }

    @Override
    public void wash() {
        brain.wash();
    }

    @Override
    public void stroke() {
        brain.stroke();
    }
}
