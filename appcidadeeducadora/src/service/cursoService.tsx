import axios from 'axios';
import Curso from '... @/core/Curso';

interface ApiResponse {
    content: Curso[];
}

const BASE_URL = 'http://localhost:8080';
export const fetchCursos = async (): Promise<Curso[]> => {
    try {
        const response = await axios.get<ApiResponse>(`${BASE_URL}/cursos`);
        return response.data.content;
    } catch (error) {
        throw new Error('Erro ao buscar cursos');
    }
};

export const cadastrarCurso = async (curso: Curso): Promise<Curso> => {
    try {
        const response = await axios.post<Curso>(`${BASE_URL}/cursos`, curso);
        return response.data;
    } catch (error) {
        console.error("Erro ao cadastrar curso:", error);
        throw error;
    }
};

export const atualizarCurso = async (curso: Curso): Promise<Curso> => {
    try {
        const response = await axios.put<Curso>(
            `${BASE_URL}/cursos/${curso.id}`, curso);
        return response.data;
    } catch (error) {
        console.error("Erro ao atualizar curso:", error);
        throw error;
    }
};

export const excluirCurso = async (id: number): Promise<void> => {
    try {
        await axios.delete(`${BASE_URL}/cursos/${id}`);
    } catch (error) {
        console.error("Erro ao excluir curso:", error);
        throw error;
    }
};