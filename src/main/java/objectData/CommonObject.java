package objectData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommonObject {

    public List<String> getValueList(String value) {
        String[] values = value.split(",");
        return Arrays.stream(values).collect(Collectors.toList());
    }
}
