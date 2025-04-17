package sisrh.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Solicitacoes {

    @XmlElement(name = "solicitacoes")
    private List<Solicitacao> solicitacoes =  new ArrayList<Solicitacao>();

    public List<Solicitacao> getSolicitacoes(){
        return solicitacoes;
    }
}
