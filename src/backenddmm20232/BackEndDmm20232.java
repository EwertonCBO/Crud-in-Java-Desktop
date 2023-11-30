/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package backenddmm20232;

import backenddmm20232.views.ManterComentario;
import backenddmm20232.views.ManterGeneroMusical;
import backenddmm20232.views.ManterMusica;
import backenddmm20232.views.ManterPlaylist;
import backenddmm20232.views.ManterSistema;
import backenddmm20232.views.ManterUsuario;
import backenddmm20232.views.ManterUsuariosSistemas;
import java.sql.SQLException;
import javax.swing.JOptionPane;
 

/**
 *
 * @author Aluno
 */
public class BackEndDmm20232 {

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if(ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Inválido");            
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 0 - Sair \n 1 - Usuario \n 2 - Sistema \n 3 - Musica \n 4 - Playlist \n 5 - Gêneros Musicais \n 6 - Comentário \n 7 - UsuáriosSistemas ";

        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        
        switch (num) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
                if (sair > 0) menu();
                break;
            case 1:
                ManterUsuario.menu();
                break;
            case 2:
                ManterSistema.menu();
                break;
            case 3:
                ManterMusica.menu();
                break;
            case 4:
                ManterPlaylist.menu();
                break;
            case 5:
                ManterGeneroMusical.menu();
                break;
            case 6:
                ManterComentario.menu();
                break;
            case 7:
                ManterUsuariosSistemas.menu();
                break;
            default:
                System.out.println("Opção inválido");
        }
    }
    
}

