import React, { useState, useEffect } from 'react';
import api from './components/api';


function App() {
  const [nome, setNome] = useState('');

    useEffect(() => {
      async function getData() {
         const resp = await api.get('/consulta/listar')
         console.log(resp.data)
      }
      getData() 
    },[]) 

  async function highpost() {
      
    try {
      
  
      const resp = await api.post("produto/cadastro", {
        nome
      });
      console.log(resp.data);
    } catch (error) {
      console.error('Erro na requisição:', error);
    };
  }
  
  
  return (
    <div>
      <h2>Cadastrar Produto</h2>
      <form onSubmit={highpost}>
        <div>
          <label htmlFor="nome">Nome do Produto:</label>
          <input type="text" id="nome" value={nome} onChange={e=>setNome(e.target.value)}/>
        </div>
        <button type="submit">Cadastrar</button>
      </form>
      
    </div>
  );
}

export default App;