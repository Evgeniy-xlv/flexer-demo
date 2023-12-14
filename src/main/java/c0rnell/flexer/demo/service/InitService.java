package c0rnell.flexer.demo.service;

import c0rnell.flexer.demo.repo.HouseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class InitService {

    private final HouseRepo houseRepo;

    @PostConstruct
    public void init() {
        System.out.println("all true true");
        System.out.println(houseRepo.findAllTest(true, true));
        System.out.println("all false false");
        System.out.println(houseRepo.findAllTest(false, false));
        System.out.println("all false true");
        System.out.println(houseRepo.findAllTest(false, true));
        System.out.println("all true false");
        System.out.println(houseRepo.findAllTest(true, false));
    }
}
