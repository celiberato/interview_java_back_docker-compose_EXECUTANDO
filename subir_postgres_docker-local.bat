rem https://www.optimadata.nl/blogs/3/n8dyr5-how-to-run-postgres-on-docker-part-1
rem ------------------------------------

rem docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres
rem docker ps
rem docker exec -it some-postgres bash
rem su postgres
rem psql
rem \conninfo	
rem \q
rem docker ps

rem -------------------------------------

docker pull postgres:latest

docker stop local-postgres

docker rm local-postgres

docker system prune

docker run --name local-postgres -p 5433:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres

docker ps