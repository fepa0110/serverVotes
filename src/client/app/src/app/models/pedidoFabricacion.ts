import { Cliente } from './cliente'
import { Producto } from './producto'
import { OrdenTrabajo } from './ordenTrabajo'

export interface PedidoFabricacion {
    id: number;
    cantidad: number;
    cliente: Cliente;
    estado: string;
    fechaEntrega: Date;
    fechaPedido: Date;
    producto: Producto;
    ordenTrabajos: OrdenTrabajo[];
}