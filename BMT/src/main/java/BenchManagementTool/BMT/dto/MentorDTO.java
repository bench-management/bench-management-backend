package BenchManagementTool.BMT.dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NotNull
@Builder
public class MentorDTO {
    @NotNull(message = "id cant be null")
    private int id;
    @NotNull(message ="name cant be null")
    private String name;
    @NotEmpty(message = "expertise cant be null")
    List<String> expertise;
    @NotNull(message = "year of experience can't be null")
    private int yoe;
}
