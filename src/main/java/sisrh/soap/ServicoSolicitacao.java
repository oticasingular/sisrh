package sisrh.soap;

import sisrh.banco.Banco;
import sisrh.dto.Solicitacao;
import sisrh.dto.Solicitacoes;
import sisrh.seguranca.Autenticador;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.WebServiceContext;
import java.util.List;

@WebService
@SOAPBinding(style = Style.RPC)
public class ServicoSolicitacao {

    @Resource
    WebServiceContext context;

    @WebMethod(action = "listarSolicitacoesPorUsuario")
    public Solicitacoes listarSolicitacoes(String nome) throws Exception {
        Autenticador.autenticarUsuarioSenha(context);
        Solicitacoes solicitacoes = new Solicitacoes();

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do empregado não pode ser vazio.");
        }

        List<Solicitacao> lista = Banco.listarSolicitacoesPorUsuario(nome);
        for(Solicitacao sol : lista) {
            solicitacoes.getSolicitacoes().add(sol);
        }
        return solicitacoes;
    }
}
