# Music playlist


### Create custom docker network
`docker network create --driver bridge music-net`

### Run Postgres DB (dockerized)
`docker run --network music-net -p 5432:5432 --name music-postgres --rm -e POSTGRES_DB=musicdb -e POSTGRES_PASSWORD=OPEN -d postgres`

### Build the app image
`docker build -t music:dev .`
`