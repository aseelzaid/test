package special.event;

import components.Checker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import repositories.EventRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Search {
    List<Event> resultEvents = new ArrayList<>();


    @Given("I am on the search page")
    public void iAmOnTheVendorSearchPage() { }

    @When("I select search by event name {string}")
    public void iSelectSearchByEventName(String existSearchName) {
        this.resultEvents = Checker.checkNameOfEvent(existSearchName);
        if(resultEvents.isEmpty())
            resultEvents=null;
    }


    @When("I submit the search")
    public void iSubmitTheSearch() { }

    @Then("I should see the events with this name")
    public void iShouldSeeTheEventsWithNameIfTheyExist() {
        assertNotNull(resultEvents);
    }
    @Then("I should not see the events with name {string}")
    public void iShouldNotSeeTheEventsWithName(String nonExistSearchName) {
        this.resultEvents = Checker.checkNameOfEvent(nonExistSearchName);
        if(resultEvents.isEmpty())
            resultEvents=null;
        assertNull(resultEvents);
    }
    @Then("The meesage no result appears")
    public void theMeesageNoResultAppears() {

    }

    @When("I select search by event name {string} and event location {string}")
    public void iSelectSearchByEventNameAndEventLocation(String existSearchName, String existSearchLocation) {
        this.resultEvents = Checker.checkNameAndLocationOfEvent(existSearchName,existSearchLocation);
        if(resultEvents.isEmpty())
            resultEvents=null;
        assertNotNull(resultEvents);
    }
    @Then("I should see the events with this name in the required location")
    public void iShouldSeeTheEventsWithThisNameInTheRequiredLocation() {

    }
    @When("I select search by event name {string} or event location {string}")
    public void iSelectSearchByEventNameOrEventLocation(String nonExistSearchName, String nonExistSearchLocation) {
        this.resultEvents = Checker.checkNameAndLocationOfEvent(nonExistSearchName,nonExistSearchLocation);
        if(resultEvents.isEmpty())
            resultEvents=null;
    }


    @Then("I should not see the events with name {string} and location {string}")
    public void iShouldNotSeeTheEventsWithNameAndLocation() {
        assertNull(resultEvents);
    }

    @When("I select search by event name {string} and the price range between Min Price {string} and Max Price {string}")
    public void iSelectSearchByEventNameAndThePriceRangeBetweenMinPriceAndMaxPrice(String string, String string2, String string3) {
        this.resultEvents = Checker.checkNameAndPriceOfEvent(string,Float.parseFloat(string2),Float.parseFloat(string3));
        if(resultEvents.isEmpty())
            resultEvents=null;
        assertNotNull(resultEvents);
    }
    @Then("I should see the events with this name and within this price")
    public void iShouldSeeTheEventsWithThisNameAndWithinThisPrice() {

    }
    @When("I select search by event name {string} or  no event within the price range Min Price {string} and Max Price {string}")
    public void iSelectSearchByEventNameOrNoEventWithinThePriceRangeMinPriceAndMaxPrice(String string, String string2, String string3) {
        this.resultEvents = Checker.checkNameAndPriceOfEvent(string,Float.parseFloat(string2),Float.parseFloat(string3));
        if(resultEvents.isEmpty())
            resultEvents=null;
        assertNull(resultEvents);
    }
    @Then("I should not see any result")
    public void iShouldNotSeeAnyResult() {  }

    @When("I select search by event name {string} ,event location {string} and event price range between Min Price {string} and Max Price {string}")
    public void iSelectSearchByEventNameEventLocationAndEventPriceRangeBetweenMinPriceAndMaxPrice(String string, String string2, String string3, String string4) {
        this.resultEvents = Checker.checkNameLocationAndPriceOfEvent(string,string2,Float.parseFloat(string3),Float.parseFloat(string4));
        if(resultEvents.isEmpty())
            resultEvents=null;
        assertNotNull(resultEvents);
    }
    @Then("I should see the events with this name and within this price in the required location")
    public void iShouldSeeTheEventsWithThisNameAndWithinThisPriceInTheRequiredLocation() {

    }
    @When("I select search by event name {string} or event location {string} or or  no event within the price range Min Price {string} and Max Price {string}")
    public void iSelectSearchByEventNameEventLocationAndEventWithinThePriceRangeMinPriceAndMaxPrice(String string, String string2, String string3, String string4) {
        this.resultEvents = Checker.checkNameLocationAndPriceOfEvent(string,string2,Float.parseFloat(string3),Float.parseFloat(string4));
        if(resultEvents.isEmpty())
            resultEvents=null;
        assertNull(resultEvents);
    }

    @When("I select to show all events")
    public void iSelectToShowAllEvents() {

    }
    @When("I need to see all events")
    public void iNeedToSeeAllEvents() {

    }
    @Then("I should see all events")
    public void iShouldSeeAllEvents() {
        this.resultEvents = EventRepository.events;
    }
}