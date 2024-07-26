package main.java.com.devon.signal_graphic.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SignalData implements java.io.Serializable {
    private Integer id;

    @JsonProperty("INFO_TIME")
    private String infoTime;


    @JsonProperty("COUNTY_ID")
    private Integer countyId;

    @JsonProperty("COUNTY")
    private String county;

    @JsonProperty("TOWN_ID")
    private Integer townId;

    @JsonProperty("TOWN")
    private String town;

    @JsonProperty("NIGHT_WORK")
    private Double nightWork = (double) 0;

    //    @JsonProperty("`DAY_WORK(7:00~13:00)`")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private Double dayWorkMorning = (double) 0;

    //    @JsonProperty("`DAY_WORK(13:00~19:00)`")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private Double dayWorkAfternoon = (double) 0;

    @JsonProperty("DAY_WORK")
    private Double dayWork;

    @JsonProperty("NIGHT_WEEKEND")
    private Double nightWeekend = (double) 0;


    //    @JsonProperty("`DAY_WEEKEND(7:00~13:00)`")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private Double dayWeekendMorning = (double) 0;

    //    @JsonProperty("`DAY_WEEKEND(13:00~19:00)`")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private Double dayWeekendAfternoon = (double) 0;

    @JsonProperty("`DAY_WEEKEND`")
    private Double dayWeekend = (double) 0;

    @JsonProperty("MORNING_WORK")
    private Double morningWork = (double) 0;

    @JsonProperty("MIDDAY_WORK")
    private Double middayWork = (double) 0;

    @JsonProperty("AFTERNOON_WORK")
    private Double afternoonWork = (double) 0;

    @JsonProperty("EVENING_WORK")
    private Double eveningWork = (double) 0;

    @JsonProperty("MORNING_WEEKEND")
    private Double morningWeekend = (double) 0;

    @JsonProperty("MIDDAY_WEEKEND")
    private Double middayWeekend = (double) 0;

    @JsonProperty("AFTERNOON_WEEKEND")
    private Double afternoonWeekend = (double) 0;

    @JsonProperty("EVENING_WEEKEND")
    private Double eveningWeekend = (double) 0;

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfoTime() {
        return infoTime;
    }

    public void setInfoTime(String infoTime) {
        this.infoTime = infoTime;
    }

    public Integer getCountyId() {
        return countyId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Integer getTownId() {
        return townId;
    }

    public void setTownId(Integer townId) {
        this.townId = townId;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Double getNightWork() {
        return nightWork;
    }

    public void setNightWork(Double nightWork) {
        this.nightWork = nightWork;
    }

    public Double getMiddayWork() {
        return middayWork;
    }

    public void setMiddayWork(Double middayWork) {
        this.middayWork = middayWork;
    }

    public Double getDayWorkMorning() {
        return dayWorkMorning;
    }

    public void setDayWorkMorning(Double dayWorkMorning) {
        this.dayWorkMorning = dayWorkMorning;
    }

    public Double getDayWorkAfternoon() {
        return dayWorkAfternoon;
    }

    public void setDayWorkAfternoon(Double dayWorkAfternoon) {
        this.dayWorkAfternoon = dayWorkAfternoon;
    }

    public Double getDayWork() {
        return dayWork;
    }

    public void setDayWork(Double dayWork) {
        this.dayWork = dayWork;
    }

    public Double getNightWeekend() {
        return nightWeekend;
    }

    public void setNightWeekend(Double nightWeekend) {
        this.nightWeekend = nightWeekend;
    }

    public Double getDayWeekendMorning() {
        return dayWeekendMorning;
    }

    public void setDayWeekendMorning(Double dayWeekendMorning) {
        this.dayWeekendMorning = dayWeekendMorning;
    }

    public Double getDayWeekendAfternoon() {
        return dayWeekendAfternoon;
    }

    public void setDayWeekendAfternoon(Double dayWeekendAfternoon) {
        this.dayWeekendAfternoon = dayWeekendAfternoon;
    }

    public Double getDayWeekend() {
        return dayWeekend;
    }

    public void setDayWeekend(Double dayWeekend) {
        this.dayWeekend = dayWeekend;
    }

    public Double getMorningWork() {
        return morningWork;
    }

    public void setMorningWork(Double morningWork) {
        this.morningWork = morningWork;
    }

    public Double getAfternoonWork() {
        return afternoonWork;
    }

    public void setAfternoonWork(Double afternoonWork) {
        this.afternoonWork = afternoonWork;
    }

    public Double getEveningWork() {
        return eveningWork;
    }

    public void setEveningWork(Double eveningWork) {
        this.eveningWork = eveningWork;
    }

    public Double getMorningWeekend() {
        return morningWeekend;
    }

    public void setMorningWeekend(Double morningWeekend) {
        this.morningWeekend = morningWeekend;
    }

    public Double getMiddayWeekend() {
        return middayWeekend;
    }

    public void setMiddayWeekend(Double middayWeekend) {
        this.middayWeekend = middayWeekend;
    }

    public Double getAfternoonWeekend() {
        return afternoonWeekend;
    }

    public void setAfternoonWeekend(Double afternoonWeekend) {
        this.afternoonWeekend = afternoonWeekend;
    }

    public Double getEveningWeekend() {
        return eveningWeekend;
    }

    public void setEveningWeekend(Double eveningWeekend) {
        this.eveningWeekend = eveningWeekend;
    }

    @Override
    public String toString() {
        return "SignalData{" +
                "id=" + id +
                ", infoTime='" + infoTime + '\'' +
                ", countyId=" + countyId +
                ", county='" + county + '\'' +
                ", town='" + town + '\'' +
                ", townId=" + townId +
                ", nightWork=" + nightWork +
                ", dayWorkMorning=" + dayWorkMorning +
                ", dayWorkAfternoon=" + dayWorkAfternoon +
                ", dayWork=" + dayWork +
                ", nightWeekend=" + nightWeekend +
                ", dayWeekendMorning=" + dayWeekendMorning +
                ", dayWeekendAfternoon=" + dayWeekendAfternoon +
                ", dayWeekend=" + dayWeekend +
                ", morningWork=" + morningWork +
                ", afternoonWork=" + afternoonWork +
                ", eveningWork=" + eveningWork +
                ", morningWeekend=" + morningWeekend +
                ", middayWeekend=" + middayWeekend +
                ", afternoonWeekend=" + afternoonWeekend +
                ", eveningWeekend=" + eveningWeekend +
                '}';
    }
}