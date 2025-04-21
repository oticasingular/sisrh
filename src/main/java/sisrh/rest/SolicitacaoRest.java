package sisrh.rest;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.swagger.annotations.Api;
import sisrh.banco.Banco;
import sisrh.dto.Empregado;
import sisrh.dto.Solicitacao;
import sisrh.exception.SISRHException;

@Api
@Path("/solicitacoes")
public class SolicitacaoRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarSolicitacoes() {
        try {
            List<Solicitacao> lista = Banco.listarSolicitacoes();
            return Response.ok().entity(lista).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Erro ao listar solicitações.\" }")
                    .build();
        }
    }

    @GET
    @Path("{solicitacaoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarSolicitacaoPorId(@PathParam("solicitacaoId") Integer solicitacaoId) throws Exception {
        try {
            Solicitacao solicitacao =  Banco.buscarSolicitacaoPorId(solicitacaoId);

            if (solicitacao == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{ \"mensagem\" : \"Solicitação não encontrada.\" }")
                        .build();
            }

            return Response.ok().entity(solicitacao).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Erro ao buscar solicitação.\" }")
                    .build();
        }
    }

    // serviço REST para incluir solicitações
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   public Response incluirSolicitacao(Solicitacao solcitacao) throws Exception {
       try {
           Solicitacao solicitacaoFeita = Banco.incluirSolicitacao(solcitacao);
           return Response.ok().entity(solicitacaoFeita).build();
       }catch (Exception e) {
           return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                   .entity("{ \"mensagem\" : \"Falha na inclusao da solicitação!\" , \"detalhe\" :  \""+ e.getMessage() +"\"  }").build();
       }
   }

    @PUT
    @Path("{solicitacaoId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterarSolicitacao(@PathParam("solicitacaoId") Integer id, Solicitacao solicitacao) throws Exception{
        try{
           if (id == null){
               return Response.status(Response.Status.BAD_REQUEST).entity("{ \"mensagem\" : \"É necessário informar um ID de Solicitação.}").build();
           } else {
               Solicitacao solcitacaoAltarada = Banco.alterarSolicitacao(id, solicitacao);
               return Response.ok().entity(solcitacaoAltarada).build();
           }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha na alteração da solicitação!\" , \"detalhe\" :  \""+ e.getMessage() +"\"  }").build();
        }
    }

    @DELETE
    @Path("{solicitacaoId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluirSolicitacao(@PathParam("solicitacaoId") Integer id) throws Exception{
        try{
            if(Banco.buscarSolicitacaoPorId(id) == null){
                return Response.status(Response.Status.NOT_FOUND).entity("{\"mensagem\" : \"Solicitação não encontrada!\" }").build();
            }
            Banco.excluirSolicitacao(id);
            return Response.ok().entity("{ \"mensagem\" : \"Solicitação "+ id + " excluida!\" }").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{ \"mensagem\" : \"Falha na exclusao da solicitação!\" , \"detalhe\" :  \""+ e.getMessage() +"\"  }").build();

        }
    }
}




