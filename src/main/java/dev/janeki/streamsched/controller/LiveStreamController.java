package dev.janeki.streamsched.controller;

import dev.janeki.streamsched.model.LiveStream;
import dev.janeki.streamsched.repository.LiveStreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/streams")
public class LiveStreamController {

  private final LiveStreamRepository repository;

  public LiveStreamController(LiveStreamRepository repository) {
    this.repository = repository;
  }

  // Return all the LiveStream
  // GET http://localhost:8080/streams
  @GetMapping
  public List<LiveStream> findAll() {
    // returns all the streams set up in the live stream repository
    return repository.findAll();
  }

  // Return a particular LiveStream
  // Gives us the ability to get a single live stream
  // GET http://localhost:8080/streams/1242-2342-234234-234
  @GetMapping("/{id}")
  public LiveStream findById(@PathVariable String id) { //PathVariable pulls  the string ID out of the path
    return repository.findById(id);
  }

  // Create a new LiveStream
  // POST http://localhost:8080/streams
  @ResponseStatus(HttpStatus.CREATED) // points out that the post has been created
  @PostMapping
  public LiveStream create(@Valid @RequestBody LiveStream stream) {
    return repository.create(stream);
  }

  // GET http://localhost:8080/streams/1242-2342-234234-234
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PutMapping("/{id}")
  public void update(@RequestBody LiveStream stream, @PathVariable String id) {
    repository.update(stream,id);
  }

  // DELETE http://localhost:8080/streams/1242-2342-234234-234
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    repository.delete(id);
  }
}
