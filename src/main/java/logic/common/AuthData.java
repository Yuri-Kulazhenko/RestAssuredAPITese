package logic.common;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AuthData {
    BASIC_USER ("api-football-v1.p.rapidapi.com", "b09e42ab3bmsh67e420a5a8c248ap16f859jsna005c1952e57");

    private String xHost;
    private String xKey;

    public String getHost() {
        return xHost;
    }

    public String getKey() {
        return xKey;
    }

}
