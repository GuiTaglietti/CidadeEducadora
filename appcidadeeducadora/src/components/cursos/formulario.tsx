import { useState } from "react";
import { stringParaEntradaDeData } from "... @/util/converters"
import Curso from "... @/core/Curso";
import Entrada from "./entrada";
import Botao from "./botao";

interface FormularioProps {
    curso: Curso
    cursoMudou?: (curso: Curso) => void
    cancelado?: () => void
}

export default function Formulario(props: FormularioProps) {
    const id = props.curso?.id
    const [nome, setNome] = useState(props.curso?.nome)
    const [data, setData] = useState(props.curso?.data)
    const [descricao, setDescricao] = useState(props.curso?.descricao)
    const [status, setStatus] = useState(props.curso?.status)
    return (
        <div>
            {id ? (<Entrada texto="ID" valor={id} somenteLeitura ></Entrada>) : false}
            <Entrada texto="Nome" valor={nome} onChange={setNome}></Entrada>
            <Entrada texto="Data" tipo="date" valor={stringParaEntradaDeData(data)}
                onChange={setData}></Entrada>
            <Entrada texto="Descricao" valor={descricao} onChange={setDescricao}></Entrada>
            <Entrada texto="Status" valor={status} onChange={setStatus}></Entrada>
            <div className="flex justify-end mt-5" >
                <Botao className="mr-3 bg-purple-800 text-white"
                    onClick={() => props.cursoMudou?.(new Curso(
                        id, nome, data, descricao, status))}>
                    {id ? 'Alterar' : 'Salvar'}
                </Botao>
                <Botao className="bg-white text-purple-800"
                    onClick={props.cancelado}> Cancelar
                </Botao>
            </div>
        </div>
    )
}