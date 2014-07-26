package com.objectpartners.blog.dropwizard.guice

import com.fasterxml.jackson.annotation.JsonProperty
import com.yammer.dropwizard.config.Configuration
import com.yammer.dropwizard.db.DatabaseConfiguration

import javax.validation.Valid
import javax.validation.constraints.NotNull

class EchoConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty
    DatabaseConfiguration database = new DatabaseConfiguration()

    @Valid
    @NotNull
    @JsonProperty
    DatabaseConfiguration database2 = new DatabaseConfiguration()
}
