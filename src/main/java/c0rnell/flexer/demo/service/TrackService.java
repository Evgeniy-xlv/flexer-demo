package c0rnell.flexer.demo.service;

import c0rnell.flexer.demo.repo.TrackRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackService {

    private final TrackRepo trackRepo;

    @PostConstruct
    public void init() {
        trackRepo.findAllByConditional(List.of(1L, 2L, 3L), null, null, null);
        trackRepo.findAllByConditional(null, List.of(1L), null, null);
        trackRepo.findAllByConditional(null, List.of(1L), List.of(2L), null);
    }
}
