package hw09lesson170724;

public class Rat implements Pet{
    private Brain brain = new Hungry();

    @Override
    public void feed() {
        brain.feed();
        if (brain instanceof Hungry) {brain = new Fed();}
    }

    @Override
    public void play() {
        brain.play();
        if (brain instanceof Fed) {brain = new Hungry();}
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

class Hungry implements Brain {

    {
        System.out.println("-=The rat is hungry=-");
    }

    @Override
    public void feed() {
        makePrimarySound();
        makeSecondarySound();
    }

    @Override
    public void play() {
        makePrimarySound();
        makePrimarySound();
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

    private void biteNscratch() {
        System.out.println("The rat bites and scratches you! You feel yourself unwell...");
    }

    private void makePrimarySound() {
        System.out.println("'AGHRRR'");
    }

    private void hiss() {
        System.out.println("*Rats hiss*");
    }

    private void hunting() {
        System.out.println("You have to beware!");
    }

    private void runOf() {
        System.out.println("The rat runs away from you");
    }

    private void makeSecondarySound() {
        System.out.println("Rats creepy 'purr'");
    }
}

class Fed implements Brain {

    {
        System.out.println("-=The rat is full=-");
    }

    @Override
    public void feed() {
        runOf();
        makeSecondarySound();
    }

    @Override
    public void play() {
        hunting();
        biteNscratch();
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

    private void biteNscratch() {
        System.out.println("The rat bites and scratches you! You feel yourself unwell...");
    }

    private void makePrimarySound() {
        System.out.println("'AGHRRR'");
    }

    private void hiss() {
        System.out.println("*Rats hiss*");
    }

    private void hunting() {
        System.out.println("You have to beware!");
    }

    private void runOf() {
        System.out.println("The rat runs away from you");
    }

    private void makeSecondarySound() {
        System.out.println("Rats creepy 'purr'");
    }
}
