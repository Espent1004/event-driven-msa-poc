package com.eventdrivenmsapoc.altinnservice.altinn;

import com.eventdrivenmsapoc.buildingblocks.altinn.AltinnData;

public interface AltinnService {

    AltinnData getAltinnData(String userId, Long orderId);
}
