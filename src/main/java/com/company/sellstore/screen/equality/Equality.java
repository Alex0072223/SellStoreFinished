package com.company.sellstore.screen.equality;

import com.company.sellstore.entity.Detail;
import com.company.sellstore.entity.SellPosition;
import io.jmix.ui.ScreenTools;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.AppWorkArea;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.Window;
import io.jmix.ui.component.mainwindow.Drawer;
import io.jmix.ui.icon.JmixIcon;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Equality")
@UiDescriptor("equality-screen.xml")
@Route(path = "equality", root = true)
public class Equality extends Screen implements Window.HasWorkArea {

    @Autowired
    private ScreenTools screenTools;

    @Autowired
    private AppWorkArea workArea;
    @Autowired
    private CollectionLoader<Detail> detailsDl;
    @Autowired
    private CollectionLoader<SellPosition> sellPositionsDl;


    @Override
    public AppWorkArea getWorkArea() {
        return workArea;
    }

    /*@Subscribe("collapseDrawerButton")
    private void onCollapseDrawerButtonClick(Button.ClickEvent event) {
        drawer.toggle();
        if (drawer.isCollapsed()) {
            collapseDrawerButton.setIconFromSet(JmixIcon.CHEVRON_RIGHT);
        } else {
            collapseDrawerButton.setIconFromSet(JmixIcon.CHEVRON_LEFT);
        }
    }*/

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        screenTools.openDefaultScreen(
                UiControllerUtils.getScreenContext(this).getScreens());

        screenTools.handleRedirect();
    }

    @Subscribe("refreshAction")
    public void onRefreshAction(Action.ActionPerformedEvent event) {
        detailsDl.load();
        sellPositionsDl.load();
        
    }

    @Subscribe(id = "detailsDc", target = Target.DATA_CONTAINER)
    public void onDetailsDcItemChange(InstanceContainer.ItemChangeEvent<Detail> event) {

        sellPositionsDl.setParameter("fullName", event.getItem());
        sellPositionsDl.load();

    }

}
