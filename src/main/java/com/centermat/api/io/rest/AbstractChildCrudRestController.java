package com.centermat.api.io.rest;

import com.centermat.api.driver.AbstractChildDriver;
import com.centermat.api.driver.AbstractDriver;
import com.centermat.api.model.BaseModel;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@CrossOrigin
public abstract class AbstractChildCrudRestController<T extends BaseModel, R extends JpaRepository<T,UUID>, D extends AbstractChildDriver<T,R>> implements ChildCrudRestController<T> {
    protected static final UUID example_id = UUID.fromString("00000000-0000-0000-0000-000000000000");

    protected D driver;
    protected Class<T> clazz;

    public AbstractChildCrudRestController(Class<T> clazz, D driver) {
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
        return driver.fetchAll(parentId, pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public T get(@PathVariable UUID parentId, @PathVariable UUID id, @RequestParam(required = false) String fields,@RequestParam(required = false) boolean loadAll) {
        return driver.findOne(id, loadAll);
    }

    public void delete(@PathVariable UUID parentId,@PathVariable UUID id, @RequestHeader(name = "Authorization") String jwtToken) {
        driver.delete(id);
    }

    public UUID post(@PathVariable UUID parentId,@RequestBody T body, @RequestHeader(name = "Authorization") String jwtToken) {
        driver.post(body);
        return body.getId();
    }

    public List<UUID> postBulk(@PathVariable UUID parentId,@RequestBody List<T> b, @RequestHeader(name = "Authorization") String jwtToken) {
        b.forEach(t -> driver.post(t));
        return b.stream().map(t -> t.getId()).collect(Collectors.toList());
    }

    public void put(@PathVariable UUID parentId, @PathVariable UUID id, @RequestBody T body, @RequestHeader(name = "Authorization") String jwtToken) {
        driver.put(id, body);
    }

}
