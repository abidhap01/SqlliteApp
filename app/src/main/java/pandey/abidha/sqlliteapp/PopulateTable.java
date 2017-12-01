package pandey.abidha.sqlliteapp;

/**
 * Created by achintyadwivedi on 11/29/17.
 */

public class PopulateTable {
    public String Date;
    public String eventName;
    public String eventPlace;
    public PopulateTable() {

    }
    public PopulateTable(String date, String eventName, String eventPlace) {
        Date = date;
        this.eventName = eventName;
        this.eventPlace = eventPlace;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }
}
