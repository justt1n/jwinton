Create service structure (after download project from https://start.spring.io/ and place it in the root folder of the project) 
```shell
make create-service-structure SERVICE_NAME={name}
```
The structure of the service will be created in the `{name} service` folder base on DDD architecture.
```
{name}
├── {name}Application.java
├── application
│   ├── configs
│   ├── constants
│   ├── properties
│   ├── services
│   └── utils
├── domain
├── infrastructure
│   ├── entities
│   ├── repositories
│   └── dao
├── mapper
└── presentation
    ├── controllers
    ├── dto
    └── validators
```
