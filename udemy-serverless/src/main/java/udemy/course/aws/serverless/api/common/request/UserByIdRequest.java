package udemy.course.aws.serverless.api.common.request;

/**
 * Created by raistlin on 9/17/2017.
 */
public class UserByIdRequest {
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserByIdRequest{");
        sb.append("userId='").append(userId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
