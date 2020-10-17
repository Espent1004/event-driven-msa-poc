package com.eventdrivenmsapoc.altinnservice.altinn;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.eventdrivenmsapoc.buildingblocks.altinn.AltinnData;
import com.eventdrivenmsapoc.buildingblocks.altinn.AltinnData.Debt;


@Service
public class AltinnProxyMock implements AltinnProxy {

    @Value(value = "${altinn.proxy.fail}")
    private boolean shouldThrowException;

    @Override
    public AltinnData getTaxData() {
        if (shouldThrowException) {
            throw new RuntimeException("Failed");
        }
        AltinnData altinnData = new AltinnData();
        altinnData.setIncome(1000000L);
        List<Debt> debtList = Arrays.asList(new Debt(200000L, "DNB"), new Debt(30000L, "Bank Norwegain"), new Debt(70000L, "Lånekassen"));
        altinnData.setDebts(debtList);
        return altinnData;
    }
}
