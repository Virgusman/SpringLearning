import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonResponse {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<DataProfile> data;
    private Support support;
}
