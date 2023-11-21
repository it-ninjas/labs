import { Brand } from "./brand.model";
import { Type } from "./type.model";

export interface Bicycle {
    bicycle_id: number;
    name: string;
    value: number;
    type_ids: number[];
    brand_id: number;
}

export interface FullBicycle {
    name: string;
    value: number;
    types: string[];
    brand: string;
}