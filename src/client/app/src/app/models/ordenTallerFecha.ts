import { Taller } from './taller';

export interface OrdenTallerFecha {
    ordenId: number;
    pedidoId: number;
    taller: Taller;
    fechaInicio: Date;
    fechaFin: Date;
}