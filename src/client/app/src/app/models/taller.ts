import { Equipo } from './equipo';

export interface Taller{
    id: number;
    codigo: string;
    equipos: Equipo[];
}