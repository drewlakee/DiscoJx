package discojx.clients.authentication;

public class PersonalAccessToken extends AbstractToken {

    protected PersonalAccessToken(String token) {
        super(token);
    }

    public static PersonalAccessToken of(String token) {
        return new PersonalAccessToken(token);
    }
}
