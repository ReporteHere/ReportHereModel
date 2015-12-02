/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reportHere.model;

import reportHere.model.base.service.BaseDepartamentoOcorrenciaService;
import reportHere.model.base.service.BaseFuncionarioService;
import reportHere.model.base.service.BaseMensagemService;
import reportHere.model.base.service.BaseOcorrenciaService;
import reportHere.model.base.service.BasePerfilService;
import reportHere.model.base.service.BaseStatusOcorrenciaService;
import reportHere.model.base.service.BaseStatusService;
import reportHere.model.base.service.BaseTarefaService;
import reportHere.model.base.service.BaseTipoOcorrenciaService;
import reportHere.model.base.service.BaseTipoUsuarioService;
import reportHere.model.base.service.BaseUsuarioService;
import reportHere.model.service.DepartamentoOcorrenciaService;
import reportHere.model.service.FuncionaroService;
import reportHere.model.service.MensagemService;
import reportHere.model.service.OcorrenciaService;
import reportHere.model.service.PerfilService;
import reportHere.model.service.StatusOcorrenciaService;
import reportHere.model.service.StatusService;
import reportHere.model.service.TarefaService;
import reportHere.model.service.TipoOcorrenciaService;
import reportHere.model.service.TipoUsuarioService;
import reportHere.model.service.UsuarioService;

public class ServiceLocator {

    public static BaseDepartamentoOcorrenciaService getDepartamentoOcorrenciaService() {
        return new DepartamentoOcorrenciaService();
    }

    public static BaseFuncionarioService getFuncionarioService() {
        return new FuncionaroService();
    }

    public static BaseMensagemService getMensagemService() {
        return new MensagemService();
    }

    public static BaseOcorrenciaService getOcorrenciaService() {
        return new OcorrenciaService();
    }

    public static BasePerfilService getPerfilService() {
        return new PerfilService();
    }

    public static BaseStatusOcorrenciaService getStatusOcorrenciaService(){
        return new StatusOcorrenciaService();
    }

    public static BaseStatusService getStatusService(){
        return new StatusService();
    }

    public static BaseTarefaService getTarefaService(){
        return new TarefaService();
    }

    public static BaseTipoOcorrenciaService getTipoOcorrenciaService() {
        return new TipoOcorrenciaService();
    }

    public static BaseTipoUsuarioService getTipoUsuarioService(){
        return new TipoUsuarioService();
    }

    public static BaseUsuarioService getUsuarioService(){
        return new UsuarioService();
    }
}
