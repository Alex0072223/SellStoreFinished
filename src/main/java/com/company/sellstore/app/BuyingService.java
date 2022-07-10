package com.company.sellstore.app;

import com.company.sellstore.entity.Buying;
import com.company.sellstore.entity.SellPosition;
import io.jmix.core.DataManager;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BuyingService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BuyingService.class);
    @Autowired
    private DataManager dataManager;



    public Integer getCountFrom(Integer count){
        return dataManager.loadValue("select e.count from SellPosition e " +
                "where e.count = :count", Integer.class)
                .parameter("count", count)
                .one();

    }

    public void updateAfterBuy(Integer positionsFromUser, UUID idFromRetailer){

        SellPosition sp = dataManager.load(SellPosition.class).id(idFromRetailer).one();
        sp.setCount(sp.getCount() - positionsFromUser);
        dataManager.save(sp);

    }

}