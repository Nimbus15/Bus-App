package com.belfastdev.view;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.belfastdev.model.BusRoute;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("Busroutes")
@PageTitle("Bus Routes")
public class BusRouteView extends VerticalLayout {

    private final Grid<BusRoute> grid;

    public BusRouteView(){
        grid = new Grid<>(BusRoute.class);
        grid.removeAllColumns();
        grid.addColumn(BusRoute::getId).setHeader("Route ID");
        grid.addColumn(BusRoute::getName).setHeader("Route Name");

        // Hardcoded test data
        List<BusRoute> testBusRoutes = List.of(
                new BusRoute("1L", "City Center Loop 1A Downtown route"),
                new BusRoute("2L", "Airport Express 2B Direct to airport")
        );

        grid.setItems(testBusRoutes);
        add(grid);
        setSizeFull();

    }

}
