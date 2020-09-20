const assert = require('assert');
const { Given, When, Then } = require('cucumber');
const request = require('sync-request');
const jsondiff = require('json-diff');
const deleteKey = require('key-del');

//*PASSED
Given('la siguiente lista de especificaciones de productos', 
      function (especificacionesProductos) {
   try {
      let res = request('GET', 'http://server:8080/labprog-server/rest' + '/productos/especificaciones');

      let body = JSON.parse(res.getBody());
      let espec = JSON.parse(especificacionesProductos);
      
      body.data.productos.forEach((item) => {
            item.tareas.forEach((tarea) => {
               delete tarea.planificaciones;
            })
         }
      );

      body = deleteKey(body, 'id');
      espec = deleteKey(espec, 'id');

      if (body.StatusCode == 200) {
         return assert.equal(undefined, jsondiff.diff(body.data, espec));
      } else {
         return assert.fail(body.StatusText);
      }

   } catch (error) {
      return assert.fail(error.message);
   }

});

//*PASSED
Given('los siguientes clientes', function (clientes) {
   try {
      let res = request('GET', 'http://server:8080/labprog-server/rest' + '/clientes/');

      let body = JSON.parse(res.getBody());
      let clientesJson = JSON.parse(clientes);

      body.data.clientes.forEach((item) =>
         delete item.mail
      );

      if (body.StatusCode == 200) {
         return assert.equal(undefined, jsondiff.diff(body.data, clientesJson));
      } else {
         return assert.fail(body.StatusText);
      }
   } catch (error) {
      return assert.fail(error.message);
   }
});

//*PASSED
let response;
When('se solicita generar un pedido al cliente {int} con fecha de pedido {string} para entregar en la fecha {string} la cantidad de {int} del producto {int}', 
   function (idCliente, fechaPedido, fechaEntrega, cantidad, idProducto) {
      try {
         let res = request('POST', 'http://server:8080/labprog-server/rest' + '/pedidosFabricacion',{
            json:{
               "fechaPedido": fechaPedido,
               "fechaEntrega": fechaEntrega,
               "cantidad": cantidad,
               "cliente": {
                  "id": idCliente
               },
               "producto": {
                  "id": idProducto
               }
            }
         });
         response = JSON.parse(res.getBody());

         delete response.data.cliente["cuit"];
         delete response.data.producto["tareas"];
         delete response.data.ordenTrabajos;

         if (response.data.estado === "GENERADO") {
            response.data.estado = {"id": 1, "nombre": "GENERADO"};
         }

         if (response.StatusCode === 200) {
            return true;
         } else {
            return assert.fail(response.StatusText);
         }
      }
      catch (error) {
         return assert.fail(error.message);
      }
});

//*PASSED
Then('se obtiene el siguiente resultado {string}', function(respuesta) {
   let jsonEsperado = JSON.parse(respuesta);

   jsonEsperado = deleteKey(jsonEsperado, 'id');
   response = deleteKey(response, 'id');

   if (response.StatusCode == 200) {
      return assert.equal(undefined, jsondiff.diff(response.data, jsonEsperado.data));
   } else {
      return assert.fail(response.StatusText);
   }
});
