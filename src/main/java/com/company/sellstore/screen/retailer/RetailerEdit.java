package com.company.sellstore.screen.retailer;

import io.jmix.ui.Dialogs;
import io.jmix.ui.app.inputdialog.DialogActions;
import io.jmix.ui.app.inputdialog.DialogOutcome;
import io.jmix.ui.app.inputdialog.InputParameter;
import io.jmix.ui.component.HasContextHelp;
import io.jmix.ui.component.TextField;
import io.jmix.ui.screen.*;
import com.company.sellstore.entity.Retailer;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Retailer.edit")
@UiDescriptor("retailer-edit.xml")
@EditedEntityContainer("retailerDc")

public class RetailerEdit extends StandardEditor<Retailer> {
    @Autowired
    private Dialogs dialogs;
    @Autowired
    private TextField<String> adressField;

    @Install(to = "adressField", subject = "contextHelpIconClickHandler")
    private void adressFieldContextHelpIconClickHandler(
            HasContextHelp.ContextHelpIconClickEvent event) {
        dialogs.createInputDialog(this)
                .withCaption("Get values")
                .withParameters(
                        InputParameter.stringParameter("city")
                                .withCaption("City:")
                                .withRequired(true),
                        InputParameter.stringParameter("street")
                                .withCaption("Street:"),
                        InputParameter.stringParameter("building")
                                .withCaption("Building:"),
                        InputParameter.intParameter("number")
                                .withCaption("number:")
                )
                .withActions(DialogActions.OK_CANCEL)
                .withCloseListener(closeEvent -> {
                    if (closeEvent.closedWith(DialogOutcome.OK)) {
                        String city = closeEvent.getValue("city");
                        String street = closeEvent.getValue("street");
                        String building = closeEvent.getValue("building");
                        Integer zip = closeEvent.getValue("number");
                        adressField.setValue(city + ", " + street + ", " +
                                building + ", " + zip);
                    }
                })
                .show();
    }
}