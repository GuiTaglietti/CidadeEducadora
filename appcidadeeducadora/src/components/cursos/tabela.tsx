import Curso from "... @/core/Curso";
import { editIcon, trashIcon } from "../icones/tabela";

interface TabelaProps {
    cursos: Curso[];
    cursoSelecionado?: (curso: Curso) => void
    cursoExcluido?: (curso: Curso) => void
}

export default function Tabela(props: TabelaProps) {
    const exibirAcoes = props.cursoSelecionado || props.cursoExcluido;

    function renderHeader() {
        return (
            <tr>
                <th className="text-left p-3 text-white">ID</th>
                <th className="text-left p-3 text-white">Nome</th>
                <th className="text-left p-3 text-white">Data</th>
                <th className="text-left p-3 text-white">Descricao</th>
                <th className="text-left p-3 text-white">Status</th>
                {exibirAcoes ? <th className="p-3">Ações</th> : false}
            </tr>
        );
    }

    function renderDados() {
        return props.cursos?.map((curso, i) => {
            return (
                <tr
                    key={curso.id}
                    className={`${i % 2 === 0 ? 'bg-purple-900' : 'bg-purple-800'
                        } text-white`}
                >
                    <td className="text-left p-3">{curso.id}</td>
                    <td className="text-left p-3">{curso.nome}</td>
                    <td className="text-left p-3">{curso.data}</td>
                    <td className="text-left p-3">{curso.descricao}</td>
                    <td className="text-left p-3">{curso.status}</td>
                    {exibirAcoes ? renderActions(curso) : false}
                </tr>
            );
        });
    }

    function renderActions(curso: Curso) {
        return (
            <td className="flex justify-center">
                {
                    props.cursoSelecionado
                    ? (<button onClick={() => props.cursoSelecionado?.(curso)}
                      className={`flex justify-center items text-green-600 rounded-full p-2 m-1 mt-3 hover:bg-black`}>{editIcon}</button>)
                    : false
                }
                {
                    props.cursoExcluido
                    ? (<button onClick={() => props.cursoExcluido?.(curso)}
                        className={`flex justify-center items text-red-600 rounded-full p-2 m-1 mt-3 hover:bg-black`}>{trashIcon}</button>)
                    : false
                }
            </td>
        )
    }

    return (
        <table className="w-full rounded-xl overflow-hidden">
            <thead className={`text-white bg-gradient-to-r from-black via-purple-800 to-black`}>
                {renderHeader()}
            </thead>
            <tbody>{renderDados()}</tbody>
        </table>
    );
}
