package udemy.course.aws.serverless.api.root.post.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.log4j.Logger;
import udemy.course.aws.serverless.api.common.model.CompareDataModel;
import udemy.course.aws.serverless.api.common.response.SavedDataResponse;
import udemy.course.aws.serverless.api.root.post.model.CreateDataRequest;
import udemy.course.aws.serverless.core.PersistenceManager;
import udemy.course.aws.serverless.domain.CompareData;

/**
 * Created by raistlin on 8/19/2017.
 */
public class CreateDataHandler implements RequestHandler<CreateDataRequest, SavedDataResponse> {
    private static final Logger LOG = Logger.getLogger(CreateDataHandler.class);

    @Override
    public SavedDataResponse handleRequest(CreateDataRequest input, Context context) {
        LOG.info("Received user data to save : " + input);
        CompareData data = mapRequestToDomain(input);

        LOG.info("Saving data to db");
        PersistenceManager.repository().save(data);

        LOG.info("returning response");
        return new SavedDataResponse(data.getUserId(), data.getVersion());
    }

    private CompareData mapRequestToDomain(CreateDataRequest input) {
        CompareDataModel dataModel = input.getData();
        return new CompareData(input.getUsername(), dataModel.getAge(), dataModel.getHeight(), dataModel.getIncome());
    }
}
