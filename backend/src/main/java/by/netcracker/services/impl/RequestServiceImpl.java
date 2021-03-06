package by.netcracker.services.impl;

import by.netcracker.entities.RequestEntity;
import by.netcracker.repository.RequestRepository;
import by.netcracker.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class RequestServiceImpl implements RequestService {

    private RequestRepository requestRepository;

    @Autowired
    public void setRequestRepository(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public List<RequestEntity> findAllRequests() {
        return (List<RequestEntity>) requestRepository.findAll();
    }

    @Override
    public List<RequestEntity> findAllRequestsByAvailable() {
        return this.requestRepository.findAllByStatuspractice("Available");
    }

    @Override
    public RequestEntity findOneRequest(Integer idRequest) {
        return this.requestRepository.findOne(idRequest);
    }

    @Override
    public void addRequest(RequestEntity requestEntity) {
        this.requestRepository.save(requestEntity);
    }

    @Override
    public void deleteRequestList(List<RequestEntity> requestEntities) {
        this.requestRepository.delete(requestEntities);
    }

    @Override
    public void deleteRequestById(Integer idRequest) {
        this.requestRepository.delete(idRequest);
    }

    @Override
    public List<RequestEntity> requestEntitiesAfterCurentDate() {
        return this.requestRepository.requestEntitiesAfterCurentDate();
    }
}
