# language: es

Característica: administrar pedidos de fabricación
   permite generar, recuperar y gestionar los pedidos de fabricación

   Esquema del escenario: Generar nuevos pedidos de fabricación
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
      ]
   }
"""
   
   Y los siguientes clientes
   """
   {
      "clientes":[
         {"id":1,"nombre":"prilidiano pueyrredon","cuit": "1000000001"},
         {"id":2,"nombre":"marcelo t. de alvear","cuit": "2000000002"},
         {"id":3,"nombre":"domingo faustino sarmiento","cuit": "3000000003"},
         {"id":4,"nombre":"walter runciman","cuit": "4000000004"},
         {"id":5,"nombre":"julio argentino roca","cuit": "5000000005"}
      ]
   }
   """
   
   Cuando se solicita generar un pedido al cliente <idCliente> con fecha de pedido <fechaPedido> para entregar en la fecha <fechaEntrega> la cantidad de <cantidad> del producto <idProducto>
   Entonces se obtiene el siguiente resultado <respuesta>

   Ejemplos:
   | idCliente | fechaPedido  | fechaEntrega | cantidad | idProducto               | respuesta |
   | 1         | "2020-05-04" | "2020-05-29" | 10       | 1                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":1, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-29","cantidad":10, "producto":{"id":1,"nombre":"mesa 1.80x0.70"}}}'   |
   | 1         | "2020-05-04" | "2020-05-29" | 20       | 2                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":2, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-29","cantidad":20, "producto":{"id":2,"nombre":"mesa 2x1"}}}'        |     
   | 1         | "2020-05-04" | "2020-05-29" | 25       | 3                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":3, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-29","cantidad":25, "producto":{"id":3,"nombre":"silla estándar"}}}'   |     
   | 1         | "2020-05-04" | "2020-05-29" | 30       | 4                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":4, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-29","cantidad":30, "producto":{"id":4,"nombre":"banqueta"}}}'         |     
   | 1         | "2020-05-04" | "2020-05-29" | 23       | 5                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":5, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-29","cantidad":23, "producto":{"id":5,"nombre":"zocalos de 1.5m"}}}'  |     
   | 1         | "2020-05-04" | "2020-05-29" | 40       | 6                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":6, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-29","cantidad":40, "producto":{"id":6,"nombre":"zocalos de 2m"}}}'    |     
   | 2         | "2020-05-04" | "2020-05-30" | 50       | 1                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":7, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":50, "producto":{"id":1,"nombre":"mesa 1.80x0.70"}}}'   |
   | 2         | "2020-05-04" | "2020-05-30" | 70       | 2                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":8, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":70, "producto":{"id":2,"nombre":"mesa 2x1"}}}'         |     
   | 2         | "2020-05-04" | "2020-05-30" | 95       | 3                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":9, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":95, "producto":{"id":3,"nombre":"silla estándar"}}}'   |     
   | 2         | "2020-05-04" | "2020-05-30" | 130      | 4                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":10,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":130,"producto":{"id":4,"nombre":"banqueta"}}}'         |     
   | 2         | "2020-05-04" | "2020-05-30" | 123      | 5                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":11,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":123,"producto":{"id":5,"nombre":"zocalos de 1.5m"}}}'  |     
   | 2         | "2020-05-04" | "2020-05-30" | 140      | 6                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":12,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":140,"producto":{"id":6,"nombre":"zocalos de 2m"}}}'    |     
   | 2         | "2020-05-04" | "2020-05-30" | 100      | 9                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":13,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":100,"producto":{"id":9,"nombre":"puerta doble"}}}'     |     
   | 2         | "2020-05-04" | "2020-05-30" | 150      | 10                       | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":14,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":150,"producto":{"id":10,"nombre":"perchero de pie"}}}' |     
   | 3         | "2020-05-04" | "2020-05-28" | 250      | 1                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":15,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-04","fechaEntrega":"2020-05-28","cantidad":250,"producto":{"id":1,"nombre":"mesa 1.80x0.70"}}}'   |
   | 3         | "2020-05-04" | "2020-05-28" | 270      | 2                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":16,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-04","fechaEntrega":"2020-05-28","cantidad":270,"producto":{"id":2,"nombre":"mesa 2x1"}}}'         |     
   | 3         | "2020-05-04" | "2020-05-28" | 295      | 3                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":17,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-04","fechaEntrega":"2020-05-28","cantidad":295,"producto":{"id":3,"nombre":"silla estándar"}}}'   |     
   | 3         | "2020-05-04" | "2020-05-28" | 330      | 4                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":18,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-04","fechaEntrega":"2020-05-28","cantidad":330,"producto":{"id":4,"nombre":"banqueta"}}}'         |     
   | 3         | "2020-05-04" | "2020-05-28" | 323      | 5                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":19,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-04","fechaEntrega":"2020-05-28","cantidad":323,"producto":{"id":5,"nombre":"zocalos de 1.5m"}}}'  |     
   | 3         | "2020-05-04" | "2020-05-28" | 340      | 6                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":20,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-04","fechaEntrega":"2020-05-28","cantidad":340,"producto":{"id":6,"nombre":"zocalos de 2m"}}}'    |     
   | 3         | "2020-05-04" | "2020-05-28" | 300      | 7                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":21,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-04","fechaEntrega":"2020-05-28","cantidad":300,"producto":{"id":7,"nombre":"zocalos de 2.5m"}}}'  |     
   | 3         | "2020-05-04" | "2020-05-28" | 350      | 8                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":22,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-04","fechaEntrega":"2020-05-28","cantidad":350,"producto":{"id":8,"nombre":"puerta estándar"}}}'  |     
   | 4         | "2020-05-04" | "2020-05-31" | 150      | 1                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":23,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":150,"producto":{"id":1,"nombre":"mesa 1.80x0.70"}}}'   |
   | 4         | "2020-05-04" | "2020-05-31" | 170      | 2                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":24,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":170,"producto":{"id":2,"nombre":"mesa 2x1"}}}'        |     
   | 4         | "2020-05-04" | "2020-05-31" | 195      | 3                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":25,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":195,"producto":{"id":3,"nombre":"silla estándar"}}}'   |     
   | 4         | "2020-05-04" | "2020-05-31" | 230      | 4                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":26,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":230,"producto":{"id":4,"nombre":"banqueta"}}}'        |     
   | 4         | "2020-05-04" | "2020-05-31" | 223      | 5                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":27,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":223,"producto":{"id":5,"nombre":"zocalos de 1.5m"}}}'  |     
   | 4         | "2020-05-04" | "2020-05-31" | 240      | 6                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":28,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":240,"producto":{"id":6,"nombre":"zocalos de 2m"}}}'    |     
   | 4         | "2020-05-04" | "2020-05-31" | 200      | 7                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":29,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":200,"producto":{"id":7,"nombre":"zocalos de 2.5m"}}}'  |     
   | 4         | "2020-05-04" | "2020-05-31" | 250      | 8                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":30,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":250,"producto":{"id":8,"nombre":"puerta estándar"}}}'  |     
   | 4         | "2020-05-04" | "2020-05-31" | 200      | 9                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":31,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":200,"producto":{"id":9,"nombre":"puerta doble"}}}'     |     
   | 4         | "2020-05-04" | "2020-05-31" | 250      | 10                       | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":32,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":250,"producto":{"id":10,"nombre":"perchero de pie"}}}' |     
   | 5         | "2020-05-04" | "2020-05-30" | 400      | 7                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":33,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":5,"nombre":"julio argentino roca","mail":"jaroca@gmail.com"},           "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":400,"producto":{"id":7,"nombre":"zocalos de 2.5m"}}}'  |     
   | 5         | "2020-05-04" | "2020-05-30" | 450      | 8                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":34,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":5,"nombre":"julio argentino roca","mail":"jaroca@gmail.com"},           "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":450,"producto":{"id":8,"nombre":"puerta estándar"}}}'  |     
   | 5         | "2020-05-04" | "2020-05-30" | 400      | 9                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":35,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":5,"nombre":"julio argentino roca","mail":"jaroca@gmail.com"},           "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":400,"producto":{"id":9,"nombre":"puerta doble"}}}'     |     
   | 5         | "2020-05-20" | "2020-06-06" | 450      | 10                       | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":36,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":5,"nombre":"julio argentino roca","mail":"jaroca@gmail.com"},           "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":450,"producto":{"id":10,"nombre":"perchero de pie"}}}' |     
   | 1         | "2020-05-20" | "2020-06-06" | 10       | 1                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":37,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":10, "producto":{"id":1,"nombre":"mesa 1.80x0.70"}}}'   |
   | 1         | "2020-05-20" | "2020-06-06" | 20       | 2                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":38,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":20, "producto":{"id":2,"nombre":"mesa 2x1"}}}'         |     
   | 1         | "2020-05-20" | "2020-06-06" | 25       | 3                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":39,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":25, "producto":{"id":3,"nombre":"silla estándar"}}}'   |     
   | 1         | "2020-05-20" | "2020-06-06" | 30       | 4                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":40,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":30, "producto":{"id":4,"nombre":"banqueta"}}}'         |     
   | 1         | "2020-05-20" | "2020-06-06" | 23       | 5                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":41,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":23, "producto":{"id":5,"nombre":"zocalos de 1.5m"}}}'  |     
   | 1         | "2020-05-20" | "2020-06-06" | 40       | 6                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":42,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":40, "producto":{"id":6,"nombre":"zocalos de 2m"}}}'    |     
   | 2         | "2020-05-20" | "2020-06-06" | 50       | 1                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":43,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":50  ,"producto":{"id":1,"nombre":"mesa 1.80x0.70"}}}'  |
   | 2         | "2020-05-20" | "2020-06-06" | 70       | 2                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":44,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":70  ,"producto":{"id":2,"nombre":"mesa 2x1"}}}'        |     
   | 2         | "2020-05-20" | "2020-06-06" | 95       | 3                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":45,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":95  ,"producto":{"id":3,"nombre":"silla estándar"}}}'  |     
   | 2         | "2020-05-20" | "2020-06-06" | 130      | 4                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":46,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":130,"producto":{"id":4,"nombre":"banqueta"}}}'         |     
   | 2         | "2020-05-20" | "2020-06-06" | 123      | 5                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":47,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":123,"producto":{"id":5,"nombre":"zocalos de 1.5m"}}}'  |     
   | 2         | "2020-05-20" | "2020-06-06" | 140      | 6                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":48,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":140,"producto":{"id":6,"nombre":"zocalos de 2m"}}}'    |     
   | 2         | "2020-05-20" | "2020-06-06" | 100      | 9                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":49,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":100,"producto":{"id":9,"nombre":"puerta doble"}}}'     |     
   | 2         | "2020-05-20" | "2020-06-06" | 150      | 10                       | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":50,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":150,"producto":{"id":10,"nombre":"perchero de pie"}}}' |     
   | 3         | "2020-05-20" | "2020-06-06" | 250      | 1                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":51,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":250,"producto":{"id":1,"nombre":"mesa 1.80x0.70"}}}'   |
   | 3         | "2020-05-20" | "2020-06-06" | 270      | 2                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":52,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":270,"producto":{"id":2,"nombre":"mesa 2x1"}}}'        |     
   | 3         | "2020-05-20" | "2020-06-06" | 295      | 3                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":53,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":295,"producto":{"id":3,"nombre":"silla estándar"}}}'   |     
   | 3         | "2020-05-20" | "2020-06-06" | 330      | 4                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":54,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":330,"producto":{"id":4,"nombre":"banqueta"}}}'         |     
   | 3         | "2020-05-20" | "2020-06-06" | 323      | 5                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":55,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":323,"producto":{"id":5,"nombre":"zocalos de 1.5m"}}}'  |     
   | 3         | "2020-05-20" | "2020-06-06" | 340      | 6                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":56,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":340,"producto":{"id":6,"nombre":"zocalos de 2m"}}}'    |     
   | 3         | "2020-05-20" | "2020-06-06" | 300      | 7                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":57,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":300,"producto":{"id":7,"nombre":"zocalos de 2.5m"}}}'  |     
   | 3         | "2020-05-20" | "2020-06-06" | 350      | 8                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":58,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":350,"producto":{"id":8,"nombre":"puerta estándar"}}}'  |     
   | 4         | "2020-05-20" | "2020-06-06" | 150      | 1                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":59,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":150,"producto":{"id":1,"nombre":"mesa 1.80x0.70"}}}'   |
   | 4         | "2020-05-20" | "2020-06-06" | 170      | 2                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":60,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":170,"producto":{"id":2,"nombre":"mesa 2x1"}}}'        |     
   | 4         | "2020-05-20" | "2020-06-06" | 195      | 3                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":61,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":195,"producto":{"id":3,"nombre":"silla estándar"}}}'   |     
   | 4         | "2020-05-20" | "2020-06-06" | 230      | 4                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":62,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":230,"producto":{"id":4,"nombre":"banqueta"}}}'         |     
   | 4         | "2020-05-20" | "2020-06-06" | 223      | 5                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":63,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":223,"producto":{"id":5,"nombre":"zocalos de 1.5m"}}}'  |     
   | 4         | "2020-05-20" | "2020-06-06" | 240      | 6                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":64,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":240,"producto":{"id":6,"nombre":"zocalos de 2m"}}}'    |     
   | 4         | "2020-05-20" | "2020-06-06" | 200      | 7                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":65,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":200,"producto":{"id":7,"nombre":"zocalos de 2.5m"}}}'  |     
   | 4         | "2020-05-20" | "2020-06-06" | 250      | 8                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":66,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":250,"producto":{"id":8,"nombre":"puerta estándar"}}}'  |     
   | 4         | "2020-05-20" | "2020-06-06" | 200      | 9                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":67,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":200,"producto":{"id":9,"nombre":"puerta doble"}}}'     |     
   | 4         | "2020-05-20" | "2020-06-06" | 250      | 10                       | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":68,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":250,"producto":{"id":10,"nombre":"perchero de pie"}}}' |     
   | 5         | "2020-05-20" | "2020-06-06" | 400      | 7                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":69,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":5,"nombre":"julio argentino roca","mail":"jaroca@gmail.com"},           "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":400,"producto":{"id":7,"nombre":"zocalos de 2.5m"}}}'  |     
   | 5         | "2020-05-20" | "2020-06-06" | 450      | 8                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":70,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":5,"nombre":"julio argentino roca","mail":"jaroca@gmail.com"},           "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":450,"producto":{"id":8,"nombre":"puerta estándar"}}}'  |     
   | 5         | "2020-05-20" | "2020-06-06" | 400      | 9                        | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":71,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":5,"nombre":"julio argentino roca","mail":"jaroca@gmail.com"},           "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":400,"producto":{"id":9,"nombre":"puerta doble"}}}'     |     
   | 5         | "2020-05-20" | "2020-06-06" | 450      | 10                       | '{"Status Code": 200, "Status Text": "Pedido de fabricación GENERADO correctamente","data":{"id":72,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":5,"nombre":"julio argentino roca","mail":"jaroca@gmail.com"},           "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":450,"producto":{"id":10,"nombre":"perchero de pie"}}}' | 