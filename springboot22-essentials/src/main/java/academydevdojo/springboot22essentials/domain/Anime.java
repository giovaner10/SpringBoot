package academydevdojo.springboot22essentials.domain;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Anime {

    private String name;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
