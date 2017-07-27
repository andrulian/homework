package hw09lesson170724;

class RatSatiety {

    protected class Hungry implements Brain {

        @Override
        public void feed() {
//            makeSound();
//            purr();
//            brain = new Fed();
        }

        @Override
        public void play() {
//            makeSound();
//            makeSound();
//            brain = new Hungry();
        }

        @Override
        public void wash() {
//            hiss();
//            biteNscratch();
//            runOf();
        }

        @Override
        public void stroke() {
//            purr();
//            makeSound();
        }
    }

    protected class Fed implements Brain {

        @Override
        public void feed() {
//            runOf();
//            purr();
        }

        @Override
        public void play() {
//            hunting();
//            biteNscratch();
//            brain = new Hungry();
        }

        @Override
        public void wash() {
//            hiss();
//            biteNscratch();
//            runOf();
        }

        @Override
        public void stroke() {
//            hiss();
//            runOf();
        }
    }
}