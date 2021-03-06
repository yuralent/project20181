package by.netcracker.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "faculty", schema = "netcracker", catalog = "")
public class FacultyEntity {
    private int id;
    private String namefaculty;
    private Collection<SpecialityEntity> specialtiesById;

    @Id
    @Column(name = "idfaculty", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @NotEmpty(message="Faculty cannot be empty")
    @Size(min=1,max=3,message="Size should be between 1 to 8")
    @Column(name = "name_faculty", nullable = false)
    public String getNamefaculty() {
        return namefaculty;
    }

    public void setNamefaculty(String namefaculty) {
        this.namefaculty = namefaculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacultyEntity that = (FacultyEntity) o;

        if (id != that.id) return false;
        return namefaculty != null ? namefaculty.equals(that.namefaculty) : that.namefaculty == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (namefaculty != null ? namefaculty.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "facultyByFaculty")
    public Collection<SpecialityEntity> getSpecialtiesById() {
        return specialtiesById;
    }

    public void setSpecialtiesById(Collection<SpecialityEntity> specialtiesById) {
        this.specialtiesById = specialtiesById;
    }
}
