import { stringParaEntradaDeData } from "... @/util/converters";

export default class Curso {
    id: number | null;
    nome: string;
    data: string;
    descricao: string;
    status: string;

    constructor(id: number | null, nome: string, data: string,
        descricao: string, status: string) 
    {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.descricao = descricao;
        this.status = status;
    }

    static geraCursosMock() {
        return [
            new Curso(
                1, "Desenvolvimento de algoritmos genéticos com C++",
                "10/11/2024", "Aprenda programação avançada em C++ focada em algoritmos genéticos evolutivos!",
                "ABERTO",
            ),
            new Curso(
                2, "Aprenda QA e automações com Ruby",
                "10/11/2024", "Aprenda e use metodologias ágeis, ruby avançado, gems, automações e QA com grandes profissionais!",
                "PREVISTO",
            )
        ]
    }

    static vazio(): Curso {
        return new Curso(null, "", stringParaEntradaDeData(""), "", "");
    }
}