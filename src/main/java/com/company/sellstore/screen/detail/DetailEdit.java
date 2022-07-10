package com.company.sellstore.screen.detail;

import io.jmix.ui.screen.*;
import com.company.sellstore.entity.Detail;

@UiController("Detail.edit")
@UiDescriptor("detail-edit.xml")
@EditedEntityContainer("detailDc")
public class DetailEdit extends StandardEditor<Detail> {
}