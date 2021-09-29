import redis

"""
El driver de conexion se llama Redis-py y la forma de instalarlo es:
pip install redis
Se recomienda la utilizacion de entornos virtuales siempre que se realizen desarrollos con librerias en python.
"""

PORT = 16379
IP = 'localhost'
VARIABLE = "mensaje"
CONEXIONES = "conexiones"

print("Conectandose a la BD")
r = redis.Redis(host=IP, port=PORT, decode_responses=True)

cont = r.get(CONEXIONES)
var = r.get(VARIABLE)

print("Esta es la conexion nro:"+str(cont))
print("La variable dice: \r\n"+str(var))

if cont is None:
    r.set(CONEXIONES, 1)
    r.set(VARIABLE, "Hola")
else:
    r.incr(CONEXIONES, 1)
    if var == 'Hola':
        r.set(VARIABLE, 'Hola Redis')
    elif var == 'Hola Redis':
        r.set(VARIABLE, 'Hola')

print("Desconectando")
r.close()
