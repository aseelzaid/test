package components;

import repositories.EventRepository;
import special.event.Event;

import java.util.ArrayList;
import java.util.List;

public class Checker {
    protected static final List<Event> resultEvents = new ArrayList<>();
    private Checker() {
    }

    public static List<Event> checkNameOfEvent(String searchName) {
        resultEvents.clear();
        String nameOfEvent;
        for (Event event : EventRepository.events) {
            nameOfEvent = event.getNameOfEvent();
            if (nameOfEvent.contains(searchName)) {
                resultEvents.add(event);
            }
        }


        return resultEvents;


    }
    public static List<Event> checkNameAndLocationOfEvent(String searchName,String searchLocation) {
        resultEvents.clear();
        String nameOfEvent;
        String locationOfEvent;
        for (Event event : EventRepository.events) {
            nameOfEvent = event.getNameOfEvent();
            locationOfEvent = event.getEventLocation();

            if ((nameOfEvent.contains(searchName))
                    &&(locationOfEvent.contains(searchLocation))) {

                resultEvents.add(event);
            }
        }

        return resultEvents;


    }
    public static List<Event> checkNameAndPriceOfEvent(String searchName,float minPrice,float maxPrice) {
        resultEvents.clear();
        String nameOfEvent;
        float costOfEvent;
        float minPriceOfEvent = minPrice;
        float maxPriceOfEvent = maxPrice;

        for (Event event : EventRepository.events) {
            nameOfEvent = event.getNameOfEvent();
            costOfEvent = event.getCostOfEvent();

            if ( (nameOfEvent.contains(searchName) )
                    &&(minPriceOfEvent <= costOfEvent)
                    &&(costOfEvent <= maxPriceOfEvent) ) {

                resultEvents.add(event);
            }
        }

        return resultEvents;


    }
    public static List<Event> checkNameLocationAndPriceOfEvent(String searchName,String searchLocation,float minPrice,float maxPrice) {
        resultEvents.clear();
        String nameOfEvent;
        String locationOfEvent;
        float costOfEvent;
        float minPriceOfEvent = minPrice;
        float maxPriceOfEvent = maxPrice;

        for (Event event : EventRepository.events) {
            nameOfEvent = event.getNameOfEvent();
            costOfEvent = event.getCostOfEvent();
            locationOfEvent = event.getEventLocation();
            if ( (nameOfEvent.contains(searchName) )
                    &&(minPriceOfEvent <= costOfEvent)
                    &&(costOfEvent <= maxPriceOfEvent)
                    &&(locationOfEvent.contains(searchLocation))) {

                resultEvents.add(event);
            }
        }

        return resultEvents;


    }

}