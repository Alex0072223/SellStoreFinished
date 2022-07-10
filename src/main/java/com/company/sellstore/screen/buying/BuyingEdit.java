package com.company.sellstore.screen.buying;

import com.company.sellstore.app.BuyingService;
import com.company.sellstore.entity.Detail;
import com.company.sellstore.entity.SellPosition;
import io.jmix.core.DataManager;
import io.jmix.core.FluentValuesLoader;
import io.jmix.ui.Dialogs;
import io.jmix.ui.action.DialogAction;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.sellstore.entity.Buying;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.IntrospectionException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@UiController("Buying.edit")
@UiDescriptor("buying-edit.xml")
@EditedEntityContainer("buyingDc")
public class BuyingEdit extends StandardEditor<Buying> {
    private static final Logger log = LoggerFactory.getLogger(BuyingEdit.class);

    @Autowired
    private BuyingService buyingService;
    @Autowired
    private Dialogs dialogs;
    int countOfDetailsFromRetailer, countOfDetailsFromCustomer;
    UUID f;



    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {


        if (countOfDetailsFromCustomer > countOfDetailsFromRetailer) {
            dialogs.createOptionDialog()
                    .withCaption("Error!")
                    .withMessage("Нельзя купить больше деталей чем имеется!")
                    .withActions(
                            /*new DialogAction(DialogAction.Type.OK).withHandler(e -> {
                                event.resume();
                            }),*/
                            new DialogAction(DialogAction.Type.OK)
                    )
                    .show();
            event.preventCommit();
        }
        else {
            buyingService.updateAfterBuy(countOfDetailsFromCustomer, f);
        }
    }

    @Subscribe("countField")
    public void onCountFieldValueChange(HasValue.ValueChangeEvent<Integer> event) {
        countOfDetailsFromCustomer =  event.getValue();
    }

    @Subscribe("sellPositionField")
    public void onSellPositionFieldValueChange(HasValue.ValueChangeEvent<SellPosition> event) {

        f = Objects.requireNonNull(event.getValue()).getId();

        countOfDetailsFromRetailer = buyingService.getCountFrom(event.getValue().getCount());

    }
}