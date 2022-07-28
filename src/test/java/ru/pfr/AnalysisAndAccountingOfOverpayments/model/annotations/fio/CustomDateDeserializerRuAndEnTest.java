package ru.pfr.AnalysisAndAccountingOfOverpayments.model.annotations.fio;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.pfr.AnalysisAndAccountingOfOverpayments.model.annotations.fio.CustomDateDeserializerRuAndEn;

import java.io.IOException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomDateDeserializerRuAndEnTest {

    CustomDateDeserializerRuAndEn deserializer;
    JsonParser parser;
    DeserializationContext context;

    @BeforeEach
    void setup() {
        deserializer = new CustomDateDeserializerRuAndEn();
        parser = mock(JsonParser.class);
        context = mock(DeserializationContext.class);
    }

    @Test
    void whenAllAcceptableRU() throws IOException {
        when(parser.getText()).thenReturn("22.07.2022");

        LocalDate result = deserializer.deserialize(parser, context);

        System.out.println(result);
        assertThat(result.getYear()).isEqualTo(2022);
        assertThat(result.getMonthValue()).isEqualTo(7);
        assertThat(result.getDayOfMonth()).isEqualTo(22);
    }

    @Test
    void whenAllAcceptableEN() throws IOException {
        when(parser.getText()).thenReturn("2022-07-22");

        LocalDate result = deserializer.deserialize(parser, context);

        System.out.println(result);
        assertThat(result.getYear()).isEqualTo(2022);
        assertThat(result.getMonthValue()).isEqualTo(7);
        assertThat(result.getDayOfMonth()).isEqualTo(22);
    }

    @Test
    void whenIncorrect() {
        try {
            when(parser.getText()).thenReturn("2022-07-70");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertThatThrownBy(() -> deserializer.deserialize(parser, context))
                .hasMessageContaining("DateTime parse exception");

    }

}