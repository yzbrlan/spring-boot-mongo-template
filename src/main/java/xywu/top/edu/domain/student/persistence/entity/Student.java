package xywu.top.edu.domain.student.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.HashMap;

/**
 * @author xywu
 * @date 2020/09/24
 */
@Data
public class Student {
    @Id
    @JsonProperty("id")
    private String id = null;

    @JsonProperty("idCard")
    private String idCard = null;

    @JsonProperty("attrs")
    private HashMap<String, String> attrs = new HashMap<>();
}
