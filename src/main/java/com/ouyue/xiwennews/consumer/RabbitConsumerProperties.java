package com.ouyue.xiwennews.consumer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author :tongjingji01@gmail.com
 * @program:xiwen-news
 * @description:
 * @create:2019-10-21 11-43
 */
@Component
@ConfigurationProperties(prefix = "rabbit.consumer")
@PropertySource("classpath:rabbit-mq-consumer.properties")
public class RabbitConsumerProperties {

    private String intervals;

    private long maxInterval;

    private String delaySuffix;

    private String dlxSuffix;

    private Integer concurrentConsumers;

    private Integer maxConcurrentConsumers;

    private Long startConsumerMinInterval;

    private Long stopConsumerMinInterval;

    private Integer consecutiveActiveTrigger;

    private Integer consecutiveIdleTrigger;

    private Integer prefetchCount;

    public String getIntervals() {
        return intervals;
    }

    public void setIntervals(String intervals) {
        this.intervals = intervals;
    }

    public long getMaxInterval() {
        return maxInterval;
    }

    public void setMaxInterval(long maxInterval) {
        this.maxInterval = maxInterval;
    }

    public String getDelaySuffix() {
        return delaySuffix;
    }

    public void setDelaySuffix(String delaySuffix) {
        this.delaySuffix = delaySuffix;
    }

    public String getDlxSuffix() {
        return dlxSuffix;
    }

    public void setDlxSuffix(String dlxSuffix) {
        this.dlxSuffix = dlxSuffix;
    }

    public Integer getConcurrentConsumers() {
        return concurrentConsumers;
    }

    public void setConcurrentConsumers(Integer concurrentConsumers) {
        this.concurrentConsumers = concurrentConsumers;
    }

    public Integer getMaxConcurrentConsumers() {
        return maxConcurrentConsumers;
    }

    public void setMaxConcurrentConsumers(Integer maxConcurrentConsumers) {
        this.maxConcurrentConsumers = maxConcurrentConsumers;
    }

    public Long getStartConsumerMinInterval() {
        return startConsumerMinInterval;
    }

    public void setStartConsumerMinInterval(Long startConsumerMinInterval) {
        this.startConsumerMinInterval = startConsumerMinInterval;
    }

    public Long getStopConsumerMinInterval() {
        return stopConsumerMinInterval;
    }

    public void setStopConsumerMinInterval(Long stopConsumerMinInterval) {
        this.stopConsumerMinInterval = stopConsumerMinInterval;
    }

    public Integer getConsecutiveActiveTrigger() {
        return consecutiveActiveTrigger;
    }

    public void setConsecutiveActiveTrigger(Integer consecutiveActiveTrigger) {
        this.consecutiveActiveTrigger = consecutiveActiveTrigger;
    }

    public Integer getConsecutiveIdleTrigger() {
        return consecutiveIdleTrigger;
    }

    public void setConsecutiveIdleTrigger(Integer consecutiveIdleTrigger) {
        this.consecutiveIdleTrigger = consecutiveIdleTrigger;
    }

    public Integer getPrefetchCount() {
        return prefetchCount;
    }

    public void setPrefetchCount(Integer prefetchCount) {
        this.prefetchCount = prefetchCount;
    }

}
