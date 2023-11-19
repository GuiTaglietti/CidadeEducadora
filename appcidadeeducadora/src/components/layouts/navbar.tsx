import React from "react";

export default function Navbar(props: any) {
    return (
        <>
            <nav className="font-sans flex flex-col text-center sm:flex-row sm:text-left sm:justify-between py-4 px-6 bg-black text-stone-100 shadow sm:items-baseline w-full">
                <div className="mb-2 sm:mb-0">
                        Cidade educadora
                </div>
                <div>
                    <a href="/cursos" className="text-lg no-underline hover:text-purple-500 ml-2"> Home </a>
                    <a href="/cursos" className="text-lg no-underline hover:text-purple-500 ml-2"> Cursos </a>
                </div>
            </nav>
        </>
    );
}