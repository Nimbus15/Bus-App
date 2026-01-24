package com.belfastdev.view;

import com.belfastdev.model.BusRoute;
import com.belfastdev.model.BusRouteStop;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("Busroutesstops")
@PageTitle("Bus Routes Stops")
public class BusRouteStopView extends VerticalLayout {

    private final Grid<BusRouteStop> grid;

    public BusRouteStopView(){
        grid = new Grid<>(BusRouteStop.class);
        grid.removeAllColumns();
        grid.addColumn(BusRouteStop::getId).setHeader("Route Stop ID");
        grid.addColumn(BusRouteStop::getName).setHeader("Route Stop Name");

        // Hardcoded test data
        List<BusRouteStop> testBusRoutesStops = List.of(
                new BusRouteStop("S1", "Stop 123"),
                new BusRouteStop("S2", "Stop 456")
        );

        grid.setItems(testBusRoutesStops);
        add(grid);
        setSizeFull();
    }

}

