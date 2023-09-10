package works.hop.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

    public UUID id;
    public final String firstName;
    public final String lastName;
    public final String emailAddress;
}
