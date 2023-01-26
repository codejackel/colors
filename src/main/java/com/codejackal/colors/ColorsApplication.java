package com.codejackal.colors;

import com.codejackal.colors.domain.AppArgs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
@Slf4j
public class ColorsApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ColorsApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional.ofNullable(args.getOptionValues("color")).map(v -> v.get(0)).ifPresent(AppArgs::setColor);
        Optional.ofNullable(args.getOptionValues("message")).map(v -> v.get(0)).ifPresent(AppArgs::setMessage);
        log.info("Arguments: {}", AppArgs.toLogString());
    }
}
