# language: es

Característica: administra planificación de pedidos de fabricación
   Planifica, replanifica pedidos planificados y nuevos generados

Escenario: Planificar pedidos generados
Dados los pedidos generados
"""
{
   "pedidosParaPlanificar":[
      {"id":1, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-29","cantidad":10, "producto":{"id":1,"nombre":"mesa 1.80x0.70"}},  
      {"id":2, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-29","cantidad":20, "producto":{"id":2,"nombre":"mesa 2x1"}},        
      {"id":3, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-29","cantidad":25, "producto":{"id":3,"nombre":"silla estándar"}},  
      {"id":4, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-29","cantidad":30, "producto":{"id":4,"nombre":"banqueta"}},        
      {"id":5, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-29","cantidad":23, "producto":{"id":5,"nombre":"zocalos de 1.5m"}}, 
      {"id":6, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-29","cantidad":40, "producto":{"id":6,"nombre":"zocalos de 2m"}},   
      {"id":7, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":50, "producto":{"id":1,"nombre":"mesa 1.80x0.70"}},  
      {"id":8, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":70, "producto":{"id":2,"nombre":"mesa 2x1"}},        
      {"id":9, "estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":95, "producto":{"id":3,"nombre":"silla estándar"}},  
      {"id":10,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":130,"producto":{"id":4,"nombre":"banqueta"}},        
      {"id":11,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":123,"producto":{"id":5,"nombre":"zocalos de 1.5m"}}, 
      {"id":12,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":140,"producto":{"id":6,"nombre":"zocalos de 2m"}},   
      {"id":13,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":100,"producto":{"id":9,"nombre":"puerta doble"}},    
      {"id":14,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":150,"producto":{"id":10,"nombre":"perchero de pie"}},
      {"id":15,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-04","fechaEntrega":"2020-05-28","cantidad":250,"producto":{"id":1,"nombre":"mesa 1.80x0.70"}},  
      {"id":16,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-04","fechaEntrega":"2020-05-28","cantidad":270,"producto":{"id":2,"nombre":"mesa 2x1"}},        
      {"id":17,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-04","fechaEntrega":"2020-05-28","cantidad":295,"producto":{"id":3,"nombre":"silla estándar"}},  
      {"id":18,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-04","fechaEntrega":"2020-05-28","cantidad":330,"producto":{"id":4,"nombre":"banqueta"}},        
      {"id":19,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-04","fechaEntrega":"2020-05-28","cantidad":323,"producto":{"id":5,"nombre":"zocalos de 1.5m"}}, 
      {"id":20,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-04","fechaEntrega":"2020-05-28","cantidad":340,"producto":{"id":6,"nombre":"zocalos de 2m"}},   
      {"id":21,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-04","fechaEntrega":"2020-05-28","cantidad":300,"producto":{"id":7,"nombre":"zocalos de 2.5m"}}, 
      {"id":22,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-04","fechaEntrega":"2020-05-28","cantidad":350,"producto":{"id":8,"nombre":"puerta estándar"}}, 
      {"id":23,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":150,"producto":{"id":1,"nombre":"mesa 1.80x0.70"}},  
      {"id":24,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":170,"producto":{"id":2,"nombre":"mesa 2x1"}},        
      {"id":25,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":195,"producto":{"id":3,"nombre":"silla estándar"}},  
      {"id":26,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":230,"producto":{"id":4,"nombre":"banqueta"}},        
      {"id":27,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":223,"producto":{"id":5,"nombre":"zocalos de 1.5m"}}, 
      {"id":28,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":240,"producto":{"id":6,"nombre":"zocalos de 2m"}},   
      {"id":29,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":200,"producto":{"id":7,"nombre":"zocalos de 2.5m"}}, 
      {"id":30,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":250,"producto":{"id":8,"nombre":"puerta estándar"}}, 
      {"id":31,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":200,"producto":{"id":9,"nombre":"puerta doble"}},    
      {"id":32,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-31","cantidad":250,"producto":{"id":10,"nombre":"perchero de pie"}},
      {"id":33,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":5,"nombre":"julio argentino roca","mail":"jaroca@gmail.com"},           "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":400,"producto":{"id":7,"nombre":"zocalos de 2.5m"}}, 
      {"id":34,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":5,"nombre":"julio argentino roca","mail":"jaroca@gmail.com"},           "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":450,"producto":{"id":8,"nombre":"puerta estándar"}}, 
      {"id":35,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":5,"nombre":"julio argentino roca","mail":"jaroca@gmail.com"},           "fechaPedido":"2020-05-04","fechaEntrega":"2020-05-30","cantidad":400,"producto":{"id":9,"nombre":"puerta doble"}},    
      {"id":36,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":5,"nombre":"julio argentino roca","mail":"jaroca@gmail.com"},           "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":450,"producto":{"id":10,"nombre":"perchero de pie"}},
      {"id":37,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":10, "producto":{"id":1,"nombre":"mesa 1.80x0.70"}},  
      {"id":38,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":20, "producto":{"id":2,"nombre":"mesa 2x1"}},        
      {"id":39,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":25, "producto":{"id":3,"nombre":"silla estándar"}},  
      {"id":40,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":30, "producto":{"id":4,"nombre":"banqueta"}},        
      {"id":41,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":23, "producto":{"id":5,"nombre":"zocalos de 1.5m"}}, 
      {"id":42,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":1,"nombre":"prilidiano pueyrredon","mail":"ppuerrydon@gmail.com"},      "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":40, "producto":{"id":6,"nombre":"zocalos de 2m"}},   
      {"id":43,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":50  ,"producto":{"id":1,"nombre":"mesa 1.80x0.70"}}, 
      {"id":44,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":70  ,"producto":{"id":2,"nombre":"mesa 2x1"}},       
      {"id":45,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":95  ,"producto":{"id":3,"nombre":"silla estándar"}}, 
      {"id":46,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":130,"producto":{"id":4,"nombre":"banqueta"}},        
      {"id":47,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":123,"producto":{"id":5,"nombre":"zocalos de 1.5m"}}, 
      {"id":48,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":140,"producto":{"id":6,"nombre":"zocalos de 2m"}},   
      {"id":49,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":100,"producto":{"id":9,"nombre":"puerta doble"}},    
      {"id":50,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":2,"nombre":"marcelo t. de alvear","mail":"mtdalvear@gmail.com"},        "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":150,"producto":{"id":10,"nombre":"perchero de pie"}},
      {"id":51,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":250,"producto":{"id":1,"nombre":"mesa 1.80x0.70"}},  
      {"id":52,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":270,"producto":{"id":2,"nombre":"mesa 2x1"}},        
      {"id":53,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":295,"producto":{"id":3,"nombre":"silla estándar"}},  
      {"id":54,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":330,"producto":{"id":4,"nombre":"banqueta"}},        
      {"id":55,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":323,"producto":{"id":5,"nombre":"zocalos de 1.5m"}}, 
      {"id":56,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":340,"producto":{"id":6,"nombre":"zocalos de 2m"}},   
      {"id":57,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":300,"producto":{"id":7,"nombre":"zocalos de 2.5m"}}, 
      {"id":58,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":3,"nombre":"domingo faustino sarmiento","mail":"dfsarmiento@gmail.com"},"fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":350,"producto":{"id":8,"nombre":"puerta estándar"}}, 
      {"id":59,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":150,"producto":{"id":1,"nombre":"mesa 1.80x0.70"}},  
      {"id":60,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":170,"producto":{"id":2,"nombre":"mesa 2x1"}},        
      {"id":61,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":195,"producto":{"id":3,"nombre":"silla estándar"}},  
      {"id":62,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":230,"producto":{"id":4,"nombre":"banqueta"}},        
      {"id":63,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":223,"producto":{"id":5,"nombre":"zocalos de 1.5m"}}, 
      {"id":64,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":240,"producto":{"id":6,"nombre":"zocalos de 2m"}},   
      {"id":65,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":200,"producto":{"id":7,"nombre":"zocalos de 2.5m"}}, 
      {"id":66,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":250,"producto":{"id":8,"nombre":"puerta estándar"}}, 
      {"id":67,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":200,"producto":{"id":9,"nombre":"puerta doble"}},    
      {"id":68,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":4,"nombre":"walter runciman","mail":"wrunciman@gmail.com"},             "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":250,"producto":{"id":10,"nombre":"perchero de pie"}},
      {"id":69,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":5,"nombre":"julio argentino roca","mail":"jaroca@gmail.com"},           "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":400,"producto":{"id":7,"nombre":"zocalos de 2.5m"}}, 
      {"id":70,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":5,"nombre":"julio argentino roca","mail":"jaroca@gmail.com"},           "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":450,"producto":{"id":8,"nombre":"puerta estándar"}}, 
      {"id":71,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":5,"nombre":"julio argentino roca","mail":"jaroca@gmail.com"},           "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":400,"producto":{"id":9,"nombre":"puerta doble"}},    
      {"id":72,"estado":{"id":1,"nombre":"GENERADO"},"cliente":{"id":5,"nombre":"julio argentino roca","mail":"jaroca@gmail.com"},           "fechaPedido":"2020-05-20","fechaEntrega":"2020-06-06","cantidad":450,"producto":{"id":10,"nombre":"perchero de pie"}}
   ]
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

Cuando se solicita planificar todos los pedidos generados a partir de la fecha "2020-05-04"
Entonces se obtiene la siguiente respuesta
"""
{
   "planificacion":[
      
   ]
}
"""