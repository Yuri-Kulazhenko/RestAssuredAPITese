package logic.common;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum EndPoints {
    GET_SEARCH_TEAM ("/teams"),
    GET_SEARCH_COUNTRIES ("/countries");


    private final String URI;

    public String get() {
        return URI;
    }

}
