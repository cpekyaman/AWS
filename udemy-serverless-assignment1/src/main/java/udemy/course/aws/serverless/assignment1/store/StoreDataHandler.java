package udemy.course.aws.serverless.assignment1.store;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * Created by raistlin on 8/19/2017.
 */
public class StoreDataHandler implements RequestHandler<StoreApiRequest, StoreApiResponse> {
    @Override
    public StoreApiResponse handleRequest(StoreApiRequest input, Context context) {
        String fullName = input.getFirstName() + " " + input.getLastName();
        context.getLogger().log("Input: " + fullName);
        return new StoreApiResponse(fullName, 37);
    }
}
