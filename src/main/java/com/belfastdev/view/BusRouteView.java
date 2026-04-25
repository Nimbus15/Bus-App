package com.belfastdev.view;

import com.belfastdev.model.BusRoute;
import com.belfastdev.service.BusTrackerService;
import com.belfastdev.startercode.ui.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Select Route | Bus Tracker")
public class BusRouteView extends VerticalLayout {

    private final BusTrackerService busTrackerService;

    public BusRouteView(BusTrackerService busTrackerService) {
        this.busTrackerService = busTrackerService;

        add(new H2("Select Your Bus Route"));

        loadRoutes();
    }

    private void loadRoutes() {
        busTrackerService.getAllBusRoutes()
                .collectList()
                .subscribe(routes -> getUI().ifPresent(ui -> ui.access(() -> displayRoutes(routes))));
    }

    private void displayRoutes(List<BusRoute> routes) {
        routes.forEach(route -> {
            Button btn = new Button(route.getName());
            btn.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("stops/" + route.getId())));
            add(btn);
        });
    }
}
