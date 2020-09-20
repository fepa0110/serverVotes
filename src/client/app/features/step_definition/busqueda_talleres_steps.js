const assert = require('assert');
const { Given, When, Then } = require('cucumber');
const request = require('sync-request');
const jsondiff = require('json-diff');
const deleteKey = require('key-del');
const urlServer = 'http://server:8080/labprog-server/rest';

let response;
When('se solicita la lista de talleres que pueden realizar el producto {int}',
    function (idProducto) {
        try {
            let res = request('GET', urlServer + '/talleres' + '/findByProducto/' + idProducto);
            response = JSON.parse(res.getBody());

            if (response.StatusCode === 200) {
                return true;
            } 
            else {
                return assert.fail(response.StatusText);
            }
        }
        catch (error) {
            return assert.fail(error.message);
        }
    }
);

Then('se obtiene la siguiente lista de talleres por producto {string}', function(respuesta) {
    
        let jsonEsperado = JSON.parse(respuesta);

/*     response = deleteKey(response, 'id');
    response = deleteKey(response, 'equipos'); */

        if (response.StatusCode == 200) {
            return assert.equal(undefined, jsondiff.diff(response.data, jsonEsperado.data));
        } else {
            return assert.fail(response.StatusText);
        }
    }
);
