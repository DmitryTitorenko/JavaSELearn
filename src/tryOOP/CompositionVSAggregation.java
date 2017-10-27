package tryOOP;

public class CompositionVSAggregation {
    public static void main(String[] args) {

    }

    class PC {
        private CPU cpu;
        private SoundCard soundCard;

        //Composition
        public PC(String titleCPU) {
            this.cpu = new CPU(titleCPU);
        }

        //Aggregation
        public void setSoundCard(SoundCard soundCard) {
            this.soundCard = soundCard;
        }
    }

    class CPU {
        private String title;

        public CPU(String title) {
            this.title = title;
        }
    }

    class SoundCard {
        private String title;

        public SoundCard(String title) {
            this.title = title;
        }
    }
}
