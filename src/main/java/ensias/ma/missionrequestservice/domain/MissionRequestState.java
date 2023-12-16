package ensias.ma.missionrequestservice.domain;

import jakarta.persistence.*;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Inheritance
@DiscriminatorColumn(name="name")
public abstract class MissionRequestState implements Serializable, Cloneable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Autowired
    @Transient
    protected static MissionRequestStateFactory missionRequestStateFactory;

    abstract MissionRequestState  cancel(MissionRequest missionRequest);
    abstract MissionRequestState approve(MissionRequest missionRequest);
    abstract MissionRequestState reject(MissionRequest missionRequest);


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public abstract void accept(MissionRequestStateVisitor visitor);

}
