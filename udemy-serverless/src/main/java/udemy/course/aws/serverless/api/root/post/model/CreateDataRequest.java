package udemy.course.aws.serverless.api.root.post.model;

import udemy.course.aws.serverless.api.common.model.CompareDataModel;

/**
 * Created by raistlin on 8/19/2017.
 */
public class CreateDataRequest {
    private String username;

    private CompareDataModel data;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CompareDataModel getData() {
        return data;
    }

    public void setData(CompareDataModel data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreateDataRequest{");
        sb.append("username='").append(username).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
