#!/bin/bash
./labprog down
echo "Deteniendo docker..."
service docker stop
echo "Iniciando docker..."
service docker start
./labprog up
