package com.lmt.fabricanteback.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.lmt.fabricanteback.repository.*")
@ComponentScan(basePackages = { "com.lmt.fabricanteback.product.service.*" })
@EntityScan("com.lmt.fabricanteback.product.entity.*")
public class ConfiguracaoJpa {
}