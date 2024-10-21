// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.chat

import com.openai.core.ClientOptions
import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.map
import com.openai.core.handlers.mapJson
import com.openai.core.handlers.sseHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.StreamResponse
import com.openai.core.json
import com.openai.errors.OpenAIError
import com.openai.models.ChatCompletion
import com.openai.models.ChatCompletionChunk
import com.openai.models.ChatCompletionCreateParams

class CompletionServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : CompletionService {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<ChatCompletion> =
        jsonHandler<ChatCompletion>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /**
     * Creates a model response for the given chat conversation. Learn more in the
     * [text generation](https://platform.openai.com/docs/guides/text-generation),
     * [vision](https://platform.openai.com/docs/guides/vision), and
     * [audio](https://platform.openai.com/docs/guides/audio) guides.
     */
    override fun create(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions
    ): ChatCompletion {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("chat", "completions")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val createStreamingHandler: Handler<StreamResponse<ChatCompletionChunk>> =
        sseHandler()
            .mapJson<ChatCompletionChunk>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /**
     * Creates a model response for the given chat conversation. Learn more in the
     * [text generation](https://platform.openai.com/docs/guides/text-generation),
     * [vision](https://platform.openai.com/docs/guides/vision), and
     * [audio](https://platform.openai.com/docs/guides/audio) guides.
     */
    override fun createStreaming(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions
    ): StreamResponse<ChatCompletionChunk> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("chat", "completions")
                .putAllQueryParams(clientOptions.queryParams)
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(
                    json(
                        clientOptions.jsonMapper,
                        params
                            .getBody()
                            .toBuilder()
                            .putAdditionalProperty("stream", JsonValue.from(true))
                            .build()
                    )
                )
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .let { createStreamingHandler.handle(it) }
                .let { streamingResponse ->
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        streamingResponse.map { it.validate() }
                    } else {
                        streamingResponse
                    }
                }
        }
    }
}
