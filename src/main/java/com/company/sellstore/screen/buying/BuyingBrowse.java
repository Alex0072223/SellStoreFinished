package com.company.sellstore.screen.buying;

import io.jmix.ui.screen.*;
import com.company.sellstore.entity.Buying;

@UiController("Buying.browse")
@UiDescriptor("buying-browse.xml")
@LookupComponent("buyingsTable")
public class BuyingBrowse extends StandardLookup<Buying> {
}