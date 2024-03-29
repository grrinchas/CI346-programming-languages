/**
 * Created by jb259 on 08/12/16.
 */
@SuppressWarnings("all")
public class User {

    @DefaultInt(1)
    public int userID;

    @DefaultString("John")
    public String firstName;

    @DefaultString("Doe")
    public String lastName;

    public User(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return String.format("%s %s [%d]", firstName, lastName, userID);
    }

}
