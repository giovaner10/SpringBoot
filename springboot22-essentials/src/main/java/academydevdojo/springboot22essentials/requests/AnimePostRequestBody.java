package academydevdojo.springboot22essentials.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnimePostRequestBody {
    @NotEmpty(message = "nao pode ser empty")
    @NotNull(message = "nao pode ser null")
    private String name;
}
