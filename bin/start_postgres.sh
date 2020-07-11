docker run --name pg-docker -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=dev -d -p 5432:5432  postgres
docker stop pg-docker
docker container start pg-docker
