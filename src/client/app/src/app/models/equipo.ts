import { TipoEquipo } from './tipoEquipo';
import { Planificacion } from './planificacion';

export interface Equipo{
    id: number;
    codigo: string;
    capacidad: number;
    tipoEquipo: TipoEquipo;
    planificaciones: Planificacion[];
}