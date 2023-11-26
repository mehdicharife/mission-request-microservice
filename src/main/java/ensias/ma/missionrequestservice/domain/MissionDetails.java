package ensias.ma.missionrequestservice.domain;

import jakarta.persistence.Embeddable;

//import java.time.LocalDate;


@Embeddable
public class MissionDetails {
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
