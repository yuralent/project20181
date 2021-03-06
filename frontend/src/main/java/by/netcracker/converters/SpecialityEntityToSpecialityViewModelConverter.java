package by.netcracker.converters;

import by.netcracker.entities.SpecialityEntity;
import by.netcracker.models.FacultyViewModel;
import by.netcracker.models.SpecialityViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class SpecialityEntityToSpecialityViewModelConverter implements Converter<SpecialityEntity, SpecialityViewModel> {

    @Override
    public SpecialityViewModel convert(SpecialityEntity specialityEntity) {
        SpecialityViewModel specialityViewModel = new SpecialityViewModel();
        specialityViewModel.setIdSpeciality(String.valueOf(specialityEntity.getId()));
        specialityViewModel.setNamespeciality(specialityEntity.getNamespeciality());
        //specialityViewModel.setIdSpeciality(String.valueOf(specialityEntity.getFacultyId()));
        return specialityViewModel;
    }
}
