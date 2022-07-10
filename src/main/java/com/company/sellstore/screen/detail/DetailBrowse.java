package com.company.sellstore.screen.detail;

import io.jmix.ui.screen.*;
import com.company.sellstore.entity.Detail;

@UiController("Detail.browse")
@UiDescriptor("detail-browse.xml")
@LookupComponent("detailsTable")
public class DetailBrowse extends StandardLookup<Detail> {
}