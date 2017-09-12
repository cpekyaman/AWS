package udemy.course.aws.serverless.assignment2;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * Created by raistlin on 9/12/2017.
 */
public class ApiHandler implements RequestHandler<ApiRequest, ApiResponse> {
    @Override
    public ApiResponse handleRequest(ApiRequest input, Context context) {
        context.getLogger().log("Input income is " + input.getIncome());

        int outputIncome = input.getIncome() / 10;
        context.getLogger().log("Output income is " + outputIncome);

        return new ApiResponse(outputIncome);
    }
}
