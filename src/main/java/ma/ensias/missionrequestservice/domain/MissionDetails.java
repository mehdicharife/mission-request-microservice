package ma.ensias.missionrequestservice.domain;

import java.io.Serializable;

import jakarta.persistence.Embeddable;


@Embeddable
public class MissionDetails implements Serializable {
    private String title;

    private String description;

    public MissionDetails() {

    }

    public MissionDetails(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
