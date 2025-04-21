package sisrh.soap;

import sisrh.banco.Banco;
import sisrh.dto.Empregado;
import sisrh.dto.Empregados;
import sisrh.dto.Solicitacao;
import sisrh.dto.Solicitacoes;
import sisrh.exception.SISRHException;
import sisrh.seguranca.Autenticador;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.WebServiceContext;
import java.util.List;

@WebService
@SOAPBinding(style = Style.RPC)
public class ServicoEmpregado {

    @Resource
    WebServiceContext context;

    @WebMethod(action = "listar")
    public Empregados listar() throws Exception {
        Autenticador.autenticarUsuarioSenha(context);
        Empregados empregados = new Empregados();

        List<Empregado> lista = Banco.listarEmpregados();
        for(Empregado emp: lista) {
            empregados.getEmpregados().add(emp);
        }
        return empregados;
    }

    @WebMethod(action = "listarAtivos")
    public Empregados listarAtivos() throws Exception {
        Autenticador.autenticarUsuarioSenha(context);
        Empregados empregados = new Empregados();

        List<Empregado> lista = Banco.listarEmpregados();
        for(Empregado emp: lista) {
            if(emp.getDesligamento() == null){
                empregados.getEmpregados().add(emp);
            }
        }
        return empregados;
    }
    @WebMethod(action = "listarInativos")
    public  Empregados listarInativos() throws Exception {
        Autenticador.autenticarUsuarioSenha(context);
        Empregados empregados = new Empregados();

        List<Empregado> lista = Banco.listarEmpregados();
        for(Empregado emp: lista) {
            if(emp.getDesligamento() != null){
                empregados.getEmpregados().add(emp);
            }
        }
        return empregados;
    }

    @WebMethod(action= "listarSolicitacoesPorUsuario")
        public Solicitacoes listarSolicitacoes(String nome) throws Exception {
            Autenticador.autenticarUsuarioSenha(context);
            Solicitacoes solicitacoes = new Solicitacoes();

            if (nome == null || nome.trim().isEmpty()) {
                throw new IllegalArgumentException("Nome do empregado não pode ser vazio.");
            }

            List<Solicitacao> lista = Banco.listarSolicitacoes();
            for(Solicitacao sol : lista) {
                solicitacoes.getSolicitacoes().add(sol);
            }
            return solicitacoes;
        }
}
