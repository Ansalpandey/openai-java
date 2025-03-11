// File generated from our OpenAPI spec by Stainless.

package com.openai.models.chat.completions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Learn about [text inputs](https://platform.openai.com/docs/guides/text-generation). */
@JsonDeserialize(using = ChatCompletionContentPart.Deserializer::class)
@JsonSerialize(using = ChatCompletionContentPart.Serializer::class)
class ChatCompletionContentPart
private constructor(
    private val text: ChatCompletionContentPartText? = null,
    private val imageUrl: ChatCompletionContentPartImage? = null,
    private val inputAudio: ChatCompletionContentPartInputAudio? = null,
    private val file: File? = null,
    private val _json: JsonValue? = null,
) {

    /** Learn about [text inputs](https://platform.openai.com/docs/guides/text-generation). */
    fun text(): Optional<ChatCompletionContentPartText> = Optional.ofNullable(text)

    /** Learn about [image inputs](https://platform.openai.com/docs/guides/vision). */
    fun imageUrl(): Optional<ChatCompletionContentPartImage> = Optional.ofNullable(imageUrl)

    /** Learn about [audio inputs](https://platform.openai.com/docs/guides/audio). */
    fun inputAudio(): Optional<ChatCompletionContentPartInputAudio> =
        Optional.ofNullable(inputAudio)

    /**
     * Learn about [file inputs](https://platform.openai.com/docs/guides/text) for text generation.
     */
    fun file(): Optional<File> = Optional.ofNullable(file)

    fun isText(): Boolean = text != null

    fun isImageUrl(): Boolean = imageUrl != null

    fun isInputAudio(): Boolean = inputAudio != null

    fun isFile(): Boolean = file != null

    /** Learn about [text inputs](https://platform.openai.com/docs/guides/text-generation). */
    fun asText(): ChatCompletionContentPartText = text.getOrThrow("text")

    /** Learn about [image inputs](https://platform.openai.com/docs/guides/vision). */
    fun asImageUrl(): ChatCompletionContentPartImage = imageUrl.getOrThrow("imageUrl")

    /** Learn about [audio inputs](https://platform.openai.com/docs/guides/audio). */
    fun asInputAudio(): ChatCompletionContentPartInputAudio = inputAudio.getOrThrow("inputAudio")

    /**
     * Learn about [file inputs](https://platform.openai.com/docs/guides/text) for text generation.
     */
    fun asFile(): File = file.getOrThrow("file")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            text != null -> visitor.visitText(text)
            imageUrl != null -> visitor.visitImageUrl(imageUrl)
            inputAudio != null -> visitor.visitInputAudio(inputAudio)
            file != null -> visitor.visitFile(file)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): ChatCompletionContentPart = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitText(text: ChatCompletionContentPartText) {
                    text.validate()
                }

                override fun visitImageUrl(imageUrl: ChatCompletionContentPartImage) {
                    imageUrl.validate()
                }

                override fun visitInputAudio(inputAudio: ChatCompletionContentPartInputAudio) {
                    inputAudio.validate()
                }

                override fun visitFile(file: File) {
                    file.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionContentPart && text == other.text && imageUrl == other.imageUrl && inputAudio == other.inputAudio && file == other.file /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(text, imageUrl, inputAudio, file) /* spotless:on */

    override fun toString(): String =
        when {
            text != null -> "ChatCompletionContentPart{text=$text}"
            imageUrl != null -> "ChatCompletionContentPart{imageUrl=$imageUrl}"
            inputAudio != null -> "ChatCompletionContentPart{inputAudio=$inputAudio}"
            file != null -> "ChatCompletionContentPart{file=$file}"
            _json != null -> "ChatCompletionContentPart{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ChatCompletionContentPart")
        }

    companion object {

        /** Learn about [text inputs](https://platform.openai.com/docs/guides/text-generation). */
        @JvmStatic
        fun ofText(text: ChatCompletionContentPartText) = ChatCompletionContentPart(text = text)

        /** Learn about [image inputs](https://platform.openai.com/docs/guides/vision). */
        @JvmStatic
        fun ofImageUrl(imageUrl: ChatCompletionContentPartImage) =
            ChatCompletionContentPart(imageUrl = imageUrl)

        /** Learn about [audio inputs](https://platform.openai.com/docs/guides/audio). */
        @JvmStatic
        fun ofInputAudio(inputAudio: ChatCompletionContentPartInputAudio) =
            ChatCompletionContentPart(inputAudio = inputAudio)

        /**
         * Learn about [file inputs](https://platform.openai.com/docs/guides/text) for text
         * generation.
         */
        @JvmStatic fun ofFile(file: File) = ChatCompletionContentPart(file = file)
    }

    /**
     * An interface that defines how to map each variant of [ChatCompletionContentPart] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        /** Learn about [text inputs](https://platform.openai.com/docs/guides/text-generation). */
        fun visitText(text: ChatCompletionContentPartText): T

        /** Learn about [image inputs](https://platform.openai.com/docs/guides/vision). */
        fun visitImageUrl(imageUrl: ChatCompletionContentPartImage): T

        /** Learn about [audio inputs](https://platform.openai.com/docs/guides/audio). */
        fun visitInputAudio(inputAudio: ChatCompletionContentPartInputAudio): T

        /**
         * Learn about [file inputs](https://platform.openai.com/docs/guides/text) for text
         * generation.
         */
        fun visitFile(file: File): T

        /**
         * Maps an unknown variant of [ChatCompletionContentPart] to a value of type [T].
         *
         * An instance of [ChatCompletionContentPart] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ChatCompletionContentPart: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<ChatCompletionContentPart>(ChatCompletionContentPart::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ChatCompletionContentPart {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "text" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionContentPartText>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionContentPart(text = it, _json = json)
                        }
                }
                "image_url" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionContentPartImage>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionContentPart(imageUrl = it, _json = json)
                        }
                }
                "input_audio" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionContentPartInputAudio>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionContentPart(inputAudio = it, _json = json)
                        }
                }
                "file" -> {
                    tryDeserialize(node, jacksonTypeRef<File>()) { it.validate() }
                        ?.let {
                            return ChatCompletionContentPart(file = it, _json = json)
                        }
                }
            }

            return ChatCompletionContentPart(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<ChatCompletionContentPart>(ChatCompletionContentPart::class) {

        override fun serialize(
            value: ChatCompletionContentPart,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.text != null -> generator.writeObject(value.text)
                value.imageUrl != null -> generator.writeObject(value.imageUrl)
                value.inputAudio != null -> generator.writeObject(value.inputAudio)
                value.file != null -> generator.writeObject(value.file)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ChatCompletionContentPart")
            }
        }
    }

    /**
     * Learn about [file inputs](https://platform.openai.com/docs/guides/text) for text generation.
     */
    @NoAutoDetect
    class File
    @JsonCreator
    private constructor(
        @JsonProperty("file")
        @ExcludeMissing
        private val file: JsonField<FileObject> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun file(): FileObject = file.getRequired("file")

        /** The type of the content part. Always `file`. */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        @JsonProperty("file") @ExcludeMissing fun _file(): JsonField<FileObject> = file

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): File = apply {
            if (validated) {
                return@apply
            }

            file().validate()
            _type().let {
                if (it != JsonValue.from("file")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [File].
             *
             * The following fields are required:
             * ```java
             * .file()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [File]. */
        class Builder internal constructor() {

            private var file: JsonField<FileObject>? = null
            private var type: JsonValue = JsonValue.from("file")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(file: File) = apply {
                this.file = file.file
                type = file.type
                additionalProperties = file.additionalProperties.toMutableMap()
            }

            fun file(file: FileObject) = file(JsonField.of(file))

            fun file(file: JsonField<FileObject>) = apply { this.file = file }

            /** The type of the content part. Always `file`. */
            fun type(type: JsonValue) = apply { this.type = type }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            fun build(): File =
                File(checkRequired("file", file), type, additionalProperties.toImmutable())
        }

        @NoAutoDetect
        class FileObject
        @JsonCreator
        private constructor(
            @JsonProperty("file_data")
            @ExcludeMissing
            private val fileData: JsonField<String> = JsonMissing.of(),
            @JsonProperty("file_id")
            @ExcludeMissing
            private val fileId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("file_name")
            @ExcludeMissing
            private val fileName: JsonField<String> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * The base64 encoded file data, used when passing the file to the model as a string.
             */
            fun fileData(): Optional<String> =
                Optional.ofNullable(fileData.getNullable("file_data"))

            /** The ID of an uploaded file to use as input. */
            fun fileId(): Optional<String> = Optional.ofNullable(fileId.getNullable("file_id"))

            /** The name of the file, used when passing the file to the model as a string. */
            fun fileName(): Optional<String> =
                Optional.ofNullable(fileName.getNullable("file_name"))

            /**
             * The base64 encoded file data, used when passing the file to the model as a string.
             */
            @JsonProperty("file_data") @ExcludeMissing fun _fileData(): JsonField<String> = fileData

            /** The ID of an uploaded file to use as input. */
            @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

            /** The name of the file, used when passing the file to the model as a string. */
            @JsonProperty("file_name") @ExcludeMissing fun _fileName(): JsonField<String> = fileName

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): FileObject = apply {
                if (validated) {
                    return@apply
                }

                fileData()
                fileId()
                fileName()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [FileObject]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FileObject]. */
            class Builder internal constructor() {

                private var fileData: JsonField<String> = JsonMissing.of()
                private var fileId: JsonField<String> = JsonMissing.of()
                private var fileName: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(fileObject: FileObject) = apply {
                    fileData = fileObject.fileData
                    fileId = fileObject.fileId
                    fileName = fileObject.fileName
                    additionalProperties = fileObject.additionalProperties.toMutableMap()
                }

                /**
                 * The base64 encoded file data, used when passing the file to the model as a
                 * string.
                 */
                fun fileData(fileData: String) = fileData(JsonField.of(fileData))

                /**
                 * The base64 encoded file data, used when passing the file to the model as a
                 * string.
                 */
                fun fileData(fileData: JsonField<String>) = apply { this.fileData = fileData }

                /** The ID of an uploaded file to use as input. */
                fun fileId(fileId: String) = fileId(JsonField.of(fileId))

                /** The ID of an uploaded file to use as input. */
                fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                /** The name of the file, used when passing the file to the model as a string. */
                fun fileName(fileName: String) = fileName(JsonField.of(fileName))

                /** The name of the file, used when passing the file to the model as a string. */
                fun fileName(fileName: JsonField<String>) = apply { this.fileName = fileName }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                fun build(): FileObject =
                    FileObject(fileData, fileId, fileName, additionalProperties.toImmutable())
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is FileObject && fileData == other.fileData && fileId == other.fileId && fileName == other.fileName && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(fileData, fileId, fileName, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FileObject{fileData=$fileData, fileId=$fileId, fileName=$fileName, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is File && file == other.file && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(file, type, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "File{file=$file, type=$type, additionalProperties=$additionalProperties}"
    }
}
