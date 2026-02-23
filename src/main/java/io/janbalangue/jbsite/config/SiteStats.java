package io.janbalangue.jbsite.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Central place for site-wide "stats" (followers, subscribers, versions, etc).
 * <p>
 * Values are configured in application.properties under the prefix: site.stats.*
 */
@Component
@ConfigurationProperties(prefix = "site.stats")
public class SiteStats {

    private String soundcloudFollowers = "0";
    private Integer substackSubscribers = 0;
    private String substackFollowers = "0";
    private String substackSince = "";

    private String youtubeSubscribers = "0";
    private String youtubeSince = "";

    private String bulkheadVersion = "";
    private String tsBulkheadVersion = "";

    public String getSoundcloudFollowers() {
        return soundcloudFollowers;
    }

    public void setSoundcloudFollowers(String soundcloudFollowers) {
        this.soundcloudFollowers = soundcloudFollowers;
    }

    public Integer getSubstackSubscribers() {
        return substackSubscribers;
    }

    public void setSubstackSubscribers(Integer substackSubscribers) {
        this.substackSubscribers = substackSubscribers;
    }

    public String getSubstackFollowers() {
        return substackFollowers;
    }

    public void setSubstackFollowers(String substackFollowers) {
        this.substackFollowers = substackFollowers;
    }

    public String getSubstackSince() {
        return substackSince;
    }

    public void setSubstackSince(String substackSince) {
        this.substackSince = substackSince;
    }

    public String getYoutubeSubscribers() {
        return youtubeSubscribers;
    }

    public void setYoutubeSubscribers(String youtubeSubscribers) {
        this.youtubeSubscribers = youtubeSubscribers;
    }

    public String getYoutubeSince() {
        return youtubeSince;
    }

    public void setYoutubeSince(String youtubeSince) {
        this.youtubeSince = youtubeSince;
    }

    public String getBulkheadVersion() {
        return bulkheadVersion;
    }

    public void setBulkheadVersion(String bulkheadVersion) {
        this.bulkheadVersion = bulkheadVersion;
    }

    public String getTsBulkheadVersion() {
        return tsBulkheadVersion;
    }

    public void setTsBulkheadVersion(String tsBulkheadVersion) {
        this.tsBulkheadVersion = tsBulkheadVersion;
    }
}