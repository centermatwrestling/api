package com.centermat.api.io.rest;

import com.centermat.api.driver.AbstractDriver;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.util.UUID;

@CrossOrigin
public abstract class AbstractRestController<T> {
    protected AbstractDriver<T> driver;
    protected Class<T> clazz;

    public AbstractRestController(Class<T> clazz,AbstractDriver<T> driver) {
        this.clazz = clazz;
        this.driver = driver;
    }

    @ApiOperation(value = "Schema definition")
    @RequestMapping(method = RequestMethod.GET, path = "/schema")
    public JsonSchema getSchema() throws JsonMappingException {
        final JsonSchema jsonSchema = new ObjectMapper().generateJsonSchema(clazz);
        final JsonNode properties = jsonSchema.getSchemaNode().get("properties");
        for (JsonNode property : properties) {
        }
        return jsonSchema;
    }

    @ApiOperation(value = "Sample/Example of type")
    @RequestMapping(method = RequestMethod.GET, path = "/example")
    public abstract T getExample();

    @ApiOperation(value = "Collection of type")
    @RequestMapping(method = RequestMethod.GET)
    public List<T> get() {
        return driver.fetchAll();
    }

    @ApiOperation(value = "Single instance of type")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public T get(@PathVariable UUID id) {
        return driver.findOne(id);
    }
}
