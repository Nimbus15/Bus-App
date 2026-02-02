package com.belfastdev.view;

import com.belfastdev.model.BusRoute;
import com.belfastdev.service.BusTrackerApiClient;
import com.belfastdev.startercode.ui.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Select Route | Bus Tracker")
public class BusRouteView extends VerticalLayout {

    private final BusTrackerApiClient apiClient;
    public BusRouteView(BusTrackerApiClient apiClient) {
        this.apiClient = apiClient;

        add(new H2("Select Your Bus Route"));

        loadRoutes();
    }

    private void loadRoutes() {
        apiClient.getAllBusRoutes()
                .collectList()  // Convert Flux to List
                .subscribe(routes -> {
                    // This runs when data arrives
                    getUI().ifPresent(ui -> ui.access(() -> {
                        displayRoutes(routes);
                    }));
                });
    }

    private void displayRoutes(List<BusRoute> routes) {
        routes.forEach(route -> {
            Button btn = new Button(route.getName());
            btn.addClickListener(e -> navigateToStops(route.getId()));
            add(btn);
        });
    }

    private void navigateToStops(String routeId) {
        getUI().ifPresent(ui -> ui.navigate("stops/" + routeId));
    }

    private void handleRouteClick(String routeName) {
        Notification.show("You selected: " + routeName, 3000, Notification.Position.MIDDLE);
        // Later: navigate to stops view
    }

    private void createTestRouteButtons() {
        String[] testRoutes = {
                "1A - City Centre to Airport",
                "2B - University to Train Station",
                "3C - Hospital Loop"
        };

        for (String route : testRoutes) {
            Button btn = new Button(route);
            btn.addClickListener(e -> handleRouteClick(route));
            btn.addClassName("route-button");
            add(btn);
        }
    }
}
