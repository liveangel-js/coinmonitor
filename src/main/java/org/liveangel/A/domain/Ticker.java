package org.liveangel.A.domain;

/**
 * Created by liveangel on 2018-5-5.
 */
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
        "buy",
        "high",
        "last",
        "low",
        "sell",
        "vol"
})
public class Ticker {

    /**
     * 买一价
     */
    @JsonProperty("buy")
    private String buy;
    /**
     * 24小时最高
     */
    @JsonProperty("high")
    private String high;
    /**
     * 最新成交价
     */
    @JsonProperty("last")
    private String last;
    /**
     * 24小时最低价
     */
    @JsonProperty("low")
    private String low;
    /**
     * 卖一价
     */
    @JsonProperty("sell")
    private String sell;
    /**
     * 24小时成交量
     */
    @JsonProperty("vol")
    private String vol;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("buy")
    public String getBuy() {
        return buy;
    }

    @JsonProperty("buy")
    public void setBuy(String buy) {
        this.buy = buy;
    }

    public Ticker withBuy(String buy) {
        this.buy = buy;
        return this;
    }

    @JsonProperty("high")
    public String getHigh() {
        return high;
    }

    @JsonProperty("high")
    public void setHigh(String high) {
        this.high = high;
    }

    public Ticker withHigh(String high) {
        this.high = high;
        return this;
    }

    @JsonProperty("last")
    public String getLast() {
        return last;
    }

    @JsonProperty("last")
    public void setLast(String last) {
        this.last = last;
    }

    public Ticker withLast(String last) {
        this.last = last;
        return this;
    }

    @JsonProperty("low")
    public String getLow() {
        return low;
    }

    @JsonProperty("low")
    public void setLow(String low) {
        this.low = low;
    }

    public Ticker withLow(String low) {
        this.low = low;
        return this;
    }

    @JsonProperty("sell")
    public String getSell() {
        return sell;
    }

    @JsonProperty("sell")
    public void setSell(String sell) {
        this.sell = sell;
    }

    public Ticker withSell(String sell) {
        this.sell = sell;
        return this;
    }

    @JsonProperty("vol")
    public String getVol() {
        return vol;
    }

    @JsonProperty("vol")
    public void setVol(String vol) {
        this.vol = vol;
    }

    public Ticker withVol(String vol) {
        this.vol = vol;
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

    public Ticker withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("buy", buy).append("high", high).append("last", last).append("low", low).append("sell", sell).append("vol", vol).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(vol).append(last).append(sell).append(buy).append(additionalProperties).append(high).append(low).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Ticker) == false) {
            return false;
        }
        Ticker rhs = ((Ticker) other);
        return new EqualsBuilder().append(vol, rhs.vol).append(last, rhs.last).append(sell, rhs.sell).append(buy, rhs.buy).append(additionalProperties, rhs.additionalProperties).append(high, rhs.high).append(low, rhs.low).isEquals();
    }

}
