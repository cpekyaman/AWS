package udemy.course.aws.serverless.post;

/**
 * Created by raistlin on 8/19/2017.
 */
public class ResponseClass {
    private String output;

    public ResponseClass() {
    }

    public ResponseClass(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
