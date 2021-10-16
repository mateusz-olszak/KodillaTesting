package com.kodilla.patterns2.facade;

import com.kodilla.patterns2.facade.api.ItemDto;
import com.kodilla.patterns2.facade.api.OrderDto;
import com.kodilla.patterns2.facade.api.OrderFacade;
import com.kodilla.patterns2.facade.api.OrderProcessingException;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AspectOrderFacadeTestSuite {

    private Logger LOGGER = LoggerFactory.getLogger(AspectOrderFacadeTestSuite.class);

    @Autowired
    private OrderFacade orderFacade;

    @Test
    void testAspectLogsForOrderProccessMethod() {
        // Given
        OrderDto order = new OrderDto();
        order.addItem(new ItemDto(10L, 2));
        order.addItem(new ItemDto(216L, 1));
        order.addItem(new ItemDto(25L, 1));
        order.addItem(new ItemDto(11L, 3));
        // When Then
        try {
            LOGGER.info("Testing method orderProccess... start");
            orderFacade.proccessOrder(order,1L);
            LOGGER.info("Testing method orderProccess... end");
        } catch (OrderProcessingException e) {
            LOGGER.error("Testing method orderProccess... error");
        }
    }
}
