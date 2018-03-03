package ljusas.com.concerts.net.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offer {

@SerializedName("type")
@Expose
private String type;
@SerializedName("url")
@Expose
private String url;
@SerializedName("status")
@Expose
private String status;

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

}