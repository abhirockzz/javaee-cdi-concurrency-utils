## To run

- `git clone` the project and execute `mvn clean install`
- Deploy `javaee-cdi-concurrency-utils.war` in `target` directory to any of the [Java EE 7 containers](http://www.oracle.com/technetwork/java/javaee/overview/compatibility-jsp-136984.html)

## To check

- execute a HTTP `POST` to `http://localhost:8080/javaee-cdi-concurrency-utils/tasks/` - this initiates a task and returns the task ID
- execute a HTTP `GET` to `http://localhost:8080/javaee-cdi-concurrency-utils/tasks/<taskID>` - it will give you a JSON payload with the task details
- `POST` a few more tasks....
- execute a HTTP `GET` to `http://localhost:8080/javaee-cdi-concurrency-utils/tasks/all` to get a JSON payload of all the tasks