## To run

- `git clone` the project and execute `mvn clean install`
- Deploy `javaee-cdi-concurrency-utils.war` in `target` directory to any of the [Java EE 7 containers](http://www.oracle.com/technetwork/java/javaee/overview/compatibility-jsp-136984.html)

## To check

- execute a HTTP `POST` to `http://localhost:8080/javaee-cdi-concurrency-utils/tasks/` - [this initiates a task](https://github.com/abhirockzz/javaee-cdi-concurrency-utils/blob/master/src/main/java/com/wordpress/abhirockzz/cdi/concutils/TasksResource.java#L27) and returns the task ID

![](https://abhirockzz.files.wordpress.com/2017/04/1.jpg)

- execute a HTTP `GET` to `http://localhost:8080/javaee-cdi-concurrency-utils/tasks/<taskID>` - [it will give you a JSON payload](https://github.com/abhirockzz/javaee-cdi-concurrency-utils/blob/master/src/main/java/com/wordpress/abhirockzz/cdi/concutils/TasksResource.java#L40) with the task details

![](https://abhirockzz.files.wordpress.com/2017/04/2.jpg)

- `POST` a few more tasks....
- execute a HTTP `GET` to `http://localhost:8080/javaee-cdi-concurrency-utils/tasks/all` [to get a JSON payload of all the tasks](https://github.com/abhirockzz/javaee-cdi-concurrency-utils/blob/master/src/main/java/com/wordpress/abhirockzz/cdi/concutils/TasksResource.java#L50)

![](https://abhirockzz.files.wordpress.com/2017/04/3.jpg)
