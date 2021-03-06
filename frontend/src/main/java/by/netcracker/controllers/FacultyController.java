package by.netcracker.controllers;

import by.netcracker.entities.FacultyEntity;
import by.netcracker.models.FacultyViewModel;

import by.netcracker.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FacultyController {


    private ConversionService conversionService;
    private FacultyService facultyService;

    @Autowired
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Autowired
    public void setFacultyService(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    private final TypeDescriptor facultyEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyEntity.class));
    private final TypeDescriptor facultyViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyViewModel.class));


    @RequestMapping(value = "/facultyList", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultyViewModel> getAllFacultiesForTypeahead() {
        List<FacultyEntity> facultyEntities = this.facultyService.getAllFaculties();
        return (List<FacultyViewModel>) this.conversionService.convert(facultyEntities,facultyEntityTypeDescriptor,facultyViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/faculty", method = RequestMethod.POST)
    @ResponseBody
    public boolean AddFaculty(@RequestBody FacultyViewModel facultyViewModel) {
        FacultyEntity facultyEntity = this.conversionService.convert(facultyViewModel, FacultyEntity.class);
        List<FacultyEntity> facultyEntities = this.facultyService.getAllFaculties();
        for (FacultyEntity faculty : facultyEntities){
            if (faculty.getNamefaculty().toUpperCase().equals(facultyEntity.getNamefaculty().toUpperCase())){
                return false;
            }
        }
        this.facultyService.addFaculty(facultyEntity);
        return true;
    }


}
