public enum ArithmeticOperation {
    PLUS {
        public int action(int x, int y) {
            return x + y;
        }
    },
    MINUS {
        public int action(int x, int y) {
            return x - y;
        }
    },
    DIVIDE {
        public int action(int x, int y) {
            return x / y;
        }
    },
    MULTIPLY {
        public int action(int x, int y) {
            return x * y;
        }
    };
    public abstract int action(int x, int y);
}
