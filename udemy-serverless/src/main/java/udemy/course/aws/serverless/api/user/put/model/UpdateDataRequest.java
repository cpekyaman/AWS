package udemy.course.aws.serverless.api.user.put.model;

import udemy.course.aws.serverless.api.common.model.CompareDataModel;

/**
 * Created by raistlin on 9/14/2017.
 */
public class UpdateDataRequest {
    private String userId;

    private Integer version;

    private CompareDataModel data;

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

    public CompareDataModel getData() {
        return data;
    }

    public void setData(CompareDataModel data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UpdateDataRequest{");
        sb.append("userId='").append(userId).append('\'');
        sb.append(", version=").append(version);
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
