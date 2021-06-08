package ZPO.Stan;

public class cw1
{
    public static void main(String[] args)
    {
        Draw draw = new Draw();
        System.out.println(draw);
        draw.request();
        System.out.println(draw);
        draw.request();
        System.out.println(draw);
    }

    public static class Draw
    {
        private State circleState;
        private State squareState;
        private State state;

        public Draw()
        {
            circleState = new drawCircle(this);
            squareState = new drawSquare(this);

            state = circleState;
        }

        public void request() {
            state.handle();
        }

        public void setState(State state) {
            this.state = state;
        }

        public State getCircleState() {
            return circleState;
        }

        public State getSquareState() {
            return squareState;
        }

        @Override
        public String toString() {
            return state.toString();
        }
    }

    public interface State {
        void handle();
    }

    public static class drawCircle implements State
    {
        private final Draw draw;

        public drawCircle(Draw draw)
        {
            this.draw = draw;
        }

        @Override
        public void handle()
        {
            System.out.println("Przygotowywanie narzędzi do narysowania kwadratu...");
            draw.setState(draw.getSquareState());
        }

        @Override
        public String toString()
        {
            return "Rysowanie koła";
        }
    }

    public static class drawSquare implements State
    {
        private final Draw draw;

        public drawSquare(Draw draw)
        {
            this.draw = draw;
        }

        @Override
        public void handle()
        {
            System.out.println("Przygotowywanie narzędzi do narysowania koła...");
            draw.setState(draw.getCircleState());
        }

        @Override
        public String toString()
        {
            return "Rysowanie kwadratu";
        }
    }
}