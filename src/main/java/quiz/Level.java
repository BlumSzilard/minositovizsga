package quiz;

public enum Level {

    EASY(1), MEDIUM(2), HIGH(3);

    private final int point;


    Level(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }
}

