# Music playlist


### Create custom docker network
`docker network create --driver bridge music-net`

### Run Postgres DB (dockerized)
`docker run --network music-net -p 5432:5432 --name music-postgres --rm -e POSTGRES_DB=musicdb -e POSTGRES_PASSWORD=open -d postgres`

### Build the app image
`docker build -t music:dev .`

### Run the docker app image on developer machine
`docker run --name music --network music-net --rm -e PORT=8080 -e SPRING_PROFILES_ACTIVE=docker -p 9000:8080 -d music:dev`

### Heroku Deployment
URL: https://john-selva-music.herokuapp.com/playlists

