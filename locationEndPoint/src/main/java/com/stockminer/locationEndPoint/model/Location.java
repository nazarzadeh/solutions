
package com.stockminer.locationEndPoint.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({
        "name",
        "city",
        "zip",
        "streetAndNumber",
        "openingHours",
        "keywords",
        "lat",
        "lng"
})

public class Location {

    public String name;
    public String zip;
    public String city;
    public Double lat;
    public Double lng;
    public String streetAndNumber;
    public List<Object> keywords = null;
    public List<OpeningHour> openingHours = null;

    @JsonIgnore
    public String identifier;
    @JsonIgnore
    public Integer id;
    @JsonIgnore
    public String dateCreated;
    @JsonIgnore
    public String lastUpdated;
    @JsonIgnore
    public String street;
    @JsonIgnore
    public String streetNo;
    @JsonIgnore
    public Object addressExtra;
    @JsonIgnore
    public Object cellphone;
    @JsonIgnore
    public Object fax;
    @JsonIgnore
    public String website;
    @JsonIgnore
    public Object email;
    @JsonIgnore
    public Object descriptionShort;
    @JsonIgnore
    public Object descriptionLong;
    @JsonIgnore
    public Object openingHoursNotes;
    @JsonIgnore
    public Object lastSyncStarted;
    @JsonIgnore
    public String country;
    @JsonIgnore
    public Object imprint;
    @JsonIgnore
    public Boolean addressDisplay;
    @JsonIgnore
    public Boolean autoSync;
    @JsonIgnore
    public Boolean skipFacebookPicturesUpdate;
    @JsonIgnore
    public String phone;
    @JsonIgnore
    public String status;
    @JsonIgnore
    public String cleansingStatus;
    @JsonIgnore
    public Object cleansingInvalidDataReason;
    @JsonIgnore
    public List<Photo> photos = null;
    @JsonIgnore
    public List<Object> labels = null;
    @JsonIgnore
    public List<Integer> categories = null;
    @JsonIgnore
    public Boolean locationSyncable;
    @JsonIgnore
    public Integer businessId;
    @JsonIgnore
    public Object socialPostId;
    @JsonIgnore
    public Boolean hasFacebook;
    @JsonIgnore
    public String endDate;
    @JsonIgnore
    public Integer averageRating;
    @JsonIgnore
    public List<Object> specialOpeningHours = null;
    @JsonIgnore
    public Boolean openNow;
    @JsonIgnore
    public List<Object> attributes = null;
    @JsonIgnore
    public Integer activeDirectoriesCount;
    @JsonIgnore
    public Integer activeListingsCount;
    @JsonIgnore
    public Integer publishedListingsCount;
    @JsonIgnore
    public Integer profileCompleteness;
    @JsonIgnore
    public List<String> missingMandatoryFields = null;
    @JsonIgnore
    public List<String> directoriesMissingConnect = null;
    @JsonIgnore
    public Integer listingsInSync;
    @JsonIgnore
    public Integer listingsBeingUpdated;
    @JsonIgnore
    public Integer visibilityIndex;
    @JsonIgnore
    public Integer dataPoints;
    @JsonIgnore
    public String province;
    @JsonIgnore
    public Boolean suggestionsForFieldsAvailable;
}
