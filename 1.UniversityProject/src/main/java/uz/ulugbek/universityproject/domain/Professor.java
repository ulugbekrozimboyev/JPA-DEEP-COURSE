package uz.ulugbek.universityproject.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "professors")
@Data
public class Professor {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "professor", fetch = FetchType.EAGER)
    private List<Course> courses;

    @Embedded
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "email",
                    column = @Column(name = "personal_email")
            ),
            @AttributeOverride(
                    name = "phone",
                    column = @Column(name = "personal_phone")
            ),
    })
    private Contact personalContact;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "email",
                    column = @Column(name = "business_email")
            ),
            @AttributeOverride(
                    name = "phone",
                    column = @Column(name = "business_phone")
            ),
    })
    private Contact businessContact;

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Address {
        private String street;
        private String city;
        private String postalCode;

    }

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Contact {
        private String email;
        private String phone;

    }

}
