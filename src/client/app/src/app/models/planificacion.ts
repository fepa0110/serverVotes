import { Tarea } from './tarea';
import { OrdenTrabajo } from "./ordenTrabajo";
import { Equipo } from "./equipo";

export interface Planificacion{
    id: number;
    inicio: Date;
    fin: Date;
    ordenTrabajo: OrdenTrabajo;
    equipo: Equipo;
    tarea: Tarea;
}