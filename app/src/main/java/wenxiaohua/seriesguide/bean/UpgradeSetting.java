package wenxiaohua.seriesguide.bean;

import android.text.TextUtils;

/**
 * 版本更新数据
 */
public class UpgradeSetting {

    private String downloadUrl;
    private String releaseNotes;
    private String update;
    private String versionCode;
    private String versionName;
    private boolean isForcedUpdate;

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getReleaseNotes() {
        return releaseNotes;
    }

    public void setReleaseNotes(String releaseNotes) {
        this.releaseNotes = releaseNotes;
    }

    public String isUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public int getVersionCode() {
        try {
            if (!TextUtils.isEmpty(versionCode)) {
                return Integer.parseInt(versionCode);
            }
        } catch (NumberFormatException e) {

        }
        return 0;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public boolean isForcedUpdate() {
        return isForcedUpdate;
    }

    public void setIsForcedUpdate(boolean isForcedUpdate) {
        this.isForcedUpdate = isForcedUpdate;
    }
}
