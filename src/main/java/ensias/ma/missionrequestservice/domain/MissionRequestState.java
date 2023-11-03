package ensias.ma.missionrequestservice.domain;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Inheritance
@DiscriminatorColumn(name="name")
public abstract class MissionRequestState {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Autowired
    @Transient
    protected MissionRequestStateFactory missionRequestStateFactory;

    abstract MissionRequestState  cancel(MissionRequest missionRequest);
    abstract MissionRequestState approve(MissionRequest missionRequest);
    abstract MissionRequestState reject(MissionRequest missionRequest);

    public Long getId() {
        return this.id;
    }

    public abstract void accept(MissionRequestStateVisitor visitor);
}
