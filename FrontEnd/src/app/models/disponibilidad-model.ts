export interface Disponibilidad {
    id: number;
    hora: string;
    disponibilidad: [{
        datos:[[
            {css:string, dato: string},
            {css:string, dato: string},
            {css:string, dato: string},
            {css:string, dato: string},
            {css:string, dato: string}
        ],
        [
            {css:string, dato: string},
            {css:string, dato: string},
            {css:string, dato: string},
            {css:string, dato: string},
            {css:string, dato: string}
        ]]
    }];
}