package udemy.course.aws.serverless.api.common.response;

/**
 * Created by raistlin on 9/14/2017.
 */
public class SavedDataResponse {
    private String userId;

    private Integer version;

    public SavedDataResponse(String userId, Integer version) {
        this.userId = userId;
        this.version = version;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
