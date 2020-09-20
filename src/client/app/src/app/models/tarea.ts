import { TipoEquipo } from "./tipoEquipo";

export interface Tarea{
    id: number;
    nombre: string;
    orden: number;
    tiempo: number;
    tipoEquipo: TipoEquipo;
}