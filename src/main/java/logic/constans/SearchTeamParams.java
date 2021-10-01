package logic.constans;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SearchTeamParams {

    SEARCH ("search"),
    ID ("id"),
    COUNRY ("country"),
    NAME ("name"),
    SEASON ("season"),
    LEAGUE ("league");

    private String param;

    public String get() {
        return param;
    }
}
