# kotlin-monorepo-poc

A kotlin-gradle-spring monorepo for a classic REST backend.

### Run the database 
```
cd docker
docker-compose up
```

### Build the database running
  - db/users/up.sql
  - db/posts/up.sql
  
### Start the services
  - `gradle :infrastructure:monolyth:bootRun` Monolyth, port 8080
  - `gradle :infrastructure:ms-users:bootRun` ms-users, port 8081
  - `gradle :infrastructure:ms-posts:bootRun` ms-posts, port 8082

`ms-posts` requires `ms-users` to be running, `monolyth` can be ran standalone.