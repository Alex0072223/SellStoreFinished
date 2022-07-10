package com.company.sellstore.screen.sellposition;

import io.jmix.ui.screen.*;
import com.company.sellstore.entity.SellPosition;

@UiController("SellPosition.browse")
@UiDescriptor("sell-position-browse.xml")
@LookupComponent("sellPositionsTable")
public class SellPositionBrowse extends StandardLookup<SellPosition> {

}