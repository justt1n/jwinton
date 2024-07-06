# Makefile to create service structure

SERVICE_NAME ?=

ifeq ($(SERVICE_NAME),)
$(error SERVICE_NAME is not set. Please provide a service name by running `make create_service_structure SERVICE_NAME=your_service_name`)
endif

create_service_structure:
	mkdir -p $(SERVICE_NAME)/src/main/java/com/jwinton/$(SERVICE_NAME)/application/configs
	mkdir -p $(SERVICE_NAME)/src/main/java/com/jwinton/$(SERVICE_NAME)/application/constants
	mkdir -p $(SERVICE_NAME)/src/main/java/com/jwinton/$(SERVICE_NAME)/application/properties
	mkdir -p $(SERVICE_NAME)/src/main/java/com/jwinton/$(SERVICE_NAME)/application/services
	mkdir -p $(SERVICE_NAME)/src/main/java/com/jwinton/$(SERVICE_NAME)/application/utils
	mkdir -p $(SERVICE_NAME)/src/main/java/com/jwinton/$(SERVICE_NAME)/domain
	mkdir -p $(SERVICE_NAME)/src/main/java/com/jwinton/$(SERVICE_NAME)/infrastructure/entities
	mkdir -p $(SERVICE_NAME)/src/main/java/com/jwinton/$(SERVICE_NAME)/infrastructure/repositories
	mkdir -p $(SERVICE_NAME)/src/main/java/com/jwinton/$(SERVICE_NAME)/mapper
	mkdir -p $(SERVICE_NAME)/src/main/java/com/jwinton/$(SERVICE_NAME)/presentation/controllers
	mkdir -p $(SERVICE_NAME)/src/main/java/com/jwinton/$(SERVICE_NAME)/presentation/dto
	mkdir -p $(SERVICE_NAME)/src/main/java/com/jwinton/$(SERVICE_NAME)/presentation/validators

.PHONY: create_service_structure
