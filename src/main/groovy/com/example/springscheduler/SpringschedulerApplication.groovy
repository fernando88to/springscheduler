package com.example.springscheduler

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

@SpringBootApplication
class SpringschedulerApplication {

	static void main(String[] args) {
		SpringApplication.run(SpringschedulerApplication, args)
	}

	@Scheduled(fixedRate = 1000l)
	@Async
	void someJob(){
		def numero = new Random().nextInt(10)
		println "inicio job ${numero}"

		println "fim job  ${numero}"
	}
	@Scheduled(fixedRate = 2000l)
	void someJob2(){
		println "some job  2 in ${new Date()}"
	}

}

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
class SchedulingConfiguration {


}
