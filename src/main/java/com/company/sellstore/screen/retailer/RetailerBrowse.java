package com.company.sellstore.screen.retailer;

import io.jmix.ui.screen.*;
import com.company.sellstore.entity.Retailer;

@UiController("Retailer.browse")
@UiDescriptor("retailer-browse.xml")
@LookupComponent("retailersTable")
public class RetailerBrowse extends StandardLookup<Retailer> {
}