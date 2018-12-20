package com.fassine.configuration;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.fassine.service.BancoService;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {
	
	// INJECTIONS
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final EntityManagerFactory entityManagerFactory;
	private final BancoService bancoService;
	@Qualifier("tManager")
	private final PlatformTransactionManager platformTransactionManager1;
	
	@Autowired
	public JobConfiguration(final JobBuilderFactory jobBuilderFactory,
			final StepBuilderFactory stepBuilderFactory,
			final EntityManagerFactory entityManagerFactory,
			final BancoService bancoService,
			final PlatformTransactionManager platformTransactionManager1
			//final PlatformTransactionManager platformTransactionManager2
			) {
		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
		this.entityManagerFactory = entityManagerFactory;
		this.bancoService = bancoService;
		this.platformTransactionManager1 = platformTransactionManager1;
	}
	
	// STEPS
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("gravaRegistros").tasklet(new Tasklet() {
			@Override
			public RepeatStatus execute(final StepContribution contribution, final ChunkContext chunkContext) throws Exception {
				bancoService.insereBanco1();
				return RepeatStatus.FINISHED;
			}
		})
				.transactionManager(platformTransactionManager1)
				.build();
	}
	
	@Bean
	public Job testMultiplesDatabases() throws Exception {
		return jobBuilderFactory.get("testMultiplesDatabases")
				.start(step1())
				.build();
	}
}
