import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.eventdrivenmsapoc.altinnservice.altinn.AltinnProxy;
import com.eventdrivenmsapoc.altinnservice.altinn.AltinnService;
import com.eventdrivenmsapoc.altinnservice.altinn.AltinnServiceImpl;
import com.eventdrivenmsapoc.altinnservice.kafka.MessageProducer;


class AltinnServiceTests {

    private AltinnService service;
    @Mock
    private AltinnProxy altinnProxy;
    @Mock
    private MessageProducer messageProducer;

    @BeforeEach
    public void setUp() {
        altinnProxy = mock(AltinnProxy.class);
        messageProducer = mock(MessageProducer.class);
        service = new AltinnServiceImpl(altinnProxy, messageProducer);
    }

    @Test
    void whenCircuitBreakerIsUsed_thenItWorksAsExpected() {
        when(altinnProxy.getTaxData()).thenThrow(new RuntimeException("Failed"));
        for (int i = 0; i < 100; i++) {
            try {
                service.getAltinnData("1234", 1L);
            } catch (Exception ignore) {
            }
        }
        verify(altinnProxy, times(10)).getTaxData();
        verify(messageProducer, times(0)).publishEvent(any());
    }
}
