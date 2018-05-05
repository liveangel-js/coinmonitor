package org.liveangel.A.domain;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "symbol",
        "date",
        "ticker"
})
public class TickerTape {

    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("date")
    private String date;
    @JsonProperty("ticker")
    private Ticker ticker;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public TickerTape withSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    public TickerTape withDate(String date) {
        this.date = date;
        return this;
    }

    @JsonProperty("ticker")
    public Ticker getTicker() {
        return ticker;
    }

    @JsonProperty("ticker")
    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    public TickerTape withTicker(Ticker ticker) {
        this.ticker = ticker;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public TickerTape withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("symbol", symbol).append("date", date).append("ticker", ticker).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(ticker).append(symbol).append(additionalProperties).append(date).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TickerTape) == false) {
            return false;
        }
        TickerTape rhs = ((TickerTape) other);
        return new EqualsBuilder().append(ticker, rhs.ticker).append(symbol, rhs.symbol).append(additionalProperties, rhs.additionalProperties).append(date, rhs.date).isEquals();
    }

}