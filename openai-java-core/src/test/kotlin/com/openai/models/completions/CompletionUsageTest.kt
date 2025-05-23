// File generated from our OpenAPI spec by Stainless.

package com.openai.models.completions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CompletionUsageTest {

    @Test
    fun create() {
        val completionUsage =
            CompletionUsage.builder()
                .completionTokens(0L)
                .promptTokens(0L)
                .totalTokens(0L)
                .completionTokensDetails(
                    CompletionUsage.CompletionTokensDetails.builder()
                        .acceptedPredictionTokens(0L)
                        .audioTokens(0L)
                        .reasoningTokens(0L)
                        .rejectedPredictionTokens(0L)
                        .build()
                )
                .promptTokensDetails(
                    CompletionUsage.PromptTokensDetails.builder()
                        .audioTokens(0L)
                        .cachedTokens(0L)
                        .build()
                )
                .build()

        assertThat(completionUsage.completionTokens()).isEqualTo(0L)
        assertThat(completionUsage.promptTokens()).isEqualTo(0L)
        assertThat(completionUsage.totalTokens()).isEqualTo(0L)
        assertThat(completionUsage.completionTokensDetails())
            .contains(
                CompletionUsage.CompletionTokensDetails.builder()
                    .acceptedPredictionTokens(0L)
                    .audioTokens(0L)
                    .reasoningTokens(0L)
                    .rejectedPredictionTokens(0L)
                    .build()
            )
        assertThat(completionUsage.promptTokensDetails())
            .contains(
                CompletionUsage.PromptTokensDetails.builder()
                    .audioTokens(0L)
                    .cachedTokens(0L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val completionUsage =
            CompletionUsage.builder()
                .completionTokens(0L)
                .promptTokens(0L)
                .totalTokens(0L)
                .completionTokensDetails(
                    CompletionUsage.CompletionTokensDetails.builder()
                        .acceptedPredictionTokens(0L)
                        .audioTokens(0L)
                        .reasoningTokens(0L)
                        .rejectedPredictionTokens(0L)
                        .build()
                )
                .promptTokensDetails(
                    CompletionUsage.PromptTokensDetails.builder()
                        .audioTokens(0L)
                        .cachedTokens(0L)
                        .build()
                )
                .build()

        val roundtrippedCompletionUsage =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(completionUsage),
                jacksonTypeRef<CompletionUsage>(),
            )

        assertThat(roundtrippedCompletionUsage).isEqualTo(completionUsage)
    }
}
