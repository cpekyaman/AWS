package udemy.course.aws.serverless.assignment1.fetch;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * Created by raistlin on 9/11/2017.
 */
public class FetchDataHandler implements RequestHandler<FetchDataRequest, FetchDataResponse> {
    @Override
    public FetchDataResponse handleRequest(FetchDataRequest input, Context context) {
        return new FetchDataResponse("This is AWS Lambda");
    }
}
