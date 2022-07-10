package com.company.sellstore.screen.sellposition;

import io.jmix.ui.screen.*;
import com.company.sellstore.entity.SellPosition;

@UiController("SellPosition.edit")
@UiDescriptor("sell-position-edit.xml")
@EditedEntityContainer("sellPositionDc")
public class SellPositionEdit extends StandardEditor<SellPosition> {
}