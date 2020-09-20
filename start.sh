#!/bin/bash
echo "Iniciando docker"
service docker start
./labprog up
echo "Abriendo bash server..."
./labprog bash server
