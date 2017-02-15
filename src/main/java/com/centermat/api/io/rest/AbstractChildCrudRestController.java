package com.centermat.api.io.rest;

import com.centermat.api.driver.AbstractDriver;
import com.centermat.api.model.BaseModel;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
public abstract class AbstractChildCrudRestController<T extends BaseModel> implements ChildCrudRestController<T> {
    protected static final UUID example_id = UUID.fromString("00000000-0000-0000-0000-000000000000");
    private static final String NAME = "";

    protected AbstractDriver<T> driver;
    protected Class<T> clazz;

    public AbstractChildCrudRestController(Class<T> clazz, AbstractDriver<T> driver) {
        this.clazz = clazz;
        this.driver = driver;
    }

    public JsonSchema getSchema() throws JsonMappingException {
        final JsonSchema jsonSchema = new ObjectMapper().generateJsonSchema(clazz);
        final JsonNode properties = jsonSchema.getSchemaNode().get("properties");
        for (JsonNode property : properties) {
        }
        return jsonSchema;
    }

    public T getExample(UUID parentId, String fields) {
        return getExample();
    }

    public abstract T getExample();

    @ApiOperation(value = "Collection of type")
    @RequestMapping(method = RequestMethod.GET)
    public Page<T> get(@PathVariable UUID parentId,@RequestParam(required = false, defaultValue = "0") Integer page, @RequestParam(required = false, defaultValue = "100") Integer size, @RequestParam(required = false) String fields) throws IOException {
        PageRequest pageable = new PageRequest(page, size);
        return driver.fetchAll(pageable);
    }

    public T get(UUID parentId, UUID id, String fields) {
        return driver.findOne(id);
    }

    public void delete(UUID parentId, UUID id, String jwtToken) {
        driver.delete(id);
    }

    public UUID post(UUID parentId, T body, String jwtToken) {
        driver.post(body);
        return body.getId();
    }

    public List<UUID> postBulk(UUID parentId, List<T> b, String jwtToken) {
        b.forEach(t -> driver.post(t));
        return b.stream().map(t -> t.getId()).collect(Collectors.toList());
    }

    public void put(UUID parentId, UUID id, T body, String jwtToken) {
        driver.put(id, body);
    }

}
