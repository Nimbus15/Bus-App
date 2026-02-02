package com.belfastdev.startercode.ui;

import com.belfastdev.service.BusTrackerApiClient;
import com.belfastdev.view.BusJourneyView;
import com.belfastdev.view.BusRouteView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.menu.MenuConfiguration;
import com.vaadin.flow.server.menu.MenuEntry;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.springframework.beans.factory.annotation.Autowired;

@Layout
public final class MainLayout extends AppLayout {
    public MainLayout() {
        createHeader();
        createDrawer();
    }
    private void createHeader() {
        H1 logo = new H1("🚌 Belfast Bus Tracker");
        logo.addClassNames("text-l", "m-m");

        addToNavbar(new DrawerToggle(), logo);
    }

    private void createDrawer() {
        // Navigation links will go here
        addToDrawer(new VerticalLayout(
                createNavLink("Routes", BusRouteView.class)

        ));
    }

    private RouterLink createNavLink(String text, Class<? extends Component> view) {
        RouterLink link = new RouterLink(text, view);
        link.addClassNames("nav-link");
        return link;
    }
}
