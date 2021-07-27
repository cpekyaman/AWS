package udemy.course.aws.serverless.api.user.get.model;

import udemy.course.aws.serverless.domain.CompareData;

/**
 * Created by raistlin on 9/13/2017.
 */
public class GetUserDataResponse {
    private CompareData result;

    public GetUserDataResponse(CompareData result) {
        this.result = result;
    }

    public CompareData getResult() {
        return result;
    }

    public void setResult(CompareData result) {
        this.result = result;
    }
}
