//libmariadbclient.so
//libmariadb.so
//libmariadb-dev
//mysql.so

//#include <mysql.h>
#include </usr/include/mariadb/mysql.h>

#include <sys/types.h>
#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

#define IPMysql "db"
#define PuertoMysql "33060" 

void funcionMysql(char dabasename[],char query[],char respuesta[]);

int main(void){
  char respuesta[1024];
  puts("running");
  funcionMysql("bd2","select * from tabla;",respuesta);
  return 0;
}

void funcionMysql(char dabasename[],char query[],char respuesta[]) {
  MYSQL *conn; // variable de conexión para MySQL 
  MYSQL_RES *res; // variable que contendra el resultado de la consuta 
  MYSQL_ROW row; // variable que contendra los campos por cada registro consultado 
  char *server = IPMysql ; //direccion del motor MySql
  char *user = "bd2"; //usuario para consultar la base de datos 
  char *password = "bd2"; // contraseña para el usuario  
  char *database = dabasename; //nombre de la base de datos a consultar 	
  conn = mysql_init(NULL); //inicializacion  

  memset(respuesta,0,1024);

	/* conectar a la base de datos */
	if (!mysql_real_connect(conn, server, user, password, database, 0, NULL, 0)) { 
    /* definir los parámetros de la conexión antes establecidos */
    puts("not connected");
    puts(mysql_error(conn));/* si hay un error definir cual fue dicho error */
    //strcat(respuesta,"\0");  
	} else {
    puts("conected");
    /* enviar consulta SQL */
    //	if (mysql_query(conn, "select * from tabla01"))
    if (mysql_query(conn, query)){ /* definicion de la consulta y el origen de la conexion */
      puts("Query error");
      puts(mysql_error(conn));
      printf(respuesta, "%s\n", mysql_error(conn));
      strcat(respuesta,"\0");  
    } else {
      puts("Query OK");
      res = mysql_use_result(conn);
      if (res == NULL) {
        strcpy(respuesta,"ok query\0");
        puts("Query is NULL");
      } else {
        puts("Query returns");
        int num_attrib = mysql_num_fields(res);
        while ((row = mysql_fetch_row(res)) != NULL) { 
          /* recorrer la variable res con todos los registros obtenidos para su uso */
          // printf("%s\t%s\t%s \n", row[0],row[1]); /* la variable row se convierte en un arreglo por el numero de campos que hay en la tabla */
          int i;
          for (i = 0 ; i < num_attrib ; i++) {
            puts(row[i]);
            strcat(respuesta,row[i]);
            strcat(respuesta,"  ");
          }
        puts("");
        strcat(respuesta,"\n");
        }
      puts("that's all");
      strcat(respuesta,"\0");
      mysql_free_result(res);
      }
    }
  /* se libera la variable res y se cierra la conexión */
	mysql_close(conn);
  puts("end");
  }
}

