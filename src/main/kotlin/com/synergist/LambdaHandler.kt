package com.synergist

import com.amazonaws.serverless.proxy.model.AwsProxyRequest
import com.amazonaws.serverless.proxy.model.AwsProxyResponse
import com.amazonaws.serverless.proxy.spring.SpringLambdaContainerHandler
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler

class LambdaHandler : RequestHandler<AwsProxyRequest, AwsProxyResponse> {

    companion object {
        val handler: SpringLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> = instance()

        fun instance() : SpringLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> {
            return SpringLambdaContainerHandler.getAwsProxyHandler(AppConfig::class.java)
        }
    }
    override fun handleRequest(input: AwsProxyRequest?, context: Context?): AwsProxyResponse {
        return handler.proxy(input, context)
    }
}