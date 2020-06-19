package ssl.ois.timelog.service.log.history;

import java.util.ArrayList;
import java.util.List;

public class HistoryLogUseCaseInput {
    private String userID;
    private String startDate;
    private String endDate;
    private List<String> filter;

    public HistoryLogUseCaseInput() {
        filter = new ArrayList<>();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<String> getFilter() {
        return filter;
    }

    public void setFilter(List<String> filter) {
        this.filter = filter;
    }
}
