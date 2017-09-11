package udemy.course.aws.serverless.assignment1.store;

/**
 * Created by raistlin on 8/19/2017.
 */
public class StoreApiRequest {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
