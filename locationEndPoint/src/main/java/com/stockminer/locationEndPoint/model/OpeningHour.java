
package com.stockminer.locationEndPoint.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dayOfWeek",
    "from1",
    "to1"
})
public class OpeningHour {

    @JsonProperty("dayOfWeek")
    public Integer dayOfWeek;
    @JsonProperty("from1")
    public String from1;
    @JsonProperty("to1")
    public String to1;
}
