# language: es

Característica: administrar la obtencion de talleres que pueden realizar productos
   Obtiene talleres dentro de la persistencia que pueden fabricar un producto

   Esquema del escenario: Obtener talleres

Dada la siguiente lista de especificaciones de productos
   """
      {
         "productos": [
         {"id": 1,"nombre":"mesa 1.80x0.70",
               "tareas": [
                  {"id": 1,"nombre":"cortar patas","orden": 1,"tiempo": 10,"tipoEquipo": {"id": 1,"nombre":"cierra"
                     }
                  },
                  {"id": 2,"nombre":"cortar tapa","orden": 2,"tiempo": 15,"tipoEquipo": {"id": 1,"nombre":"cierra"
                     }
                  },
                  {"id": 3,"nombre":"pulir patas","orden": 3,"tiempo": 7,"tipoEquipo": {"id": 2,"nombre":"lijadora de banda"
                     }
                  },
                  {"id": 4,"nombre":"pulir tapa","orden": 4,"tiempo": 25,"tipoEquipo": {"id": 2,"nombre":"lijadora de banda"
                     }
                  },
                  {"id": 5,"nombre":"ensamblar y encolar","orden": 5,"tiempo": 45,"tipoEquipo": {"id": 3,"nombre":"mesa ensamblado"
                     }
                  },
                  {"id": 6,"nombre":"pintar y finalizar","orden": 6,"tiempo": 35,"tipoEquipo": {"id": 3,"nombre":"mesa ensamblado"
                     }
                  }
               ]
         },
         {"id": 2,"nombre":"mesa 2x1",
               "tareas": [
                  {"id": 7,"nombre":"cortar patas","orden": 1,"tiempo": 12,"tipoEquipo": {"id": 1,"nombre":"cierra"
                     }
                  },
                  {"id": 8,"nombre":"cortar tapa","orden": 2,"tiempo": 19,"tipoEquipo": {"id": 1,"nombre":"cierra"
                     }
                  },
                  {"id": 9,"nombre":"pulir patas","orden": 3,"tiempo": 10,"tipoEquipo": {"id": 2,"nombre":"lijadora de banda"
                     }
                  },
                  {"id": 10,"nombre":"pulir tapa","orden": 4,"tiempo": 29,"tipoEquipo": {"id": 2,"nombre":"lijadora de banda"
                     }
                  },
                  {"id": 11,"nombre":"ensamblar y encolar","orden": 5,"tiempo": 52,"tipoEquipo": {"id": 3,"nombre":"mesa ensamblado"
                     }
                  },
                  {"id": 12,"nombre":"pintar y finalizar","orden": 5,"tiempo": 41,"tipoEquipo": {"id": 3,"nombre":"mesa ensamblado"
                     }
                  }
               ]
         },
         {"id": 3,"nombre":"silla estándar",
               "tareas": [
                  {"id": 13,"nombre":"cortar patas","orden": 1,"tiempo": 8,"tipoEquipo": {"id": 1,"nombre":"cierra"
                     }
                  },
                  {"id": 14,"nombre":"cortar respaldo","orden": 2,"tiempo": 7,"tipoEquipo": {"id": 1,"nombre":"cierra"
                     }
                  },
                  {"id": 15,"nombre":"cortar asiento","orden": 3,"tiempo": 10,"tipoEquipo": {"id": 1,"nombre":"cierra"
                     }
                  },
                  {"id": 16,"nombre":"pulir patas","orden": 4,"tiempo": 5,"tipoEquipo": {"id": 2,"nombre":"lijadora de banda"
                     }
                  },
                  {"id": 17,"nombre":"pulir respaldo","orden": 5,"tiempo": 4,"tipoEquipo": {"id": 2,"nombre":"lijadora de banda"
                     }
                  },
                  {"id": 18,"nombre":"pulir asiento","orden": 5,"tiempo": 20,"tipoEquipo": {"id": 2,"nombre":"lijadora de banda"
                     }
                  },
                  {"id": 19,"nombre":"ensamblar y encolar","orden": 7,"tiempo": 32,"tipoEquipo": {"id": 3,"nombre":"mesa ensamblado"
                     }
                  },
                  {"id": 20,"nombre":"pintar y finalizar","orden": 8,"tiempo": 23,"tipoEquipo": {"id": 3,"nombre":"mesa ensamblado"
                     }
                  }
               ]
         },
         {"id": 4,"nombre":"banqueta",
               "tareas": [
                  {"id": 21,"nombre":"cortar patas","orden": 1,"tiempo": 8,"tipoEquipo": {"id": 1,"nombre":"cierra"
                     }
                  },
                  {"id": 22,"nombre":"cortar asiento","orden": 2,"tiempo": 10,"tipoEquipo": {"id": 1,"nombre":"cierra"
                     }
                  },
                  {"id": 23,"nombre":"pulir patas","orden": 3,"tiempo": 5,"tipoEquipo": {"id": 2,"nombre":"lijadora de banda"
                     }
                  },
                  {"id": 24,"nombre":"pulir asiento","orden": 4,"tiempo": 20,"tipoEquipo": {"id": 2,"nombre":"lijadora de banda"
                     }
                  },
                  {"id": 25,"nombre":"ensamblar y encolar","orden": 5,"tiempo": 32,"tipoEquipo": {"id": 3,"nombre":"mesa ensamblado"
                     }
                  },
                  {"id": 26,"nombre":"pintar y finalizar","orden": 6,"tiempo": 23,"tipoEquipo": {"id": 3,"nombre":"mesa ensamblado"
                     }
                  }
               ]
         },
         {"id": 5,"nombre":"zocalos de 1.5m",
               "tareas": [
                  {"id": 27,"nombre":"cortar","orden": 1,"tiempo": 5,"tipoEquipo": {"id": 1,"nombre":"cierra"
                     }
                  },
                  {"id": 28,"nombre":"fresar","orden": 2,"tiempo": 6,"tipoEquipo": {"id": 4,"nombre":"fresadora"
                     }
                  },
                  {"id": 29,"nombre":"cepillar","orden": 3,"tiempo": 8,"tipoEquipo": {"id": 5,"nombre":"Cepillo Garlopa"
                     }
                  }
               ]
         },
         {"id": 6,"nombre":"zocalos de 2m",
               "tareas": [
                  {"id": 30,"nombre":"cortar","orden": 1,"tiempo": 5,"tipoEquipo": {"id": 1,"nombre":"cierra"
                     }
                  },
                  {"id": 31,"nombre":"fresar","orden": 2,"tiempo": 7,"tipoEquipo": {"id": 4,"nombre":"fresadora"
                     }
                  },
                  {"id": 32,"nombre":"cepillar","orden": 3,"tiempo": 9,"tipoEquipo": {"id": 5,"nombre":"Cepillo Garlopa"
                     }
                  }
               ]
         },
         {"id": 7,"nombre":"zocalos de 2.5m",
               "tareas": [
                  {"id": 33,"nombre":"cortar","orden": 1,"tiempo": 6,"tipoEquipo": {"id": 1,"nombre":"cierra"
                     }
                  },
                  {"id": 34,"nombre":"fresar","orden": 2,"tiempo": 8,"tipoEquipo": {"id": 4,"nombre":"fresadora"
                     }
                  },
                  {"id": 35,"nombre":"cepillar","orden": 3,"tiempo": 10,"tipoEquipo": {"id": 5,"nombre":"Cepillo Garlopa"
                     }
                  }
               ]
         },
         {"id": 8,"nombre":"puerta estándar",
               "tareas": [
                  {"id": 36,"nombre":"cortar","orden": 1,"tiempo": 25,"tipoEquipo": {"id": 1,"nombre":"cierra"
                     }
                  },
                  {"id": 37,"nombre":"pulir","orden": 2,"tiempo": 28,"tipoEquipo": {"id": 2,"nombre":"lijadora de banda"
                     }
                  },
                  {"id": 38,"nombre":"cepillar","orden": 3,"tiempo": 12,"tipoEquipo": {"id": 5,"nombre":"Cepillo Garlopa"
                     }
                  },
                  {"id": 39,"nombre":"ensamblar y encolar","orden": 4,"tiempo": 31,"tipoEquipo": {"id": 3,"nombre":"mesa ensamblado"
                     }
                  },
                  {"id": 40,"nombre":"fresar","orden": 5,"tiempo": 12,"tipoEquipo": {"id": 4,"nombre":"fresadora"
                     }
                  }
               ]
         },
         {"id": 9,"nombre":"puerta doble",
               "tareas": [
                  {"id": 41,"nombre":"cortar","orden": 1,"tiempo": 50,"tipoEquipo": {"id": 1,"nombre":"cierra"
                     }
                  },
                  {"id": 42,"nombre":"pulir","orden": 2,"tiempo": 56,"tipoEquipo": {"id": 2,"nombre":"lijadora de banda"
                     }
                  },
                  {"id": 43,"nombre":"cepillar","orden": 3,"tiempo": 24,"tipoEquipo": {"id": 5,"nombre":"Cepillo Garlopa"
                     }
                  },
                  {"id": 44,"nombre":"ensamblar y encolar","orden": 4,"tiempo": 62,"tipoEquipo": {"id": 3,"nombre":"mesa ensamblado"
                     }
                  },
                  {"id": 45,"nombre":"fresar","orden": 5,"tiempo": 24,"tipoEquipo": {"id": 4,"nombre":"fresadora"
                     }
                  }
               ]
         },
         {"id": 10,"nombre":"perchero de pie",
               "tareas": [
                  {"id": 46,"nombre":"cortar","orden": 1,"tiempo": 50,"tipoEquipo": {"id": 1,"nombre":"cierra"
                     }
                  },
                  {"id": 47,"nombre":"doblar","orden": 2,"tiempo": 24,"tipoEquipo": {"id": 6,"nombre":"dobladora"
                     }
                  },
                  {"id": 48,"nombre":"ensamblar y encolar","orden": 3,"tiempo": 31,"tipoEquipo": {"id": 3,"nombre":"mesa ensamblado"
                     }
                  },
                  {"id": 49,"nombre":"Lustrar","orden": 4,"tiempo": 24,"tipoEquipo": {"id": 3,"nombre":"mesa ensamblado"
                     }
                  }
               ]
         }
      }
"""

Y el siguiente conjunto de talleres con su layout
"""
{
   "talleres":[
      {"id":1,"codigo":"norte",
         "equipos":[
            {"id":1,"codigo":"cierra norte","capacidad":2,"tipoEquipo":{"id":1,"nombre":"cierra"}},
            {"id":2,"codigo":"lijadora de banda norte","capacidad":3,"tipoEquipo":{"id":2,"nombre":"lijadora de banda"}},
            {"id":3,"codigo":"mesa ensamblado norte 1","capacidad":1,"tipoEquipo":{"id":3,"nombre":"mesa ensamblado"}},
            {"id":4,"codigo":"mesa ensamblado norte 2","capacidad":2,"tipoEquipo":{"id":3,"nombre":"mesa ensamblado"}},
            {"id":5,"codigo":"fresadora norte 1","capacidad":2,"tipoEquipo":{"id":4,"nombre":"fresadora"}},
            {"id":6,"codigo":"fresadora norte 2","capacidad":1,"tipoEquipo":{"id":4,"nombre":"fresadora"}},
            {"id":7,"codigo":"Cepillo Garlopa norte","capacidad":3,"tipoEquipo":{"id":5,"nombre":"Cepillo Garlopa"}}
         ]
      },
      {"id":2,"codigo":"este",
         "equipos":[
            {"id":8,"codigo":"cierra este 1","capacidad":1,"tipoEquipo":{"id":1,"nombre":"cierra"}},
            {"id":9,"codigo":"cierra este 2","capacidad":3,"tipoEquipo":{"id":1,"nombre":"cierra"}},
            {"id":10,"codigo":"lijadora de banda este 1","capacidad":1,"tipoEquipo":{"id":2,"nombre":"lijadora de banda"}},
            {"id":11,"codigo":"lijadora de banda este 2","capacidad":1,"tipoEquipo":{"id":2,"nombre":"lijadora de banda"}},
            {"id":12,"codigo":"mesa ensamblado este","capacidad":3,"tipoEquipo":{"id":3,"nombre":"mesa ensamblado"}},
            {"id":13,"codigo":"fresadora este 1","capacidad":1,"tipoEquipo":{"id":4,"nombre":"fresadora"}},
            {"id":14,"codigo":"fresadora este 2","capacidad":3,"tipoEquipo":{"id":4,"nombre":"fresadora"}},
            {"id":15,"codigo":"Cepillo Garlopa este 1","capacidad":1,"tipoEquipo":{"id":5,"nombre":"Cepillo Garlopa"}},
            {"id":16,"codigo":"Cepillo Garlopa este 2","capacidad":1,"tipoEquipo":{"id":5,"nombre":"Cepillo Garlopa"}}
         ]
      },
      {"id":3,"codigo":"sur",
         "equipos":[
            {"id":17,"codigo":"cierra sur","capacidad":1,"tipoEquipo":{"id":1,"nombre":"cierra"}},
            {"id":18,"codigo":"lijadora de banda sur","capacidad":1,"tipoEquipo":{"id":2,"nombre":"lijadora de banda"}},
            {"id":19,"codigo":"mesa ensamblado sur","capacidad":1,"tipoEquipo":{"id":3,"nombre":"mesa ensamblado"}},
            {"id":20,"codigo":"fresadora sur","capacidad":1,"tipoEquipo":{"id":4,"nombre":"fresadora"}},
            {"id":21,"codigo":"Cepillo Garlopa sur","capacidad":1,"tipoEquipo":{"id":5,"nombre":"Cepillo Garlopa"}},
            {"id":22,"codigo":"dobladora sur","capacidad":1,"tipoEquipo":{"id":6,"nombre":"dobladora"}}
         ]
      },
      {"id":4,"codigo":"oeste",
         "equipos":[
            {"id":23,"codigo":"cierra oeste 1","capacidad":1,"tipoEquipo":{"id":1,"nombre":"cierra"}},
            {"id":24,"codigo":"cierra oeste 2","capacidad":1,"tipoEquipo":{"id":1,"nombre":"cierra"}},
            {"id":25,"codigo":"lijadora de banda oeste 1","capacidad":1,"tipoEquipo":{"id":2,"nombre":"lijadora de banda"}},
            {"id":26,"codigo":"lijadora de banda oeste 2","capacidad":1,"tipoEquipo":{"id":2,"nombre":"lijadora de banda"}},
            {"id":27,"codigo":"mesa ensamblado oeste 1","capacidad":1,"tipoEquipo":{"id":3,"nombre":"mesa ensamblado"}},
            {"id":28,"codigo":"mesa ensamblado oeste 2","capacidad":1,"tipoEquipo":{"id":3,"nombre":"mesa ensamblado"}},
            {"id":29,"codigo":"fresadora oeste 1","capacidad":1,"tipoEquipo":{"id":4,"nombre":"fresadora"}},
            {"id":30,"codigo":"fresadora oeste 2","capacidad":1,"tipoEquipo":{"id":4,"nombre":"fresadora"}},
            {"id":31,"codigo":"Cepillo Garlopa oeste 1","capacidad":1,"tipoEquipo":{"id":5,"nombre":"Cepillo Garlopa"}},
            {"id":32,"codigo":"Cepillo Garlopa oeste 2","capacidad":1,"tipoEquipo":{"id":5,"nombre":"Cepillo Garlopa"}},
            {"id":33,"codigo":"dobladora oeste 1","capacidad":1,"tipoEquipo":{"id":6,"nombre":"dobladora"}},
            {"id":34,"codigo":"dobladora oeste 2","capacidad":1,"tipoEquipo":{"id":6,"nombre":"dobladora"}}
         ]
      },
      {"id":5,"codigo":"centro",
         "equipos":[
            {"id":35,"codigo":"cierra centro","capacidad":2,"tipoEquipo":{"id":1,"nombre":"cierra"}},
            {"id":36,"codigo":"fresadora centro","capacidad":2,"tipoEquipo":{"id":4,"nombre":"fresadora"}},
            {"id":37,"codigo":"Cepillo Garlopa centro","capacidad":2,"tipoEquipo":{"id":5,"nombre":"Cepillo Garlopa"}}
         ]
      }
   ]
}
"""

Cuando se solicita la lista de talleres que pueden realizar el producto <idProducto>
Entonces se obtiene la siguiente lista de talleres por producto <respuesta>

Ejemplos:
| idProducto               | respuesta                                                                                                                                                                                    |
| 1                        | {"Status Code": 200, "Status Text": "Talleres por producto recuperados con éxito", "data":{{"codigo":"norte"},{"codigo":"este"},{"codigo":"sur"},{"codigo":"oeste"}}}                        |
| 2                        | {"Status Code": 200, "Status Text": "Talleres por producto recuperados con éxito", "data":{{"codigo":"norte"},{"codigo":"este"},{"codigo":"sur"},{"codigo":"oeste"}}}                        |
| 3                        | {"Status Code": 200, "Status Text": "Talleres por producto recuperados con éxito", "data":{{"codigo":"norte"},{"codigo":"este"},{"codigo":"sur"},{"codigo":"oeste"}}}                        |
| 4                        | {"Status Code": 200, "Status Text": "Talleres por producto recuperados con éxito", "data":{{"codigo":"norte"},{"codigo":"este"},{"codigo":"sur"},{"codigo":"oeste"}}}                        |
| 5                        | {"Status Code": 200, "Status Text": "Talleres por producto recuperados con éxito", "data":{{"codigo":"norte"},{"codigo":"este"},{"codigo":"sur"},{"codigo":"oeste"},{"codigo":"centro"}}}    |
| 6                        | {"Status Code": 200, "Status Text": "Talleres por producto recuperados con éxito", "data":{{"codigo":"norte"},{"codigo":"este"},{"codigo":"sur"},{"codigo":"oeste"},{"codigo":"centro"}}}    |
| 7                        | {"Status Code": 200, "Status Text": "Talleres por producto recuperados con éxito", "data":{{"codigo":"norte"},{"codigo":"este"},{"codigo":"sur"},{"codigo":"oeste"},{"codigo":"centro"}}}    |
| 8                        | {"Status Code": 200, "Status Text": "Talleres por producto recuperados con éxito", "data":{{"codigo":"norte"},{"codigo":"este"},{"codigo":"sur"},{"codigo":"oeste"}}}                        |
| 9                        | {"Status Code": 200, "Status Text": "Talleres por producto recuperados con éxito", "data":{{"codigo":"norte"},{"codigo":"este"},{"codigo":"sur"},{"codigo":"oeste"}}}                        |
| 10                       | {"Status Code": 200, "Status Text": "Talleres por producto recuperados con éxito", "data":{{"codigo":"sur"},{"codigo":"oeste"}}}                                                             |