// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.JsonValue
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** An output message from the model. */
@JsonDeserialize(using = ResponseOutputItem.Deserializer::class)
@JsonSerialize(using = ResponseOutputItem.Serializer::class)
class ResponseOutputItem
private constructor(
    private val message: ResponseOutputMessage? = null,
    private val fileSearchCall: ResponseFileSearchToolCall? = null,
    private val functionCall: ResponseFunctionToolCall? = null,
    private val webSearchCall: ResponseFunctionWebSearch? = null,
    private val computerCall: ResponseComputerToolCall? = null,
    private val reasoning: ResponseReasoningItem? = null,
    private val _json: JsonValue? = null,
) {

    /** An output message from the model. */
    fun message(): Optional<ResponseOutputMessage> = Optional.ofNullable(message)

    /**
     * The results of a file search tool call. See the
     * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
     * information.
     */
    fun fileSearchCall(): Optional<ResponseFileSearchToolCall> = Optional.ofNullable(fileSearchCall)

    /**
     * A tool call to run a function. See the
     * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for more
     * information.
     */
    fun functionCall(): Optional<ResponseFunctionToolCall> = Optional.ofNullable(functionCall)

    /**
     * The results of a web search tool call. See the
     * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
     * information.
     */
    fun webSearchCall(): Optional<ResponseFunctionWebSearch> = Optional.ofNullable(webSearchCall)

    /**
     * A tool call to a computer use tool. See the
     * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
     * information.
     */
    fun computerCall(): Optional<ResponseComputerToolCall> = Optional.ofNullable(computerCall)

    /**
     * A description of the chain of thought used by a reasoning model while generating a response.
     * Be sure to include these items in your `input` to the Responses API for subsequent turns of a
     * conversation if you are manually
     * [managing context](https://platform.openai.com/docs/guides/conversation-state).
     */
    fun reasoning(): Optional<ResponseReasoningItem> = Optional.ofNullable(reasoning)

    fun isMessage(): Boolean = message != null

    fun isFileSearchCall(): Boolean = fileSearchCall != null

    fun isFunctionCall(): Boolean = functionCall != null

    fun isWebSearchCall(): Boolean = webSearchCall != null

    fun isComputerCall(): Boolean = computerCall != null

    fun isReasoning(): Boolean = reasoning != null

    /** An output message from the model. */
    fun asMessage(): ResponseOutputMessage = message.getOrThrow("message")

    /**
     * The results of a file search tool call. See the
     * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
     * information.
     */
    fun asFileSearchCall(): ResponseFileSearchToolCall = fileSearchCall.getOrThrow("fileSearchCall")

    /**
     * A tool call to run a function. See the
     * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for more
     * information.
     */
    fun asFunctionCall(): ResponseFunctionToolCall = functionCall.getOrThrow("functionCall")

    /**
     * The results of a web search tool call. See the
     * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
     * information.
     */
    fun asWebSearchCall(): ResponseFunctionWebSearch = webSearchCall.getOrThrow("webSearchCall")

    /**
     * A tool call to a computer use tool. See the
     * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
     * information.
     */
    fun asComputerCall(): ResponseComputerToolCall = computerCall.getOrThrow("computerCall")

    /**
     * A description of the chain of thought used by a reasoning model while generating a response.
     * Be sure to include these items in your `input` to the Responses API for subsequent turns of a
     * conversation if you are manually
     * [managing context](https://platform.openai.com/docs/guides/conversation-state).
     */
    fun asReasoning(): ResponseReasoningItem = reasoning.getOrThrow("reasoning")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            message != null -> visitor.visitMessage(message)
            fileSearchCall != null -> visitor.visitFileSearchCall(fileSearchCall)
            functionCall != null -> visitor.visitFunctionCall(functionCall)
            webSearchCall != null -> visitor.visitWebSearchCall(webSearchCall)
            computerCall != null -> visitor.visitComputerCall(computerCall)
            reasoning != null -> visitor.visitReasoning(reasoning)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): ResponseOutputItem = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitMessage(message: ResponseOutputMessage) {
                    message.validate()
                }

                override fun visitFileSearchCall(fileSearchCall: ResponseFileSearchToolCall) {
                    fileSearchCall.validate()
                }

                override fun visitFunctionCall(functionCall: ResponseFunctionToolCall) {
                    functionCall.validate()
                }

                override fun visitWebSearchCall(webSearchCall: ResponseFunctionWebSearch) {
                    webSearchCall.validate()
                }

                override fun visitComputerCall(computerCall: ResponseComputerToolCall) {
                    computerCall.validate()
                }

                override fun visitReasoning(reasoning: ResponseReasoningItem) {
                    reasoning.validate()
                }
            }
        )
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitMessage(message: ResponseOutputMessage) = message.validity()

                override fun visitFileSearchCall(fileSearchCall: ResponseFileSearchToolCall) =
                    fileSearchCall.validity()

                override fun visitFunctionCall(functionCall: ResponseFunctionToolCall) =
                    functionCall.validity()

                override fun visitWebSearchCall(webSearchCall: ResponseFunctionWebSearch) =
                    webSearchCall.validity()

                override fun visitComputerCall(computerCall: ResponseComputerToolCall) =
                    computerCall.validity()

                override fun visitReasoning(reasoning: ResponseReasoningItem) = reasoning.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseOutputItem && message == other.message && fileSearchCall == other.fileSearchCall && functionCall == other.functionCall && webSearchCall == other.webSearchCall && computerCall == other.computerCall && reasoning == other.reasoning /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(message, fileSearchCall, functionCall, webSearchCall, computerCall, reasoning) /* spotless:on */

    override fun toString(): String =
        when {
            message != null -> "ResponseOutputItem{message=$message}"
            fileSearchCall != null -> "ResponseOutputItem{fileSearchCall=$fileSearchCall}"
            functionCall != null -> "ResponseOutputItem{functionCall=$functionCall}"
            webSearchCall != null -> "ResponseOutputItem{webSearchCall=$webSearchCall}"
            computerCall != null -> "ResponseOutputItem{computerCall=$computerCall}"
            reasoning != null -> "ResponseOutputItem{reasoning=$reasoning}"
            _json != null -> "ResponseOutputItem{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ResponseOutputItem")
        }

    companion object {

        /** An output message from the model. */
        @JvmStatic
        fun ofMessage(message: ResponseOutputMessage) = ResponseOutputItem(message = message)

        /**
         * The results of a file search tool call. See the
         * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
         * information.
         */
        @JvmStatic
        fun ofFileSearchCall(fileSearchCall: ResponseFileSearchToolCall) =
            ResponseOutputItem(fileSearchCall = fileSearchCall)

        /**
         * A tool call to run a function. See the
         * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for
         * more information.
         */
        @JvmStatic
        fun ofFunctionCall(functionCall: ResponseFunctionToolCall) =
            ResponseOutputItem(functionCall = functionCall)

        /**
         * The results of a web search tool call. See the
         * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
         * information.
         */
        @JvmStatic
        fun ofWebSearchCall(webSearchCall: ResponseFunctionWebSearch) =
            ResponseOutputItem(webSearchCall = webSearchCall)

        /**
         * A tool call to a computer use tool. See the
         * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
         * information.
         */
        @JvmStatic
        fun ofComputerCall(computerCall: ResponseComputerToolCall) =
            ResponseOutputItem(computerCall = computerCall)

        /**
         * A description of the chain of thought used by a reasoning model while generating a
         * response. Be sure to include these items in your `input` to the Responses API for
         * subsequent turns of a conversation if you are manually
         * [managing context](https://platform.openai.com/docs/guides/conversation-state).
         */
        @JvmStatic
        fun ofReasoning(reasoning: ResponseReasoningItem) =
            ResponseOutputItem(reasoning = reasoning)
    }

    /**
     * An interface that defines how to map each variant of [ResponseOutputItem] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** An output message from the model. */
        fun visitMessage(message: ResponseOutputMessage): T

        /**
         * The results of a file search tool call. See the
         * [file search guide](https://platform.openai.com/docs/guides/tools-file-search) for more
         * information.
         */
        fun visitFileSearchCall(fileSearchCall: ResponseFileSearchToolCall): T

        /**
         * A tool call to run a function. See the
         * [function calling guide](https://platform.openai.com/docs/guides/function-calling) for
         * more information.
         */
        fun visitFunctionCall(functionCall: ResponseFunctionToolCall): T

        /**
         * The results of a web search tool call. See the
         * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
         * information.
         */
        fun visitWebSearchCall(webSearchCall: ResponseFunctionWebSearch): T

        /**
         * A tool call to a computer use tool. See the
         * [computer use guide](https://platform.openai.com/docs/guides/tools-computer-use) for more
         * information.
         */
        fun visitComputerCall(computerCall: ResponseComputerToolCall): T

        /**
         * A description of the chain of thought used by a reasoning model while generating a
         * response. Be sure to include these items in your `input` to the Responses API for
         * subsequent turns of a conversation if you are manually
         * [managing context](https://platform.openai.com/docs/guides/conversation-state).
         */
        fun visitReasoning(reasoning: ResponseReasoningItem): T

        /**
         * Maps an unknown variant of [ResponseOutputItem] to a value of type [T].
         *
         * An instance of [ResponseOutputItem] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ResponseOutputItem: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<ResponseOutputItem>(ResponseOutputItem::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ResponseOutputItem {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "message" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseOutputMessage>())?.let {
                        ResponseOutputItem(message = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
                "file_search_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseFileSearchToolCall>())?.let {
                        ResponseOutputItem(fileSearchCall = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
                "function_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseFunctionToolCall>())?.let {
                        ResponseOutputItem(functionCall = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
                "web_search_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseFunctionWebSearch>())?.let {
                        ResponseOutputItem(webSearchCall = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
                "computer_call" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseComputerToolCall>())?.let {
                        ResponseOutputItem(computerCall = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
                "reasoning" -> {
                    return tryDeserialize(node, jacksonTypeRef<ResponseReasoningItem>())?.let {
                        ResponseOutputItem(reasoning = it, _json = json)
                    } ?: ResponseOutputItem(_json = json)
                }
            }

            return ResponseOutputItem(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<ResponseOutputItem>(ResponseOutputItem::class) {

        override fun serialize(
            value: ResponseOutputItem,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.message != null -> generator.writeObject(value.message)
                value.fileSearchCall != null -> generator.writeObject(value.fileSearchCall)
                value.functionCall != null -> generator.writeObject(value.functionCall)
                value.webSearchCall != null -> generator.writeObject(value.webSearchCall)
                value.computerCall != null -> generator.writeObject(value.computerCall)
                value.reasoning != null -> generator.writeObject(value.reasoning)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ResponseOutputItem")
            }
        }
    }
}
