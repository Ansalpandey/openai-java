// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCodeInterpreterCallCodeDeltaEventTest {

    @Test
    fun create() {
        val responseCodeInterpreterCallCodeDeltaEvent =
            ResponseCodeInterpreterCallCodeDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseCodeInterpreterCallCodeDeltaEvent.delta()).isEqualTo("delta")
        assertThat(responseCodeInterpreterCallCodeDeltaEvent.itemId()).isEqualTo("item_id")
        assertThat(responseCodeInterpreterCallCodeDeltaEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseCodeInterpreterCallCodeDeltaEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCodeInterpreterCallCodeDeltaEvent =
            ResponseCodeInterpreterCallCodeDeltaEvent.builder()
                .delta("delta")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseCodeInterpreterCallCodeDeltaEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCodeInterpreterCallCodeDeltaEvent),
                jacksonTypeRef<ResponseCodeInterpreterCallCodeDeltaEvent>(),
            )

        assertThat(roundtrippedResponseCodeInterpreterCallCodeDeltaEvent)
            .isEqualTo(responseCodeInterpreterCallCodeDeltaEvent)
    }
}
