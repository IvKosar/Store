package game;

public enum Platform {
    WINDOWS_10("winda10"), WINDOWS_7("winda7"), WINDOWS_8("winda8"), UBUNTU("ubuntu");

    private String name;

    Platform(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

