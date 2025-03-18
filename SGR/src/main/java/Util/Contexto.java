package Util;

import Model.usuario;

public class Contexto {
    private static usuario usuarioLogado;

    public static void setUsuarioLogado(usuario usuario) {
        usuarioLogado = usuario;
    }

    public static usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void logout() {
        usuarioLogado = null;
    }
}