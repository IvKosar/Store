package game;

public enum Genre {
    ACTION("action"), SIMULATOR("simualator"), SHOOTER("shooter"), STRATEGY("strategy"),
    RACING("racing");

    private String name;

    Genre(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
