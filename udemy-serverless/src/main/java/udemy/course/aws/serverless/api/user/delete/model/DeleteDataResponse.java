package udemy.course.aws.serverless.api.user.delete.model;

/**
 * Created by raistlin on 9/13/2017.
 */
public class DeleteDataResponse {
    private String result;

    public DeleteDataResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
