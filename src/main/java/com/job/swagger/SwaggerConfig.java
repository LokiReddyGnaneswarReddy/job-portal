package com.job.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Job Portal API",
        version = "1.0",
        description = "API documentation for the Job Portal",
        contact = @Contact(
            name = "Gnaneswar reddy",
            email = "gnaneswarreddy579@gmail.com",
            url = "https://www.linkedin.com/in/gnaneswar-reddy-lokireddy-726a32296"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0"
        )
    )
)
public class SwaggerConfig {
}
