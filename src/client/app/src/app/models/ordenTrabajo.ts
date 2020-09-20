import { Planificacion } from './planificacion';
import { PedidoFabricacion } from "./pedidoFabricacion";

export interface OrdenTrabajo{
    id: number;
    numero: number;
    pedidoFabricacion: PedidoFabricacion;
    planificaciones: Planificacion[];
}