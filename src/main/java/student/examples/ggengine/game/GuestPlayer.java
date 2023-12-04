package student.examples.ggengine.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class GuestPlayer implements Participant{
    private UUID id;
    private String name;
}