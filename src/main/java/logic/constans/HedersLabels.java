package logic.constans;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor (access = AccessLevel.PRIVATE)
public enum HedersLabels {

    RAPIDAPI_HOST("x-rapidapi-host"),
    RAPIDAPI_KEY("x-rapidapi-key");

    private final String label;

    public String get() {
        return label;
    }
}
