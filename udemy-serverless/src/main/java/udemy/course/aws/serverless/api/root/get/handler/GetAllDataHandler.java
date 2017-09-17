package udemy.course.aws.serverless.api.root.get.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.log4j.Logger;
import udemy.course.aws.serverless.api.root.get.model.GetAllDataRequest;
import udemy.course.aws.serverless.api.root.get.model.GetAllDataResponse;
import udemy.course.aws.serverless.core.PersistenceManager;

import java.util.ArrayList;

/**
 * Created by raistlin on 9/14/2017.
 */
public class GetAllDataHandler implements RequestHandler<GetAllDataRequest, GetAllDataResponse> {
    private static final Logger LOG = Logger.getLogger(GetAllDataHandler.class);

    @Override
    public GetAllDataResponse handleRequest(GetAllDataRequest input, Context context) {
        LOG.info("Received all data request");
        return new GetAllDataResponse(new ArrayList<>(PersistenceManager.repository().findAll()));
    }
}
