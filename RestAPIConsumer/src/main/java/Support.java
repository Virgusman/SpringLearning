import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Support {
    private String url;
    private String text;

    @Override
    public String toString() {
        return "Support{" +
                "url='" + url + '\'' +
                ", test='" + text + '\'' +
                '}';
    }
}
