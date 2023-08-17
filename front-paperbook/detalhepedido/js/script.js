function exibirDetalhePedido() {

    let lstdetalhespedidos = document.getElementById("lstDetalhesPedidos");
    let dados = "";

    fetch("http://127.0.0.1:5000/api/v1/detalhepedido/listar")
    .then((response) => response.json())
    .then((rs)=>{
        console.log(rs);
        rs.map((itens, ix)=>{
            dados += `<ul id="itempedido">
                                <li>${itens.iddetalhepedido}</li>
                                <li>${itens.quantidade}</li>
                                <li>${itens.precounitario}</li>
                                <li>${itens.valortotal}</li>
                     </ul> `;
            lstdetalhespedidos.innerHTML += dados;
        })
    }).catch((err)=>console.error(err));
}
