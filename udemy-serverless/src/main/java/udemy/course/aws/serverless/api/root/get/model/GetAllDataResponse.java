package udemy.course.aws.serverless.api.root.get.model;

import udemy.course.aws.serverless.domain.CompareData;

import java.util.List;

/**
 * Created by raistlin on 9/14/2017.
 */
public class GetAllDataResponse {
    private List<CompareData> resultList;

    public GetAllDataResponse(List<CompareData> resultList) {
        this.resultList = resultList;
    }

    public List<CompareData> getResultList() {
        return resultList;
    }

    public void setResultList(List<CompareData> resultList) {
        this.resultList = resultList;
    }
}
