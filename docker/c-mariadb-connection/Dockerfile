FROM gcc:12.2

COPY code/conexion.c /bd2/
WORKDIR /bd2

RUN apt install libmariadb3 libmariadb-dev

RUN gcc -o conexion conexion.c $(mariadb_config --include --libs)

CMD ["./conexion"]