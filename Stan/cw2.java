package ZPO.Stan;

public class cw2
{
    public static void main(String[] args)
    {
        TV tv = new TV();
        System.out.println(tv);
        tv.changeToNextCanal();
        tv.getCurrentCanal();
        tv.changeState();
        tv.changeToNextCanal();
        tv.changeToNextCanal();
        tv.changeToPreviousCanal();
        tv.getCurrentCanal();
        System.out.println(tv);
    }

    public static class TV
    {
        private State offState;
        private State onState;
        private State state;

        TV()
        {
            offState = new tvOffState(this);
            onState = new tvOnState(this);

            state = offState;
        }

        void setState(State state) {
            this.state = state;
        }

        State getOffState() {
            return offState;
        }

        State getOnState() {
            return onState;
        }

        void changeState() {
            state.power();
        }

        void changeToNextCanal() {
            state.nextCanal();
        }

        void changeToPreviousCanal() {
            state.previousCanal();
        }

        void getCurrentCanal() {
            state.currentCanal();
        }

        @Override
        public String toString() {
            return state.toString();
        }
    }

    public interface State {
        void power();
        void nextCanal();
        void previousCanal();
        void currentCanal();
    }

    public static class tvOffState implements State
    {
        private final TV tv;

        public tvOffState(TV tv)
        {
            this.tv = tv;
        }

        @Override
        public void power()
        {
            tv.setState(tv.getOnState());
        }

        public void nextCanal()
        {
            System.out.println("Telewizor jest wyłączony");
        }
        public void previousCanal()
        {
            System.out.println("Telewizor jest wyłączony");
        }
        public void currentCanal()
        {
            System.out.println("Telewizor jest wyłączony");
        }

        @Override
        public String toString()
        {
            return "Telewizor wyączony";
        }
    }

    public static class tvOnState implements State
    {
        private final TV tv;
        int canal;

        public tvOnState(TV tv)
        {
            this.tv = tv;
        }

        @Override
        public void power()
        {
            tv.setState(tv.getOffState());
        }

        public void nextCanal()
        {
            this.canal += 1;
        }
        public void previousCanal()
        {
            this.canal -= 1;
        }

        public void currentCanal()
        {
            System.out.println("Obecny kanał: " + this.canal);
        }

        @Override
        public String toString()
        {
            return "Telewizor włączony";
        }
    }
}