package udemy.course.aws.serverless.assignment1.fetch;

/**
 * Created by raistlin on 9/11/2017.
 */
public class FetchDataResponse {
    private String message;

    public FetchDataResponse() {
    }

    public FetchDataResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
