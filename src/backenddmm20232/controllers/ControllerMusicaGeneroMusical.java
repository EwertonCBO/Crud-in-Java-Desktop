/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.controllers;

import backenddmm20232.models.beans.Musica;
import backenddmm20232.models.beans.GeneroMusical;
import backenddmm20232.models.beans.MusicaGeneroMusical;
import backenddmm20232.models.daos.DaoMusicaGeneroMusical;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Professor
 */
public class ControllerMusicaGeneroMusical {
    
     DaoMusicaGeneroMusical daoMg;

    public MusicaGeneroMusical inserir(MusicaGeneroMusical musiGen) throws SQLException, ClassNotFoundException {
        daoMg = new DaoMusicaGeneroMusical();
        return daoMg.inserir(musiGen);
    }

    public MusicaGeneroMusical alterar(MusicaGeneroMusical musiGen) throws SQLException, ClassNotFoundException {
        daoMg = new DaoMusicaGeneroMusical();
        return daoMg.alterar(musiGen);
    }

    public MusicaGeneroMusical excluir(MusicaGeneroMusical musiGen) throws SQLException, ClassNotFoundException {
        daoMg = new DaoMusicaGeneroMusical();
        return daoMg.excluir(musiGen);
    }

    public MusicaGeneroMusical buscar(MusicaGeneroMusical musiGen) throws SQLException, ClassNotFoundException {
        daoMg = new DaoMusicaGeneroMusical();
        MusicaGeneroMusical mgSaida = daoMg.buscar(musiGen);
        
        ControllerMusica contMusi = new ControllerMusica();
        Musica usuEnt = new Musica(mgSaida.getIdMusi());
        mgSaida.setMusi(contMusi.buscar(usuEnt));
        
        ControllerGeneroMusical contGen = new ControllerGeneroMusical();
        GeneroMusical genEnt = new GeneroMusical(mgSaida.getIdGen());
        
        mgSaida.setGen(contGen.buscar(genEnt));
        
        return mgSaida;
    }

    public List<MusicaGeneroMusical> listar(MusicaGeneroMusical musiGen) throws SQLException, ClassNotFoundException {
        daoMg = new DaoMusicaGeneroMusical();
        List<MusicaGeneroMusical> listamusiGenemaAux = daoMg.listar(musiGen);
        List<MusicaGeneroMusical> listamusiGenemaSaida = new ArrayList<>();
        
        for (MusicaGeneroMusical usuSisSaida : listamusiGenemaAux) {
            listamusiGenemaSaida.add(buscar(usuSisSaida));
        }
        
        return listamusiGenemaSaida;
    }

    
}
